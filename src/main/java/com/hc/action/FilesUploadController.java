package com.hc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/19.
 */
@Controller
public class FilesUploadController {

    @RequestMapping("/filesUpload")
    public void FileUpload(@RequestParam("upload") MultipartFile[] files) {
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = UUID.randomUUID() + suffix;

            try {
                File path = new File("/fileUpload/" + filename);
                file.transferTo(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
