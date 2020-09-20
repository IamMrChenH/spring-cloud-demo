package com.example.eureka.client.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author chenh
 * @date 2020年09月18日
 */
@RestController
public class EurekaInfoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("info")
    public String getServiceInfo() throws InterruptedException {
        Thread.sleep(5000);
        List<String> services = discoveryClient.getServices();
        return "services: " + services;
    }

    @PostMapping(value = "info", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart("file") MultipartFile file) {
        return new StringBuilder()
                .append("file.getName():").append(file.getName()).append("\n")
                .append("file.getOriginalFilename():").append(file.getOriginalFilename()).append("\n")
                .append("file.getContentType():").append(file.getContentType()).append("\n")
                .append("file.getSize():").append(file.getSize()).append("\n")
                .toString();
    }


}
