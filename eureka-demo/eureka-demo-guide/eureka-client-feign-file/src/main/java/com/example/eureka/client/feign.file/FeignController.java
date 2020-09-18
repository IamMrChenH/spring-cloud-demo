package com.example.eureka.client.feign.file;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author chenh
 * @date 2020年09月18日
 */
@Slf4j
@RestController
public class FeignController {

    @FeignClient(value = "eureka-client-server", configuration = FileService.MultipartSupportConfig.class)
    public interface FileService {
        @PostMapping(value = "info", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        String handleFileUpload(@RequestPart("file") MultipartFile file);

        @Configuration
        class MultipartSupportConfig {
            @Bean
            public Encoder feignFormEncoder() {
                return new SpringFormEncoder();
            }
        }
    }

    @Autowired
    private FileService fileService;


    @GetMapping("info")
    public String info() {
        File file = new File("upload.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        MultipartFile multi = new CommonsMultipartFile(fileItem);
        String fileName = fileService.handleFileUpload(multi);
        log.info(fileName);
        return fileName;
    }


}
