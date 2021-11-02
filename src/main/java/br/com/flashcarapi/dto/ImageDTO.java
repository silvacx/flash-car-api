package br.com.flashcarapi.dto;

import br.com.flashcarapi.model.Image;

import javax.validation.constraints.NotBlank;

public class ImageDTO {

    @NotBlank(message = "is required")
    private String description;

    @NotBlank(message = "is required")
    private String imageBase64;

    public ImageDTO(@NotBlank(message = "is required") String description, @NotBlank(message = "is required") String imageBase64) {
        this.description = description;
        this.imageBase64 = imageBase64;
    }

    public String getDescription() {
        return description;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public Image toModel(){
        return new Image(this.description, this.imageBase64);
    }
}
