package com.jvetere.spring.files.upload.controller;

import com.jvetere.json.payloads.ConnectedComponentsJson;
import com.jvetere.spring.files.upload.message.ResponseMessage;
import com.jvetere.spring.files.upload.model.FileInfo;
import com.jvetere.spring.files.upload.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "http://localhost:8081")
public class FilesController {
    @Autowired
    FileStorageService storageService;
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file) {
        String message;
        try {
            storageService.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url      = MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            FileInfo rtr       = new FileInfo(filename, url, "component");
            rtr.setImage();
            return rtr;
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ConnectedComponentsJson getFile(@PathVariable String filename) {
        ConnectedComponentsJson file = storageService.load(filename);
        return file;
    }
}




