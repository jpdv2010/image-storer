package br.com.jp.imagestorer.controller;

import br.com.jp.imagestorer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class UploadController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();

            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            BufferedImage bImage2 = ImageIO.read(bis);

            imageService.saveFromBufferedImage( bImage2 );

        } catch ( IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

}
