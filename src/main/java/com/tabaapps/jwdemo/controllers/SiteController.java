package com.tabaapps.jwdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RestController
public class SiteController {

    @GetMapping
    public String showIndexPage(Principal principal){
        return principal.getName();
    }

    @GetMapping("/age")
    public Object computeAge(){
        LocalDate dob = LocalDate.parse("2004-05-04");
        Period period = Period.between(dob,LocalDate.now());
        Set items = new HashSet();
        items.add(period.getYears());
        items.add(period.getMonths());
        items.add(period.getDays());
        return items;
    }

}
