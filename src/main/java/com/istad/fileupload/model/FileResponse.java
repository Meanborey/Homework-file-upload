package com.istad.fileupload.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse <T>{
    private String message;
    private Integer status;
    private T payload;

}
