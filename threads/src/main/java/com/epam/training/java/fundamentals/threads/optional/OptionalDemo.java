package com.epam.training.java.fundamentals.threads.optional;

import java.util.Optional;

import static com.epam.training.java.fundamentals.threads.optional.City.findCityByZipCode;
import static com.epam.training.java.fundamentals.threads.optional.User.findUser;

public class OptionalDemo {

    public static String getUsersCityNameWithoutOptional() {
        User user = findUser();
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String zipCode = address.getZipCode();
                if (zipCode != null) {
                    City city = findCityByZipCode(zipCode);
                    if (city != null)
                        return city.getName();
                }
            }
        }
        throw new RuntimeException();
    }

    public static String getUsersCityNameWithOptional() {
        return Optional.ofNullable(findUser())
                .map(User::getAddress)
                .map(Address::getZipCode)
                .map(City::findCityByZipCode)
                .map(City::getName)
                .orElseThrow(RuntimeException::new);
    }
}