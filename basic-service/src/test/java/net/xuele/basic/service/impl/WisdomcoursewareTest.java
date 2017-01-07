package net.xuele.basic.service.impl;

import net.xuele.basic.service.BaseServiceTest;
import net.xuele.basic.service.TestSupport;
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
@SuppressWarnings("ALL")
public class WisdomcoursewareTest extends TestSupport {


    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void classList(){
        MultiValueMap<String,String> mm = new LinkedMultiValueMap<>();
        String url = "http://192.168.3.72:8080/openapi";
        String prefix = "/wisdomCourseware/1000110002/classList";
        URI uri = getTargetURI(url,prefix,mm);
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }

    @Test
    public void newlyClass(){
        MultiValueMap<String,Object> mm = new LinkedMultiValueMap<>();
        String url = "http://192.168.3.72:8080/openapi";
        String prefix = "/wisdomCourseware/newlyClass";
        mm.add("userId", "1000110002");
        mm.add("schoolId", "10001");
        URI uri = getTargetURI(url,prefix,mm);
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }


    @Test
    public void bookList(){
        MultiValueMap<String,Object> mm = new LinkedMultiValueMap<>();
        String url = "http://192.168.3.72:8080/openapi";
        String prefix = "/wisdomCourseware/1000110002/bookList";
        URI uri = getTargetURI(url,prefix,mm);
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }

    @Test
     public void coursewareList(){
        MultiValueMap<String,Object> mm = new LinkedMultiValueMap<>();
        String url = "http://192.168.3.72:8080/openapi";
        String prefix = "/wisdomCourseware/coursewareList";
        mm.add("unitId","010001001001001001001");
        mm.add("userId","1000110002");
        mm.add("schoolId","10001");
        URI uri = getTargetURI(url,prefix,mm);
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }

    @Test
    public void studentList(){
        MultiValueMap<String,Object> mm = new LinkedMultiValueMap<>();
        String url = "http://192.168.3.72:80/openapi";
        String prefix = "/wisdomCourseware/be7aed69424b11e5825844a8421dc7b3/studentList";
        URI uri = getTargetURI(url,prefix,mm);
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }

    @Test
    public void bookCoverList(){
        MultiValueMap<String,Object> mm = new LinkedMultiValueMap<>();
        String url = "http://192.168.3.72:80/openapi";
        String prefix = "/wisdomBlackboard/1000110002/bookCoverList";
        URI uri = getTargetURI(url,prefix,mm);
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }

    @Test
    public void cloudDiskList(){
        MultiValueMap<String,Object> mm = new LinkedMultiValueMap<>();
        String url = "http://192.168.3.72:8080/openapi";
        String prefix = "/wisdomBlackboard/cloudDiskList";
        mm.add("userId","1000110002");
        mm.add("schoolId","10001");
        mm.add("extType","6");
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
