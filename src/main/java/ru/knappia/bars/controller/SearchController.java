package ru.knappia.bars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.knappia.bars.repository.BarEntity;
import ru.knappia.bars.service.BarService;

import java.util.List;


@RequestMapping("/api")
@RestController
public class SearchController {

    @Autowired
    BarService barService;

    @RequestMapping("/getAllBars")
    public List<BarEntity> getAllUsers() {
        return barService.getAllBars();
    }

    @RequestMapping("/getCount")
    public Long getCount() {
        return barService.getCount();
    }

}
