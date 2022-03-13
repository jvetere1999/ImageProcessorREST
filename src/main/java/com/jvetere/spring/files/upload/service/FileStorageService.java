package com.jvetere.spring.files.upload.service;

import com.jvetere.json.payloads.ConnectedComponentsJson;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService {
    public void init();
    public void save(MultipartFile _file);
    public ConnectedComponentsJson load(String _filename);
    public void deleteAll();
    public Stream<Path> loadAll();
    public void operate(MultipartFile _file);
}
