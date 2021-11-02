package br.com.flashcarapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String imageBase64;

    @Deprecated
    public Image() {
    }

    public Image(String description, String imageBase64) {
        this.description = description;
        this.imageBase64 = imageBase64;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImageBase64() {
        return imageBase64;
    }

}
