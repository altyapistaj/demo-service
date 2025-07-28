package tr.com.altyapi.staj.DemoService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.altyapi.staj.DemoApi;

@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello() {
        DemoApi demoApi = new DemoApi();
        return "Demo Service Hello : " + demoApi.getHelloString();
    }

}
