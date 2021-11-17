package br.com.flashcarapi.model;

import javax.persistence.*;

@Entity(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
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

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}