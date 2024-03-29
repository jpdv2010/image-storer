package br.com.jp.imagestorer.service;

import br.com.jp.imagestorer.data.model.Image;

import java.awt.image.BufferedImage;

public interface ImageService {
    Image saveFromBI(BufferedImage bufferedImage);

    BufferedImage getBIById(Long id) throws Exception;
}
