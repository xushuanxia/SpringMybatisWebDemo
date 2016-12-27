package com.hc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/19.
 */
@Controller
public class FileUploadController {

    @RequestMapping("/fileUpload")
    public void FileUpload(MultipartFile file1){
        System.out.println(file1.getName()+"*"+file1.getSize());
        String originalFilename = file1.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID()+suffix;
        File path = new File("/fileUpload/"+filename);
        System.out.println(path.getAbsolutePath());
        try {
            file1.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
