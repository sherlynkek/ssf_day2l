package sg.edu.nus.iss.vttp5a_day2l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_day2l.model.Country;
import sg.edu.nus.iss.vttp5a_day2l.service.CountryService;

@Controller
@RequestMapping("countries")
public class CountryController {
   
    @Autowired
    CountryService countryService;

    @GetMapping()
    public String getCountries(Model model) {
        List <Country> countries = countryService.getCountriesList();
        model.addAttribute("countries", countries);

        return "country";
    }

    @GetMapping("/filter")
    public String filterCountries(@RequestParam("population") String popultion, Model model) {
        List <Country> countries = countryService.getCountriesList();
        countries = countries.stream().filter(c -> c.getPopulation() >= Integer.parseInt(popultion))
        .collect(Collectors.toList());
        model.addAttribute("countries", countries);

        return "country";
    }
}