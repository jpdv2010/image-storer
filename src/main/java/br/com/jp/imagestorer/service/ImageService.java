package br.com.jp.imagestorer.service;

import java.awt.image.BufferedImage;

public interface ImageService {
    void saveFromBufferedImage(BufferedImage bufferedImage);

    BufferedImage getBIById(Long id) throws Exception;
}
