package com.smartmeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smartmeal.model.MenuItem;
import com.smartmeal.model.Preference;
import com.smartmeal.recommendation.RuleEngine;
import com.smartmeal.repository.MenuItemRepository;
import com.smartmeal.repository.PreferenceRepository;

@Service
public class RecommendationService {

    private final PreferenceRepository preferenceRepository;
    private final MenuItemRepository menuItemRepository;

    public RecommendationService(PreferenceRepository preferenceRepository,
                                 MenuItemRepository menuItemRepository) {
        this.preferenceRepository = preferenceRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> recommendAll(Long userId) {

        Optional<Preference> preferenceOptional =
                preferenceRepository.findByUserId(userId);

        if (preferenceOptional.isEmpty()) {
            return List.of();
        }

        Preference preference = preferenceOptional.get();

        List<MenuItem> menuItems = menuItemRepository.findAll();

        List<MenuItem> filtered =
                RuleEngine.filter(menuItems, preference);

        return filtered;
    }
}