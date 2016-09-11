package com.cupcakes.webshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by scheldejonas on 10/09/16.
 */
@Entity
public class Bottom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Lob
    private byte[] image;
    private String colorCode;

    public Bottom() {
    }

    public Bottom(String name, byte[] image, String color) {
        this.name = name;
        this.image = image;
        this.colorCode = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}
