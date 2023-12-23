package com.picvista.image.service;

import com.picvista.image.model.Image;
import com.picvista.image.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@AllArgsConstructor
public class ImageService {
    @Autowired
    private final ImageRepository  imageRepository;
    //@Value("${upload.directory}")
    //private String uploadDirectory = "./uploads";

    public String saveImage(Long userId, MultipartFile image){
        String uploadDirectory = "../images";
        String currentDirectory = System.getProperty("user.dir");

        // Print the current working directory
        System.out.println("Current Working Directory: " + currentDirectory);
        if (image.isEmpty()) {
            // Handle empty file
            return "Failed to save image: Empty file";
        }

        try {
            // Generate a timestamped filename with the desired extension (e.g., png)
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            String fileName = timestamp + ".png"; // You can change the extension if needed

            // Save the file to the specified folder
            Path filePath = Paths.get(uploadDirectory, fileName);
            image.transferTo(filePath);

            // Save the file path to the database in the Image table (you need to implement this part)
            Image imageEntity = new Image();
            imageEntity.setPath(filePath.toString());
            imageEntity.setDate(System.currentTimeMillis());
            imageEntity.setUserId(userId);
            imageRepository.save(imageEntity);
            // Return the saved file path or any relevant information
            return "Image saved successfully: " + filePath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save image: " + e.getMessage();
        }
    }
    public byte[] getImage(Long id) throws IOException{
        String imagePath = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Image with id " + id + " does not exist"))
                .getPath();
        return Files.readAllBytes(Paths.get(imagePath));
    }
    public String deleteImage(Long id){
        String imagePath = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Image with id " + id + " does not exist"))
                .getPath();
        try {
            Files.delete(Paths.get(imagePath));
            imageRepository.deleteById(id);
            return "Image deleted successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to delete image: " + e.getMessage();
        }
    }
    public Iterable<Image> getAllImages(){
        return imageRepository.findAll();
    }
}
