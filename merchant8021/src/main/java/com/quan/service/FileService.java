package com.quan.service;

import com.quan.Enum.CommonByteEnum;
import com.quan.Enum.ResultEnum;
import com.quan.dao.CommodityImageRepository;
import com.quan.entity.CommodityImage;
import com.quan.exception.GlobalException;
import com.quan.util.OssUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/19
 */
@Service
public class FileService {
    @Resource
    CommodityImageRepository commodityImageRepository;

    public String save(Long commodityId, MultipartFile file) throws IOException {
        if (file == null || file.isEmpty())  throw new GlobalException(ResultEnum.ParameterError.getKey(), "请添加至少一张图片.");
        String fileUrl = OssUtil.fileFtpUpload(file.getInputStream(), file.getOriginalFilename());
        CommodityImage image = new CommodityImage();
        image.setCommodityId(commodityId);
        image.setFileName(fileUrl.substring(fileUrl.lastIndexOf('/')+1));
        image.setSize(image.getSize());
        image.setImageUrl(fileUrl);
        image.setStatus(CommonByteEnum.Normal.getKey());
        commodityImageRepository.save(image);
        return fileUrl;
    }
}
