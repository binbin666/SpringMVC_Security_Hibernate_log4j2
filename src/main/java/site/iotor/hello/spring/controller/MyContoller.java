/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 21, 2018 9:05:50 PM
 * @Description
 */
package site.iotor.hello.spring.controller;

import java.security.Principal;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.iotor.hello.spring.model.User;

/**
 * @author Rancho
 */
@Controller
public class MyContoller {

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "index";
    }
    
    @GetMapping("/hello")
    public @ResponseBody User hello(Principal principal) {
        User user = new User();
        user.setUsername(principal.getName());
        user.setEnabled(true);
        return user;
    }
    
}
