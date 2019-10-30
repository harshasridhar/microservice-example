package com.test.gallery;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Created by harshams on 28/10/19
 */

@FeignClient(name = "auth-service")
@RibbonClient(name = "auth-service")
public interface AuthServiceProxy {

    @PostMapping("/auth/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody UserEntity userEntity);

    @GetMapping("/auth/register")
    public String test();
}
