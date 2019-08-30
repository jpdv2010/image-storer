package br.com.jp.imagestorer.service.impl;

import br.com.jp.imagestorer.data.repository.ImageRepository;
import br.com.jp.imagestorer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;

public class ImageServiceImpl implements ImageService {

    private ImageRepository repository;

    @Autowired
    public ImageServiceImpl(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveFromBufferedImage(BufferedImage bufferedImage){
        //TODO: implement this
    }

}
