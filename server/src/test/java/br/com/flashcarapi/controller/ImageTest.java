package br.com.flashcarapi.controller;

import br.com.flashcarapi.dto.ImageDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;

public class ImageTest {

    @InjectMocks
    @Spy
    private ImageController controller;

    @Mock
    EntityManager entityManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createImageSucess() {
        ImageDTO imageDTO = new ImageDTO("ImagemTeste", "imageBase64");
        ResponseEntity resp = controller.createImage(imageDTO);

        assertEquals(resp.getStatusCode(), HttpStatus.OK);

    }
}
