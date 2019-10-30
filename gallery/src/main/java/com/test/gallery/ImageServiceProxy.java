package com.test.gallery;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "image-service")
@RibbonClient(name = "image-service")
public interface ImageServiceProxy {

    @GetMapping("/{galleryId}/images")
    public List<Object> getImages(@PathVariable int galleryId);

}
