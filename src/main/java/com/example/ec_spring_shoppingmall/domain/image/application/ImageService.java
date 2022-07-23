package com.example.ec_spring_shoppingmall.domain.image.application;

import com.example.ec_spring_shoppingmall.domain.image.dao.ImageDao;
import com.example.ec_spring_shoppingmall.domain.image.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * @Author: kbs
 */

@RequiredArgsConstructor
@Service
@Transactional
public class ImageService {
    private final ImageDao imageDao;
    @Value("${app.upload.dir}")
    private String uploadDir;

    public String uploadImage(MultipartFile file) {
        if(file.isEmpty()){
            throw new ImageNotFoundException();
        }
        String filename = UUID.randomUUID().toString();
        String fullPath = uploadDir + File.separator + filename;

        try{
            file.transferTo(new File(fullPath));
            imageDao.save(fullPath);
        }catch(IOException e){
            e.printStackTrace();
            return "";
        }

        return fullPath;
    }
}
