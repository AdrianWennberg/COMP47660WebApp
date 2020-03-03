package com.ed.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@Controller
public class WebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAppApplication.class, args);
    }

    @RequestMapping(value = {"*"})
    public RedirectView defaultRedirect() {
        return new RedirectView("index.html");
    }

    @RequestMapping(value = {"/", "/index.html"})
    public String frontPage() {
        return "index";
    }
}
