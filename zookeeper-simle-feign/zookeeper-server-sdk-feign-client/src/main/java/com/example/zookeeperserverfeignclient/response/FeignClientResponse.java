package com.example.zookeeperserverfeignclient.response;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

/**
 * @author chenh
 * @date 2020年09月17日
 */
@Slf4j
@Component
@ConditionalOnClass(value = ErrorDecoder.Default.class)
public class FeignClientResponse extends ErrorDecoder.Default {

    @Override
    public Exception decode(String methodKey, Response response) {


        return super.decode(methodKey, response);
    }
}
