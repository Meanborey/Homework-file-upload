package com.istad.fileupload.controller;

import com.istad.fileupload.model.FileResponse;
import com.istad.fileupload.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam("files") MultipartFile file) throws IOException {
        String fileName = fileService.uploadFile(file);
        return ResponseEntity.ok(new FileResponse<>(
                "Successfully",
                200,
                fileName
        ));
    }
}
