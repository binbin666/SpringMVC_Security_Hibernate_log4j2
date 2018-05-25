/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 21, 2018 9:05:50 PM
 * @Description
 */
package site.iotor.hello.spring.controller;

import java.security.Principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Rancho
 */

@Controller
public class MyContoller {

    Logger logger = LogManager.getLogger(this.getClass().getName());
    
    {logger.info("scanned it...." + this.getClass().getName());}
    
    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "index";
    }
    
    /*@GetMapping("/hello")
    public String hello(Model model, Principal principal) {
        model.addAttribute("message", "hello " + principal.getName());
        return "index";
    }*/
    
}