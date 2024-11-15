package sg.edu.nus.iss.vttp5a_day2l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_day2l.model.Country;
import sg.edu.nus.iss.vttp5a_day2l.repo.CountryRepo;

@Service
public class CountryService {
    
    @Autowired
    CountryRepo countryRepo;

    public List<Country> getCountries() {
        return countryRepo.getCountries();
    }

    public Boolean createCountry(Country c) {
        Boolean result = countryRepo.createCountry(c);

        return result;
    }
}
