package com.kin.big_events.controller;


import com.kin.big_events.pojo.Result;
import com.kin.big_events.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUpLoadController {

    @PostMapping("/upload")
    public Result<String> uploadFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        //保证文件名唯一
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
//        file.transferTo(new File("D:\\Data\\SelfProjects\\Big_Events_Demo\\Files\\"+filename));
//        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        String url = AliOssUtil.uploadFile(filename, file.getInputStream());
        return Result.success(url);
    }

}
