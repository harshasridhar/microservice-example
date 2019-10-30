package com.test.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String home(){
        return "This is the home page of image service running at port: " + environment.getProperty("local.server.port")+ " " + environment.getProperty("spring.cloud.client.hostname");
//        spring.cloud.client.ip-address
    }

    @Autowired
    private ImageRepository imageRepository;
    @GetMapping("/{galleryId}/images")
    public List<Image> getImages(@PathVariable int galleryId) {
//        List<Image> images = Arrays.asList(
//                new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
//                new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
//                new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));
        List<Image> images = imageRepository.findAllByGalleryIdOrderByIdAsc(galleryId);
        return images;
    }
}
