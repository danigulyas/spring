package com.dani.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Handles home page, it's responsbile for displaying all the posts with the amount of comments.
 * @author dani
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public String home() {
        return "home";
    }
}
