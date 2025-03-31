package hieu.microserviceinaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class MicroserviceInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceInActionApplication.class, args);
    }

    @GetMapping("/{firstName}")
    public String helloWorld(@PathVariable String firstName, @RequestParam String lastName) {
        return "Hello, " + firstName + " " + lastName;
    }

}
