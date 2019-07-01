package ru.knappia.bars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.knappia.bars.repository.Bar;
import ru.knappia.bars.service.BarService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequestMapping("/api")
@Controller
public class SearchController {

    @Autowired
    BarService barService;

//    @RequestMapping("/getAllBars")
//    public List<Bar> getAllUsers() {
//        return barService.getAllBars();
//    }

    @RequestMapping("/getCount")
    public Long getCount() {
        return barService.getCount();
    }

    @GetMapping("/sample")
    public String showForm(Model model) {
        List<Bar> allBars = barService.getAllBars();

        model.addAttribute("bar", allBars.get(0));
        return "sample";
    }

    @GetMapping("/getAllBars")
    public String getAllBars(Model model) {
        List<Bar> allBars = barService.getAllBars().subList(0, 10);
        Collections.shuffle(allBars);
        model.addAttribute("allBars", allBars);
        return "allBars";
    }

    @RequestMapping(value = "/findBarByName/{barName}", method = RequestMethod.GET)
    public List<Bar> getBarByName(@PathVariable String barName) {
        return Stream.concat(
                barService.searchByName(barName).stream(),
                Stream.concat(barService.searchByAddress(barName).stream(),
                        barService.searchByDistrict(barName).stream())
        )
                .distinct()
                .collect(Collectors.toList());
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
