package br.com.jp.imagestorer.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "IS_IMAGE")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "image")
    private List<Pixel> pixels;

    @Column(name = "IS_IMAGE_WIDTH")
    private Long width;

    @Column(name = "IS_IMAGE_HEIGHT")
    private Long height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getRGB( Long x, Long y ) throws Exception {
        List<Pixel> filteredPixels = new ArrayList<>();
        if( !this.pixels.isEmpty() ){
            filteredPixels = this.pixels
                    .stream()
                    .filter( pixel -> pixel.getxPosition().equals(x) && pixel.getyPosition().equals(y ) )
                    .collect(Collectors.toList());
            if( filteredPixels.isEmpty() ){
                throw new Exception( "No pixel founded in this position!" );
            } else if( filteredPixels.size() > 1 ) {
                throw new Exception( "More than one pixel from this position!" );
            } else {
                return filteredPixels.get( 0 ).getRgbValue();
            }
        } else {
            throw new Exception( "this image have no saved pixels!" );
        }
    }
}
