package com.quan.service;

import com.quan.Enum.CommonByteEnum;
import com.quan.Enum.ResultEnum;
import com.quan.dao.UserRepository;
import com.quan.entity.User;
import com.quan.exception.GlobalException;
import com.quan.util.EmailUtil;
import com.quan.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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

    @Value("${spring.mail.username}")
    String from;
    @Resource
    private JavaMailSender mailSender;

    @Resource
    UserRepository userRepository;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    HttpServletRequest request;

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

    public String code(String email) throws UnsupportedEncodingException, MessagingException {
        if (StringUtils.isEmpty(email)) throw new GlobalException(ResultEnum.CustomException.getKey(), "手机或邮箱为空");
        String code ;
        do {
            code = new Random().nextInt(10000) + "";
        }while (code.length() < 4);
        String content = String.format("您的验证码为: %s.", code);
        String title = String.format("幻听科技");
        EmailUtil.sendEmail(mailSender, from, email, title, content, null);
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

}
