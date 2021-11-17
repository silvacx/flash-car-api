package br.com.flashcarapi.model;

import br.com.flashcarapi.dto.ImageDTO;
import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class ImageTest {

    @Test
    public void imageModelTest() {
        assertPojoMethodsFor(Image.class)
                .testing(Method.GETTER, Method.CONSTRUCTOR).areWellImplemented();
    }
}
