package tr.com.altyapi.staj.DemoService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.altyapi.staj.DemoApi;
import tr.com.altyapi.staj.DemoService.service.HelloService;

@RestController
public class DemoController {

    private final HelloService helloService;

    public DemoController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return helloService.getHelloResponse();
    }

}
