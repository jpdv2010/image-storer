package br.com.jp.imagestorer.data.repository;

import br.com.jp.imagestorer.data.model.Pixel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixelRepository extends JpaRepository<Pixel, Long> {
}
