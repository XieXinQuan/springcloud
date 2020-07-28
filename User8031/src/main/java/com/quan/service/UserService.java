package com.quan.service;

import com.quan.Enum.CommonByteEnum;
import com.quan.Enum.EmailType;
import com.quan.Enum.ResultEnum;
import com.quan.dao.UserRepository;
import com.quan.entity.User;
import com.quan.exception.GlobalException;
import com.quan.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/1
 */
@Service
@Slf4j
public class UserService extends BaseService{

    @Resource
    UserRepository userRepository;

    @Resource
    RedisTemplate redisTemplate;
    @Resource
    RabbitTemplate rabbitTemplate;

//    @Resource
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long registerUser(String name, String email, String password, String code) {
        //先校验Redis Code
        Object redisCode = redisTemplate.opsForValue().get("code-" + email);
        if (!code.equals(redisCode)) throw new GlobalException(ResultEnum.CustomException.getKey(), "验证码错误.");

        //检验用户名
        User isExists = userRepository.findByName(name);
        if (isExists != null) throw new GlobalException(ResultEnum.CustomException.getKey(), "用户名已存在.");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
//        SymmetricCrypto symmetricCrypto = SmUtil.sm4();
//        String encryptHexPassword = symmetricCrypto.encryptHex(password);
//        String s = symmetricCrypto.decryptStr(encryptHexPassword, CharsetUtil.CHARSET_UTF_8);
//        user.setEncryptPassword(bCryptPasswordEncoder.encode(password));
        user.setBalance(new BigDecimal("0.00"));
        user.setSex(CommonByteEnum.Normal.getKey());
        user.setStatus(CommonByteEnum.Normal.getKey());
        //设置商家和会员为不是的状态
        user.setIsMerchant(CommonByteEnum.No.getKey());
        user.setIsVip(CommonByteEnum.No.getKey());
        userRepository.save(user);
        return user.getId();
    }

    public Long login(String name, String password) {
        User user = userRepository.findByName(name);

        String dbPassword = Optional.ofNullable(user).map(User::getPassword).orElse("");

        if (!com.alibaba.druid.util.StringUtils.equals(password, dbPassword))
            throw new GlobalException(ResultEnum.CustomException.getKey(), "用户名或密码错误.");

        return user.getId();
    }

    public String code(String email) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(email)) throw new GlobalException(ResultEnum.CustomException.getKey(), "手机或邮箱为空");
        String code ;
        do {
            code = new Random().nextInt(10000) + "";
        }while (code.length() < 4);

        //发送到消息中间件
        User currentUser = getCurrentUser();
        Map<String, Object> map = new HashMap<>();
        map.put("emailAddress", currentUser.getEmail());
        map.put("type", EmailType.Code.getKey());
        map.put("message", String.format("您的验证码为: %s.", code));
        rabbitTemplate.convertAndSend("QuanDirectExchange", "QuanDirectRouting", map);

//        EmailUtil.sendEmail(mailSender, from, email, title, content, null);
        //存入redis
        redisTemplate.opsForValue().set("code-" + email, code, 5, TimeUnit.MINUTES);
        return code;
    }

    public void setRedisUserInfo(User user){
        if (user == null) return;
//        redisTemplate.opsForValue().set();
    }

    public User userInfo(){
        return getCurrentUser();
    }

    public void registerMerchant(){
        Long currentUserId = getCurrentUserId();
        Optional<User> byId = userRepository.findById(currentUserId);
        if (byId.get() == null) throw new GlobalException(ResultEnum.LoginOverDue.getKey());
        User user = byId.get();
        if (CommonByteEnum.Normal.getKey().equals(user.getIsMerchant()))
            throw new GlobalException(ResultEnum.CustomException.getKey(), "您已经是商家了");
        user.setIsMerchant(CommonByteEnum.Normal.getKey());
        userRepository.save(user);
    }

}
