package com.istad.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        String IDrandoms = UUID.randomUUID().toString();
        assert name != null;
        String f_name=IDrandoms.concat(name.substring(name.lastIndexOf("")));
        String f_path = path + File.separator+ f_name;
        File f_img = new File(path);
        if (!f_img.exists()){
            f_img.mkdirs();
        }
        Files.copy(file.getInputStream(),Paths.get(f_path));
        return name;
    }
}