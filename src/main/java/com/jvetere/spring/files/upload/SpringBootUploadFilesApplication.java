package com.jvetere.spring.files.upload;

import com.jvetere.spring.files.upload.service.FileStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
@SpringBootApplication
public class SpringBootUploadFilesApplication implements CommandLineRunner {
    @Resource
    FileStorageService storageService;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootUploadFilesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }
}
