package br.com.company.fks;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@IntegrationTest("server.port:0")
@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringApplication.class)
public class FKSApplicationTests {

    @InjectMocks
    private FKSApplication fksApplication;

    @Mock
    private ConfigurableApplicationContext configurableApplicationContext;

    @Test
    public void configure() {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder();
        SpringApplicationBuilder retorno = fksApplication.configure(springApplicationBuilder);
        assertNotNull(retorno);
    }

    @Test
    @SneakyThrows
    public void main() {
        mockStatic(SpringApplication.class);
        when(SpringApplication.run(eq(FKSApplication.class), any(String[].class))).thenReturn(configurableApplicationContext);
        FKSApplication.main(new String[]{"teste"});
    }

}
