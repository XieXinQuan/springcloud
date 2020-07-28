package com.quan.util;

import cn.hutool.core.date.DateUtil;
import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.*;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/4
 *
 * nginx 做图片服务器 --此处主要为上传 下载直接通过访问nginx服务器查看
 */
@Slf4j
public class OssUtil {
    //ftp服务器地址
    public static String hostname = "118.89.133.157";
    //ftp服务器端口号默认为21
    public static Integer port = 22;
    //ftp登录账号
    public static String username = "quan";
    //ftp登录密码
    public static String password = "Simon@369";

    public static String dir = "/data/nginx/html/images";

    public static void main(String[] args) {
        File allfile = new File("E:\\springcloudvue\\shop-mall-app\\public\\img");
        System.out.println(allfile.isDirectory());
        File[] files = allfile.listFiles();

        for (File file : files){
            fileFtpUpload(file);
        }
        System.out.println("all file upload success.");
//        List<File> files1 = new ArrayList<>();
//        for (File file : files){
//
//            if (org.springframework.util.StringUtils.endsWithIgnoreCase(file.getName(), ".png"))
//                files1.add(file);
//        }
    }


    public static String fileFtpUpload(InputStream stream, String fileName){
        ChannelSftp sftp = null;
        Channel channel = null;
        Session sshSession = null;

        try {
            JSch jsch = new JSch();
            jsch.getSession(username, hostname, port);
            sshSession = jsch.getSession(username, hostname, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            sftp.cd(dir);

            createUploadDir(sftp);
            while (isExists(sftp, fileName)){
                fileName += new Random().nextInt(10);
            }
            sftp.put(stream, fileName);

            String fileUrl = "http://" + hostname + "/images/" + DateUtil.format(new Date(), "yyyy/MM/dd") + "/" + fileName;
            return fileUrl;

        } catch (Exception e) {
            log.info("Ftp Upload Exception , Case : {}.", e.getMessage());
        } finally {
            closeChannel(sftp);
            closeChannel(channel);
            closeSession(sshSession);
        }
        return fileName;
    }

    public static void fileFtpUpload(File file){
        ChannelSftp sftp = null;
        Channel channel = null;
        Session sshSession = null;

        try {
            JSch jsch = new JSch();
            jsch.getSession(username, hostname, port);
            sshSession = jsch.getSession(username, hostname, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            sftp.cd(dir);

            createUploadDir(sftp);
            StringBuilder fileName = new StringBuilder(file.getName());
            while (isExists(sftp, fileName.toString())){
                fileName.insert(fileName.indexOf("."), new Random().nextInt(10));
            }
            sftp.put(new FileInputStream(file), fileName.toString());

            System.out.println(file.getName());
            return ;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeChannel(sftp);
            closeChannel(channel);
            closeSession(sshSession);
        }
        return ;
    }

    public static boolean isExists(ChannelSftp sftp, String fileName) throws SftpException {
        if (sftp == null || StringUtils.isEmpty(fileName)) return false;
        Vector ls = sftp.ls(sftp.pwd());
        Iterator iterator = ls.iterator();
        while (iterator.hasNext()){
            ChannelSftp.LsEntry next = (ChannelSftp.LsEntry)iterator.next();
            if (fileName.equals(next.getFilename())) return true;
        }
        return false;
    }

    public static boolean createUploadDir(ChannelSftp sftp) throws SftpException {
        if (sftp == null) return false;
        Date date = new Date();
        int year = DateUtil.year(date);
        int month = DateUtil.month(date) + 1;
        int day = DateUtil.dayOfMonth(date);

        createUploadDir(sftp, String.valueOf(year));
        createUploadDir(sftp, String.valueOf(month).length() == 1 ? "0" + month : String.valueOf(month));
        createUploadDir(sftp, String.valueOf(day).length() == 1 ? "0" + day : String.valueOf(day));

        return false;
    }
    public static void createUploadDir(ChannelSftp sftp, String dirName) throws SftpException {
        if (sftp == null || StringUtils.isEmpty(dirName)) return;
        Vector ls = sftp.ls(sftp.pwd());
        Iterator iterator = ls.iterator();

        boolean isHaveDir = false;
        while (iterator.hasNext()){
            ChannelSftp.LsEntry next = (ChannelSftp.LsEntry)iterator.next();
            if (next.getAttrs().isDir() && dirName.equals(next.getFilename())) {
                isHaveDir = true;
                break;
            }
        }
        if ((!isHaveDir)){
            sftp.mkdir(dirName);
        }
        sftp.cd(dirName);
    }


    private static void closeChannel(Channel channel) {
        if (channel != null) {
            if (channel.isConnected()) {
                channel.disconnect();
            }
        }
    }

    private static void closeSession(Session session) {
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }


}
