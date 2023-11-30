package com.OneToOneMapping.controller;

import com.OneToOneMapping.entity.Country;
import com.OneToOneMapping.entity.State;
import com.OneToOneMapping.repository.CountryRepository;
import com.OneToOneMapping.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryRepository countryrepository;

    @Autowired
    private StateRepository stateRepository;

    @PostMapping("/country")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Set<State> states = country.getState();
        stateRepository.saveAll(states);
        country.setState(states);
        countryrepository.save(country);
        return ResponseEntity.ok(country);
    }

    @GetMapping("/get")
    public List<Country> getAllCountries() {
        List<Country> countries = countryrepository.findAll();
        return countries;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        countryrepository.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping("/{id}")
    public Country updateCountryWithStates(
            @PathVariable("id") Long id,
            @RequestBody Country updatedCountryWithStates) {
        Country country = countryrepository.findById(id).orElseThrow(null);
        country.setCountryName(updatedCountryWithStates.getCountryName());
        country.setCountryPmName(updatedCountryWithStates.getCountryPmName());
        Country country1 = countryrepository.save(country);
        return  country1;
    }

}



