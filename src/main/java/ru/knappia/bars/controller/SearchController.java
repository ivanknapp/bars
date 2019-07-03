package ru.knappia.bars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.knappia.bars.model.request.SearchRequest;
import ru.knappia.bars.repository.Bar;
import ru.knappia.bars.service.BarService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class SearchController {

    @Autowired
    BarService barService;

    @RequestMapping("/home")
    public String home(Model theModel) {
        theModel.addAttribute("searchRequest", new SearchRequest());
        theModel.addAttribute("allBars", new ArrayList<>());
        theModel.addAttribute("count", barService.getCount());
        return "search";
    }

    @GetMapping("/getAllBars")
    public String getAllBars(Model model) {
        List<Bar> allBars = barService.getAllBars().subList(0, 10);
        Collections.shuffle(allBars);
        model.addAttribute("allBars", allBars);
        return "allBars";
    }

    @PostMapping(value = "/search")
    public String getBarByName(@Valid SearchRequest searchRequest, BindingResult result, Model theModel) {
        if (result.hasErrors()){
            throw new RuntimeException("agaga");
        }
        final String query = searchRequest.getQuery();
        List<Bar> bars = Stream.concat(
                barService.searchByName(query).stream(),
                Stream.concat(barService.searchByAddress(query).stream(),
                        barService.searchByDistrict(query).stream())
        )
                .distinct()
                .collect(Collectors.toList());
        theModel.addAttribute("searchRequest", new SearchRequest(){{setQuery(query);}});
        theModel.addAttribute("allBars", bars);
        theModel.addAttribute("count", bars.size());
        return "search";
    }

    @RequestMapping(value = "/restaurant/{barId}", method = RequestMethod.GET)
    public String getBarById(@PathVariable Integer barId, Model theModel) {
        theModel.addAttribute("restaraunt", barService.findBarById(barId).orElseThrow(IllegalArgumentException::new));
        return "restaraunt_page";
    }

    @RequestMapping(value = "/restaurants/{barType}", method = RequestMethod.GET)
    public String getBarById(@PathVariable String barType, Model theModel) {

        List<Bar> bars = barService.findBarByType(barType);
        theModel.addAttribute("searchRequest", new SearchRequest(){{setQuery(barType);}});
        theModel.addAttribute("allBars", bars);
        theModel.addAttribute("count", bars.size());

        return "search";
    }
}
