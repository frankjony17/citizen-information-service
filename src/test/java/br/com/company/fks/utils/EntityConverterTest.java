package br.com.company.fks.utils;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class EntityConverterTest {

    @InjectMocks
    private EntityConverter servicoMapper;

    @Mock
    private Object object;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private MatchingStrategies matchingStrategies;

    @Mock
    private Configuration configuration;

    @Mock
    private Type type;

    @Before
    public void setup() {
        type = new TypeToken<Object>() {}.getType();
        ReflectionTestUtils.invokeMethod(servicoMapper, "init", null);
        given(modelMapper.map(any(Object.class), eq(Object.class))).willReturn(object);
        given(modelMapper.getConfiguration()).willReturn(configuration);
        given(modelMapper.map(any(Object.class), any(Type.class))).willReturn(object);
    }

    @Test
    public void testarConverter() {
        Object objectTest = servicoMapper.converter(object, Object.class);
        assertEquals(objectTest, object);
    }

    @Test
    public void testarConverterStrict() {
        Object objectTest = servicoMapper.converterStrict(object, Object.class);
        assertEquals(objectTest, object);
    }

    @Test
    public void testarConverterStrictNull() {
        Object objectTest = servicoMapper.converterStrict(null, Object.class);
        assertNull(objectTest);
    }

    @Test
    public void testarConverterStrictType() {
        Object objectTest = servicoMapper.converterStrict(object, type);
        assertEquals(objectTest, object);
    }

    @Test
    public void testarConverterLazyLoading() {
        Object objectTest = servicoMapper.converterLazyLoading(object, Object.class);
        assertEquals(objectTest, object);
    }

    @Test
    public void testarConverterStrictLazyLoading() {
        Object objectTest = servicoMapper.converterStrictLazyLoading(object, Object.class);
        assertEquals(objectTest, object);
    }

    @Test
    public void testarConverterListaStrictLazyLoading() {
        Object objectTest = servicoMapper.converterListaStrictLazyLoading(object, type);
        assertEquals(objectTest, object);
    }
}
