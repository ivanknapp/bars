package ru.knappia.bars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.knappia.bars.model.request.SearchRequest;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model theModel) {
        theModel.addAttribute("search", new SearchRequest());
        return "search";
    }
}
