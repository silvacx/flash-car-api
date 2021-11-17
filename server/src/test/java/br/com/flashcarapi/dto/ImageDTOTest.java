package br.com.flashcarapi.dto;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class ImageDTOTest {

    @Test
    public void imageDtoTest() {
        assertPojoMethodsFor(ImageDTO.class)
                .testing(Method.GETTER, Method.CONSTRUCTOR).areWellImplemented();
    }
}
