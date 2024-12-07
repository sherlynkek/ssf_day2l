package sg.edu.nus.iss.vttp5a_day2l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day2l.model.Country;

@Repository
public class CountryRepo {
    public List<Country> countriesList;

    public List<Country> getCountries() {
        countriesList = new ArrayList<>();

        Country crty = new Country("SG", "Singapore", 6000000);
        countriesList.add(crty);
        crty = new Country("MY", "Malaysia", 34000000);
        countriesList.add(crty);
        crty = new Country("CN", "China", 1411000000);
        countriesList.add(crty);
        crty = new Country("KR", "Korea", 52000000);
        countriesList.add(crty);
        crty = new Country("JP", "Japan", 125000000);
        countriesList.add(crty);

        return countriesList;
    }

    public Boolean createCountry(Country c) {
        if (countriesList == null){
            countriesList = new ArrayList<>();
        }
        countriesList.add(c);
        return true;
    }
}