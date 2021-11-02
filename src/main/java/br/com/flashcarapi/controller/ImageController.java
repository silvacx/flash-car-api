package br.com.flashcarapi.controller;

import br.com.flashcarapi.dto.ImageDTO;
import br.com.flashcarapi.model.Image;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import java.util.List;

@Api(value = "API REST Imagens")
@RestController
@RequestMapping("/image")
public class ImageController {

    @PersistenceContext
    EntityManager entityManager;

    @ApiOperation(value = "Salva uma imagem")
    @PostMapping
    @Transactional
    public ResponseEntity<?> createImage(@RequestBody @Valid ImageDTO imageDTO) {
        Image newImage = imageDTO.toModel();
        entityManager.persist(newImage);
        return ResponseEntity.status(HttpStatus.OK).body(newImage);
    }

    @ApiOperation(value = "Retorna uma lista de imagens")
    @GetMapping
    public ResponseEntity<?> listImages() {
        try{
            Query query = entityManager.createQuery("SELECT b FROM images b", Image.class);
            List<Image> images = query.getResultList();
            return ResponseEntity.status(HttpStatus.OK).body(images);
        }
        catch(Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Deleta uma imagem")
    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
        Image oneImage = entityManager.find(Image.class, id);

        if(oneImage == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        entityManager.remove(oneImage);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
