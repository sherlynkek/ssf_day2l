package sg.edu.nus.iss.vttp5a_day2l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day2l.model.Country;

@Repository
public class CountryRepo {
    List<Country> countryList;
    
    public List<Country> getCountries() {

        countryList = new ArrayList<>();

        Country cty = new Country("SG", "Singapore", 60000000);
        countryList.add(cty);
        cty = new Country("MY", "Malaysia", 8000000);
        countryList.add(cty);
        cty = new Country("CH", "China", 100000000);
        countryList.add(cty);
        cty = new Country("EU", "Europe", 9000000);
        countryList.add(cty);
        cty = new Country("KR", "Korea", 5000000);
        countryList.add(cty);

        return countryList;
    }

    public Boolean createCountry(Country cty) {
        if (countryList == null)
        countryList = new ArrayList<>();
        
        countryList.add(cty);
        return true;
    }

    
}
