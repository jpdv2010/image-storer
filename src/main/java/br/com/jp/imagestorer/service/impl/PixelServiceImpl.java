package br.com.jp.imagestorer.service.impl;

import br.com.jp.imagestorer.data.model.Pixel;
import br.com.jp.imagestorer.data.repository.PixelRepository;
import br.com.jp.imagestorer.service.PixelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PixelServiceImpl implements PixelService {

    private PixelRepository repository;

    @Autowired
    public PixelServiceImpl(PixelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pixel save(Pixel pixel){
        return repository.save( pixel );
    }
}
