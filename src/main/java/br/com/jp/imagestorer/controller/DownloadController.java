package br.com.jp.imagestorer.controller;

import br.com.jp.imagestorer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class DownloadController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/download/{id}") // //new annotation since 4.3
    public ResponseEntity singleFileUpload(@PathVariable(name = "id") Long id) throws IOException {
        BufferedImage image = imageService.getBIById( id );

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();

        // uncomment line below to send non-streamed
        // return Response.ok(imageData).build();

        // uncomment line below to send streamed
         return ResponseEntity.ok(new ByteArrayInputStream(imageData));
    }
}
