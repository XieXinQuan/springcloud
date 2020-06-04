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
 * DATE:2020/6/4
 */
public class EmailUtil {

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
