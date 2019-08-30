package br.com.jp.imagestorer.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IS_PIXEL")
public class Pixel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "IS_PIXEL_X_POSITION" )
    private Long xPosition;

    @Column( name = "IS_PIXEL_Y_POSITION" )
    private Long yPosition;

    @Column( name = "IS_PIXEL_RGB_VALUE" )
    private Long rgbValue;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getxPosition() {
        return xPosition;
    }

    public void setxPosition(Long xPosition) {
        this.xPosition = xPosition;
    }

    public Long getyPosition() {
        return yPosition;
    }

    public void setyPosition(Long yPosition) {
        this.yPosition = yPosition;
    }

    public Long getRgbValue() {
        return rgbValue;
    }

    public void setRgbValue(Long rgbValue) {
        this.rgbValue = rgbValue;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
