package com.mycompany.client;

import com.mycompany.dto.Auth;
import com.mycompany.dto.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class UserClient {

    private final RestTemplate restTemplate;
    private static final String URL = "http://localhost:8005/api/user";
    private static final String GET_USER_BY_ID = "http://localhost:8005/api/user/%d";
    private static final String GET_USER_BY_ID2 = "http://localhost:8005/api/user/";
    private static final String UPDATE_USER = "http://localhost:8005/api/user/%d";
    private static final String DELETE_USER = "http://localhost:8005/api/user/";
    private final AuthClient authClient;

    public UserClient() {

        authClient = new AuthClient();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter
                = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);

    }

    public List<User> getUsers(Auth auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization" , "Bearer ".concat(auth.getAccessToken()));
        
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);

        ResponseEntity<List<User>> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<User>>() {
        });

        return response.getBody();
    }

    public void createUser(User user, Auth auth) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization" , "Bearer ".concat(auth.getAccessToken()));
        
        Map<String, Object> map = new HashMap<>();

        map.put("cedula", user.getCedula());
        map.put("nombre", user.getNombre());
        map.put("apellido", user.getApellido());
        map.put("age", user.getAge());
        map.put("telefono", user.getTelefono());
        map.put("direccion", user.getDireccion());
        map.put("barrio", user.getBarrio());
        map.put("ciudad", user.getCiudad());
        map.put("foto", user.getFoto());
        map.put("reporte", user.isReporte());
        map.put("pass", user.getPass());
        map.put("rol", user.getRol());

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);

        ResponseEntity<Void> resp = restTemplate.exchange(URL, HttpMethod.POST, request, Void.class);
        System.out.println(resp.getStatusCode());

    }

    public User getUser(Integer id, Auth auth) {

        //User user = restTemplate.getForObject(String.format(GET_USER_BY_ID, id), User.class, param);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization" , "Bearer ".concat(auth.getAccessToken()));
       // headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTAzMDgxNzcsInVzZXJfbmFtZSI6IjU0MzMyIiwiYXV0aG9yaXRpZXMiOlsiQURNSU4iXSwianRpIjoiZDgxYWViZDktYjI3YS00YWY1LTg5YmQtMTEwZDcxNDM1M2Q5IiwiY2xpZW50X2lkIjoic2Vydmlkb3ItcHJhY3RpY2FzIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.wFsCTuT5ABkWIqqY-QX7bYi1sy3Q2kTKrAzV5_hL4aw");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);

        ResponseEntity<User> response = restTemplate.exchange(
                GET_USER_BY_ID2 + id,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<User>() {
        });

        return response.getBody();

    }

    public void updateUse(Integer id, User user, Auth auth) {
      
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        headers.add("Authorization" , "Bearer ".concat(auth.getAccessToken()));
        
        Map<String, Object> map = new HashMap<>();

        map.put("cedula", user.getCedula());
        map.put("nombre", user.getNombre());
        map.put("apellido", user.getApellido());
        map.put("age", user.getAge());
        map.put("telefono", user.getTelefono());
        map.put("direccion", user.getDireccion());
        map.put("barrio", user.getBarrio());
        map.put("ciudad", user.getCiudad());
        map.put("foto", user.getFoto());
        map.put("reporte", user.isReporte());
        map.put("pass", user.getPass());
        map.put("rol", user.getRol());

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);
        
        ResponseEntity<Void> resp = restTemplate.exchange(String.format(UPDATE_USER, id), HttpMethod.PUT, request, Void.class);
        System.out.println(resp.getStatusCode());

       
       
    }
    
    public void deleteUse(Integer id, Auth auth){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization" , "Bearer ".concat(auth.getAccessToken()));
        
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);

        ResponseEntity<User> response = restTemplate.exchange(
                GET_USER_BY_ID2 + id,
                HttpMethod.DELETE,
                entity,
                new ParameterizedTypeReference<User>() {
        });
        
        
       
        
    }
    
    

}
