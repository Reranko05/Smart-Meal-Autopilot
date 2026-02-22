package com.smartmeal.recommendation;

import java.util.List;
import java.util.stream.Collectors;

import com.smartmeal.model.MenuItem;
import com.smartmeal.model.Preference;

public class RuleEngine {

    public static List<MenuItem> filter(List<MenuItem> menuItems,
                                        Preference preference) {

        if (menuItems == null || preference == null) {
            return List.of();
        }

        return menuItems.stream()

                // Rule 1: Diet type must match
                .filter(item ->
                        item.getDietType() != null &&
                        item.getDietType().equalsIgnoreCase(preference.getDietType()))

                // Rule 2: Calories must be within limit
                .filter(item ->
                        item.getCalories() <= preference.getCalorieLimit())

                // Rule 3: Price must be within budget
                .filter(item ->
                        item.getPrice() <= preference.getBudget())

                .collect(Collectors.toList());
    }
}