package tr.com.altyapi.staj.DemoService.service;

import org.springframework.stereotype.Service;
import tr.com.altyapi.staj.DemoApi;

@Service
public class HelloService {

    private final DemoApi demoApi;

    public HelloService() {
        this.demoApi = new DemoApi();
    }

    public String getHelloResponse() {
        return demoApi.getHelloString();
    }
}
