package com.quan.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/5
 */
@Data
public class FtpEntity {

    @Value("${com.quan.ftp.host}")
    String ftpHost;

    @Value("${com.quan.ftp.port}")
    Integer port;

    @Value("${com.quan.ftp.username}")
    String username;

    @Value("${com.quan.ftp.password}")
    String password;

    @Value("${com.quan.ftp.filepath}")
    String filepath;

    @Value("${com.quan.web.port}")
    Integer ftpWebPort;


}
