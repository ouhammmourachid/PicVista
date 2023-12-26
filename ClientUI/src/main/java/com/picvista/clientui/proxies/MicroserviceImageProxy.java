package com.picvista.clientui.proxies;

import com.picvista.clientui.beans.ImageBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name ="microservice-image",url = "image-service:5012")
public interface MicroserviceImageProxy {

    @PostMapping("/image/upload")
    ResponseEntity<?> uploadImage(@RequestParam Long userId,
                                         @RequestParam MultipartFile image);
    @GetMapping("/image/{id}")
    ResponseEntity<?> downloadImage(@PathVariable Long id);
    @DeleteMapping("/image/{id}")
    ResponseEntity<?> deleteImage(@PathVariable Long id);
    @GetMapping("/image")
    ResponseEntity<List<ImageBean>> getAllImages();
}
