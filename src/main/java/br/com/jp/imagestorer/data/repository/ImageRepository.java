package br.com.jp.imagestorer.data.repository;

import br.com.jp.imagestorer.data.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,  Long> {
}
