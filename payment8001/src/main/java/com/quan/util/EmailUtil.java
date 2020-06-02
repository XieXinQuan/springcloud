package com.quan.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/13
 */
public class EmailUtil {
//    private static final String AUTH_TOKEN = "56746fd40433a755a78c98ff2b3376d7";
//    private static final String ACCOUNT_SID = "aa4c7065f7cd327da7cecc85afad3969";
//    private static final String  QUERY_PATH = "https://openapi.miaodiyun.com/distributor/sendSMS";

    public static void sendEmail(JavaMailSender mailSender, String from, String loginEmail, String title, String content, List<File> files) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(loginEmail);
        helper.setSubject(title);
        helper.setText(content);
        if(files != null) {
            String fileName = null;
            for (File file : files) {
                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
                helper.addAttachment(fileName, file);
            }
        }
        mailSender.send(message);

    }
}
