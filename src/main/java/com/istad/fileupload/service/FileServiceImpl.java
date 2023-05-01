package com.istad.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
    private final Path root = Paths.get("src/main/resources/images");
    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        String fileName=file.getOriginalFilename();
        if (fileName !=null &&
                fileName.contains("jpg") ||
                fileName.contains("png") ||
                fileName.contains("pdf")
        ){
            fileName= UUID.randomUUID()+"."+ StringUtils.getFilenameExtension(fileName);


            if (!Files.exists(root)){
                Files.createDirectories(root);
            }

            Files.copy(file.getInputStream(),root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }
        return null;
    }
}
