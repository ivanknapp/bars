package ru.knappia.bars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.knappia.bars.repository.LegalEntity;
import ru.knappia.bars.service.BarService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequestMapping("/api")
@RestController
public class SearchController {

    @Autowired
    BarService barService;

    @RequestMapping("/getAllBars")
    public List<LegalEntity> getAllUsers() {
        return barService.getAllBars();
    }

    @RequestMapping("/getCount")
    public Long getCount() {
        return barService.getCount();
    }

    @RequestMapping(value = "/findBarByName/{barName}", method = RequestMethod.GET)
    public List<LegalEntity> getBarByName(@PathVariable String barName) {
        return Stream.concat(
                barService.searchByName(barName).stream(),
                Stream.concat(barService.searchByAddress(barName).stream(),
                        barService.searchByDistrict(barName).stream())
        )
                .distinct()
                .collect(Collectors.toList());
    }

}
