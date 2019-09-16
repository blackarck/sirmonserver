package serversirmon;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class main{ 
        //implements ErrorController{
    sirServer s;

    /*
    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }
    */
    
     @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/lottoget")
    String home() {
        return "Hello World! IV";
    }
    
    
    
    @RequestMapping(path = "/sirmonprcs",method = RequestMethod.POST )
     public String sirmonprcs (@RequestBody List<sirServer> postPayload){
        /*dc6
         for (sirServer sirarr : sirs){
             System.out.println("Sirarray value is " + sirarr.server_dns);
         }
*/      postPayload.stream().toString();
        for(sirServer i : postPayload){
                     System.out.println("Calling main processing api " + i.server_dns);
                     i.insInDB();
        }

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
