package br.com.jp.imagestorer.service.impl;

import br.com.jp.imagestorer.data.model.Image;
import br.com.jp.imagestorer.data.model.Pixel;
import br.com.jp.imagestorer.data.repository.ImageRepository;
import br.com.jp.imagestorer.service.ImageService;
import br.com.jp.imagestorer.service.PixelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository repository;

    @Autowired
    private PixelService pixelService;

    @Autowired
    public ImageServiceImpl(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveFromBufferedImage(BufferedImage bufferedImage){
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        Image image = new Image();
        image.setWidth( Integer.toUnsignedLong( width ) );
        image.setHeight( Integer.toUnsignedLong( height ) );

        image = repository.save( image );

        for(int i = 0; i <= width; i++){
            for (int j = 0; j <= height; j++){
                Pixel pixel = new Pixel();
                pixel.setImage( image );
                pixel.setxPosition( Integer.toUnsignedLong( i ) );
                pixel.setyPosition( Integer.toUnsignedLong( j ) );
                pixel.setRgbValue( Integer.toUnsignedLong( bufferedImage.getRGB(i,j) ) );

                pixelService.save( pixel );
            }
        }
    }

    @Override
    public BufferedImage getBIById(Long id) throws Exception {
        Image image = repository.getOne( id );

        BufferedImage bufferedImage = new BufferedImage(image.getWidth().intValue(),
                image.getHeight().intValue(), BufferedImage.TYPE_INT_RGB);

        for( int i = 0; i <= image.getWidth().intValue(); i++ ){
            for (int j = 0; j <= image.getHeight().intValue(); j++){
                bufferedImage
                        .setRGB( i, j,
                                image.getRGB(Integer.toUnsignedLong(i), Integer.toUnsignedLong(j) ).intValue()
                        );
            }
        }

        return bufferedImage;
    }

}
