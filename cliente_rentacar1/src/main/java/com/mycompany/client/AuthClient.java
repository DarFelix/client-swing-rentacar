package com.mycompany.client;

import com.mycompany.dto.Auth;
import java.nio.charset.Charset;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

public class AuthClient {

    private final RestTemplate restTemplate;
    private static final String URL = "http://localhost:8005/api/oauth/token";
    private static final String PLAINCREDS = "servidor-practicas:123456";

    public AuthClient() {

        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    }

    public Auth getAuth(String username, String password) {

        byte[] plainCredsBytes = PLAINCREDS.getBytes(Charset.forName("US-ASCII"));
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        headers.add("Authorization", "Basic " + base64Creds);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("username", username);
        map.add("password", password);
        map.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        try {
            ResponseEntity<Auth> response = restTemplate.exchange(URL, HttpMethod.POST, request, Auth.class);
            Auth auth = response.getBody();
            return auth;
        } catch (Exception e) {

            String er = escribirMensajeError(e);
            
            Auth auth = new Auth();
            auth.setError("**"+er+"**");
            return auth;

        }

    }
    
    public  String escribirMensajeError(Exception e) {

        if (e.getMessage().toUpperCase().contains("CONNECTION")) {

             return "Error en conexión";

        } else if (e instanceof HttpClientErrorException) {

            HttpClientErrorException clientErrorException = (HttpClientErrorException) e;

            if (clientErrorException.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
                 return clientErrorException.getResponseBodyAsString();
            } else {
              return "Error en el servidor";
            }

        } else if (e.getMessage().toUpperCase().contains("400 null")){
             return "No existe usuario";   
        }else{
                
             return e.getMessage();
        }
        
    }
    

    

}
