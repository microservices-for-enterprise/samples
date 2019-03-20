package product_service;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SpringBootHelloWorld {

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return "Hello World from 'Microservices for Enterprise!'";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootHelloWorld.class, args);
    }
}
