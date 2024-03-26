package com.shuuriye;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class HelloController {
//    @GetMapping("/hello")
//    //@RequestMapping(value="/hello" , method = RequestMethod.GET)
//    //@ResponseBody
//    String show(){
//        return "Hello , welcome to Spring CA215!";
//    }

    @GetMapping
    public String helloHandler(Model model){
        model.addAttribute("name" , "Abdullaih ali");
        model.addAttribute("text" , "Jamhuriya university student");
        return "Hello";  //view name
    }

}
