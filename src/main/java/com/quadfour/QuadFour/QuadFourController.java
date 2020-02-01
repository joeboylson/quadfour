package com.quadfour.QuadFour;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuadFourController {

    @RequestMapping("/")
    public String index() {

        // could also call this index or home
        // ... /start

        return "index";
    }
}