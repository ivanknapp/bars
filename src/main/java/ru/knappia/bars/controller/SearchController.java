package ru.knappia.bars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.knappia.bars.model.request.SearchRequest;
import ru.knappia.bars.repository.Bar;
import ru.knappia.bars.service.BarService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequestMapping("/api")
@Controller
public class SearchController {

    @Autowired
    BarService barService;

    @RequestMapping("/getCount")
    public Long getCount() {
        return barService.getCount();
    }

    @RequestMapping("/home")
    public String home(Model theModel) {
        theModel.addAttribute("search", new SearchRequest());
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

    @PostMapping(value = "/findBarByName")
    public String getBarByName(@ModelAttribute("search") SearchRequest searchRequest, Model theModel) {
        final String query = searchRequest.getQuery();
        List<Bar> bars = Stream.concat(
                barService.searchByName(query).stream(),
                Stream.concat(barService.searchByAddress(query).stream(),
                        barService.searchByDistrict(query).stream())
        )
                .distinct()
                .collect(Collectors.toList());
        theModel.addAttribute("search", new SearchRequest(){{setQuery(query);}});
        theModel.addAttribute("allBars", bars);
        theModel.addAttribute("count", bars.size());
        return "search";
    }

    @RequestMapping(value = "/restaurant/{barId}", method = RequestMethod.GET)
    public Bar getBarById(@PathVariable Integer barId) {
        return barService.findBarById(barId).orElseThrow(IllegalArgumentException::new);
    }

    @RequestMapping(value = "/restaurants/{barType}", method = RequestMethod.GET)
    public List<Bar> getBarById(@PathVariable String barType) {
        return barService.findBarByType(barType);
    }
}
