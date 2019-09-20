package serversirmon;

import com.google.gson.Gson;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class main extends WebSecurityConfigurerAdapter{ 
        //implements ErrorController{
    sirServer s;

    /*
    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }
    */
     @Override
    protected void configure(HttpSecurity security) throws Exception
    {
     security.httpBasic().disable();
     security.csrf().disable();
    }
    
     @CrossOrigin(origins = "http://localhost:8444")
    @RequestMapping(path = "/lottoget")
    String home() {
        return "Hello World! IV";
    }
    
    
    // @CrossOrigin(origins = "http://localhost:8444")
    @RequestMapping(path = "/sirmonprcs",method = RequestMethod.POST , headers = "Accept=application/json")
     //public String sirmonprcs (@RequestBody List<sirServer>  postPayload){
         public String sirmonprcs (@RequestBody String  postPayload){
          System.out.println("I am inside request mapping method "+ postPayload);
          Gson g = new Gson();
          sirServer i = g.fromJson(postPayload, sirServer.class);
     //postPayload.stream().toString();
        //for(sirServer i : postPayload){
                     System.out.println("Calling main processing api " + i.server_dns);
                     i.insInDB();
        //}

         return("Value from server " +postPayload);
     }
     
     
   /* @Override
    public String getErrorPath() {
        return "/error";
    }*/
     
    public static void main(String args[]){
         SpringApplication.run(main.class, args);
    }
}
