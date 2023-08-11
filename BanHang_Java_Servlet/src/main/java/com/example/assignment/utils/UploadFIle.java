package com.example.assignment.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UploadFIle {
    public File UploadFile(MultipartFile file) {
        String folder = "D:\\java5\\Assignment\\src\\main\\webapp\\img";
        File filefolder = new File(folder);
        if(!filefolder.exists())  filefolder.mkdirs();
        System.out.println(filefolder.getAbsolutePath() + file.getOriginalFilename());
        File saveFile= null;
        try {
            saveFile = new File(filefolder, file.getOriginalFilename());
            file.transferTo(saveFile);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return saveFile;
    }
}
