package br.com.company.fks.utils;

import br.gov.mpog.acessos.cliente.utils.HeadersUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.opensaml.xacml.ctx.ResponseType;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class RequestUtilsTest {

    @InjectMocks
    private RequestUtils requestUtils;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private HeadersUtils headersUtils;

    @Mock
    private HttpHeaders httpHeaders;

    @Mock
    private URI uri;

    @Mock
    private UriComponentsBuilder uriComponentsBuilder;

    @Mock
    private UriComponents uriComponents;

    @Mock
    private Object object;

    @Mock
    private RequestEntity requestEntity;

    @Mock
    private ResponseType responseType;


    @Test
    public void doGet(){
        when(headersUtils.getHeadersDefaults()).thenReturn(httpHeaders);
        when(httpHeaders.getContentType()).thenReturn(MediaType.APPLICATION_JSON);
        requestUtils.doGet("http://url", Object.class);
    }

    @Test
    public void doGetNull(){
        when(headersUtils.getHeadersDefaults()).thenReturn(null);
        requestUtils.doGet("http://url", Object.class);
    }

    @Test
    public void doGetBetweenDomain(){
        when(headersUtils.getHeadersDefaults()).thenReturn(httpHeaders);
        when(httpHeaders.getContentType()).thenReturn(MediaType.APPLICATION_JSON);
        requestUtils.doGetBetweenDomain("http://url", HeadersUtils.class, object);
    }

    @Test
    public void doPostBetweenModules(){
        when(headersUtils.getHeadersDefaults()).thenReturn(httpHeaders);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestUtils.doPostBetweenModules("url", object);
    }

    @Test
    public void doPost(){
        when(headersUtils.getHeadersDefaults()).thenReturn(httpHeaders);
        when(httpHeaders.getContentType()).thenReturn(MediaType.APPLICATION_JSON);
        requestUtils.doPost("url", object);
    }

    @Test
    public void getRestTemplate(){
         requestUtils.getRestTemplate();
    }

    @Test
    public void doPut(){
        when(headersUtils.getHeadersDefaults()).thenReturn(httpHeaders);
        when(httpHeaders.getContentType()).thenReturn(MediaType.APPLICATION_JSON);
        requestUtils.doPut("http://url", Object.class);
    }

    @Test
    public void getForEntity(){
        when(headersUtils.getHeadersDefaults()).thenReturn(httpHeaders);
        requestUtils.getForEntity(uri, HeadersUtils.class);
    }

    @Test
    public void doDeleteBetweenModules(){
        when(headersUtils.getHeadersDefaults()).thenReturn(httpHeaders);
        requestUtils.doDeleteBetweenModules("url");
    }


}