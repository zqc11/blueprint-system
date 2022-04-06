package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author zhouqichun
 **/
@RestController
public class UploadFileController {
    @PostMapping("/multiUpload")
    public Result multiUpload(@RequestParam("file") MultipartFile[] files) {
        if (files == null) {
            return Result.failure(400, "null");
        }
        System.out.println("文件的个数:" + files.length);
        for (MultipartFile f : files) {
            saveFile(f);
        }
        return Result.success(null);
    }

    private Object saveFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "未选择文件";
        }
        //获取上传文件原来的名称
        String filename = file.getOriginalFilename();
        String filePath = "D:\\Project\\blueprintsystem\\src\\main\\java\\com\\silentsunshine\\blueprintsystem\\controller\\temp\\";
        File temp = new File(filePath);
        if (! temp.exists()) {
            temp.mkdirs();
        }

        File localFile = new File(filePath + filename);
        try {
            //把上传的文件保存至本地
            file.transferTo(localFile);
            System.out.println(file.getOriginalFilename() + " 上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }

        return "ok";
    }
}
