package serversirmon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

@RequestMapping("/")
public class main {
    sirServer s;
    
     @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/lottoget")
    String home() {
        return "Hello World! IV";
    }
    
     @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/sirmonapi")
     public void callme(){
         System.out.println("Calling main api");
     }
     
    public static void main(String args[]){
         SpringApplication.run(main.class, args);
    }
}
