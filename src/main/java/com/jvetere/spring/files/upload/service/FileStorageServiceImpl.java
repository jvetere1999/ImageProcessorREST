package com.jvetere.spring.files.upload.service;

import com.jvetere.component.ConnectedComponents;
import com.jvetere.image.Image;
import com.jvetere.json.payloads.ConnectedComponentsJson;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileStorageServiceImpl implements FileStorageService{

    private final Path root = Paths.get("./src/main/images");

    @Override
    public void init() {
        try {Files.createDirectory(root);}
        catch (IOException e){throw new RuntimeException("Could not initialize folder for upload.");}
    }

    @Override
    public void save(MultipartFile _file) {
        try {Files.copy(_file.getInputStream(), this.root.resolve(_file.getOriginalFilename()));}
        catch (Exception e){throw new RuntimeException("Could not store the file. ERROR: "+e.getMessage());}
    }

    @Override
    public ConnectedComponentsJson load(String _filename) {
        Path file = root.resolve(_filename);
        ConnectedComponents rtr = new ConnectedComponents(new Image(file.toUri().toString()));

        return new ConnectedComponentsJson(rtr);
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        }
        catch (IOException e) {
            throw new RuntimeException("Could not load files.");
        }
    }

    @Override
    public void operate(MultipartFile _file) {
        try {
            InputStream file = _file.getInputStream();
            String path = this.root.resolve(_file.getOriginalFilename()).toString();
            System.out.println(path);
        }
        catch (Exception e){throw new RuntimeException("Could not operate on the file. ERROR: "+e.getMessage());}
    }
}
