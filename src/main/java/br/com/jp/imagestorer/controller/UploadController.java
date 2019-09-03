package br.com.jp.imagestorer.controller;

import br.com.jp.imagestorer.data.model.Image;
import br.com.jp.imagestorer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

@Controller
public class UploadController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload") // //new annotation since 4.3
    public ResponseEntity singleFileUpload(@RequestParam("file") MultipartFile file,
                                           RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("file is empty");
        }

        Image image = null;
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();

            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            BufferedImage bImage2 = ImageIO.read(bis);

            image = imageService.saveFromBufferedImage( bImage2 );

        } catch ( IOException e) {
            e.printStackTrace();
        }

        if(Objects.nonNull( image ) && Objects.nonNull( image.getId() ) ){
            return ResponseEntity.ok( image.getId().toString() );
        } else {
            return ResponseEntity.badRequest().body("Image not founded!" );
        }

    }

}
