package net.xuele.basic.service.impl;

import net.xuele.basic.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 用于测试 openapi 在智慧课堂的controller接口
 * 采用spring restTemplate调用接口
 * rest模式
 * Created by yejunjie on 2017/1/6.
 */
public class WisdomcoursewareTest extends BaseServiceTest {


    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void classList(){
        MultiValueMap<String,String> mm = new LinkedMultiValueMap<>();
        String url = "http://192.168.3.72:80/openapi";
        String prefix = "/wisdomCourseware/1000110002/classList";
        URI uri = getTargetURI(url,prefix,mm);
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }


    public static URI getTargetURI(String url,String prefix, MultiValueMap params){
        URI targetURI = UriComponentsBuilder.fromUriString(url)
                .path(prefix)
                .queryParams(params)
                .build()
                .encode()
                .toUri();
        return targetURI;
    }

}
