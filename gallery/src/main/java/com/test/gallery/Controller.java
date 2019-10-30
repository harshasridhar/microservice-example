package com.test.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class Controller {

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public Message home(){
//        throw  new RuntimeException("some error occurred");
        return  new Message("Hello from Gallery Service, served by Image Service at port: " + environment.getProperty("local.server.port"));
    }

    @Autowired
    private ImageServiceProxy imageServiceProxy;

    @RequestMapping("/{id}")
    public Gallery getGallery(@PathVariable int id){
        Gallery gallery = new Gallery();
        gallery.setId(id);
        gallery.setImages(imageServiceProxy.getImages(id));
        return gallery;
    }

    @RequestMapping("/admin")
    public String admin(){
        return "this is admin service running at port: " + environment.getProperty("local.server.port");
    }

    @Autowired
    AuthServiceProxy authServiceProxy;
//    @Autowired
//    RestTemplate restTemplate;
//    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/test")
    public String test(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
        userEntity.setPassword("admin");
        ResponseEntity<?> responseEntity = authServiceProxy.authenticate(userEntity);
//        ResponseEntity<?> responseEntity = restTemplate.postForEntity("http://auth-service/authenticate",userEntity,ResponseEntity.class);
        System.out.println(responseEntity.getStatusCode());
        return responseEntity.toString();

    }

    @GetMapping("/test/str")
    public String testStr(){
        return authServiceProxy.test();
    }
}

class Message{
    String messageString;

    Message(String messageString){
        this.messageString = messageString;
    }

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }
}
