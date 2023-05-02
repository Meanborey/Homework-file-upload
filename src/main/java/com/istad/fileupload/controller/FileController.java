package com.istad.fileupload.controller;
import com.istad.fileupload.model.FileResponse;
import com.istad.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @Value("${value.file}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<?>fileUpload(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        String filename = null;
        try{
            filename= "http://localhost:8080/"+this.fileService.uploadFile(path,file);
        }catch (Exception ex){
            return new ResponseEntity<>(new FileResponse("file not fount",null), HttpStatus.OK);
        }
       return new ResponseEntity<>(new FileResponse(filename,"file is success"),HttpStatus.OK);


    }

}
