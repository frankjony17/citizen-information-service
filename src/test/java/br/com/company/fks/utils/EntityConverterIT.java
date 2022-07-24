package br.com.company.fks.utils;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class EntityConverterIT extends EntityConverterTest{

    @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void testarConverter() {
        super.testarConverter();
    }

    @Test
    public void testarConverterStrict() {
        super.testarConverterStrict();
    }

    @Test
    public void testarConverterStrictNull() {
        super.testarConverterStrictNull();
    }

    @Test
    public void testarConverterStrictType() {
        super.testarConverterStrictType();
    }

    @Test
    public void testarConverterLazyLoading() {
        super.testarConverterLazyLoading();
    }

    @Test
    public void testarConverterStrictLazyLoading() {
        super.testarConverterStrictLazyLoading();
    }

    @Test
    public void testarConverterListaStrictLazyLoading() {
        super.testarConverterListaStrictLazyLoading();
    }
}
