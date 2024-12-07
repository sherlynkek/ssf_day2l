package sg.edu.nus.iss.vttp5a_day2l.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_day2l.model.Country;
import sg.edu.nus.iss.vttp5a_day2l.service.CountryService;

@RequestMapping("/weather")
public class WeatherController {
    
    @Autowired
    CountryService countryService;

    @GetMapping()
    public String weather(@RequestParam(required = true, name = "country",
    defaultValue = "Singapore") String city, @RequestParam(name = "units", 
    defaultValue = "celsius") String metric, Model model) {

        model.addAttribute("city", city);
        model.addAttribute("units", metric);

        return "weather";
    }

    // %20 in browser path is a space
    // http://localhost:8000/weather/city/Singapore/metrics/celsius
    @GetMapping("/city/{city}/units/{units}")
    public String weather2(@PathVariable(required = true, name = "city") String city,
    @PathVariable(name = "units") String metric, Model model) {

        model.addAttribute("city", city);
        model.addAttribute("units", metric);

        return "weather";
    }

    @GetMapping("/pagea")
    public String pageA(Model model) {
        String[] units = {"fahrenheit", "celsius", "kelvin"};
        List<Country> countries = countryService.getCountriesList();

        model.addAttribute("countries", countries);
        model.addAttribute("units", units);
        
        return "pagea";
    }

    @GetMapping("/forma")
    public String showForm() {
        return "forma";
    }

    @PostMapping("/forma")
    public String handlePageA(@RequestBody MultiValueMap<String, String> form) {
        // Map<String, String> formData = new HashMap<>();

        for(String str: form.keySet()) {
            // formData.put(str, form.getFirst(str));

            System.out.println(str + ">>>" + form.getFirst(str));
        }

        return "forma";
    }
    //multi-value map basically stores multiple request params eg.10 easily.
    //So we can pull the data easily and store in another object
}
