package com.dani.blog.web;

import com.dani.blog.data.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Handles home page, it's responsbile for displaying all the posts with the amount of comments.
 * @author dani
 */

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

    private final PostRepository postRepository;

    @RequestMapping(value = "/", method = GET)
    public String home(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "home";
    }
}
