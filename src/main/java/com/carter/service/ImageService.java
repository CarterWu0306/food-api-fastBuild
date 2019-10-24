package com.carter.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ImageService {
    String recognizeImage(MultipartFile file);
    String uploadImage(MultipartFile file) throws IOException;
}
