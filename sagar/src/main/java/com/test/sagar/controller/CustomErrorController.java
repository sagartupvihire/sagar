package com.test.sagar.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
    
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // You can add custom logic to determine the error and redirect accordingly.
        // For a general error page, you can simply return the name of the custom error page.
        return "error"; // This corresponds to the "error.html" page.
    }

    // @Override
    // public String getErrorPath() {
    //     return "/error";
    // }
}
