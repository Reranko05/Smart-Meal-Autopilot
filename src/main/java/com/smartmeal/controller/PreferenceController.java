package com.smartmeal.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartmeal.model.Preference;
import com.smartmeal.model.User;
import com.smartmeal.repository.PreferenceRepository;
import com.smartmeal.repository.UserRepository;

@RestController
@RequestMapping("/preferences")
public class PreferenceController {

    private final PreferenceRepository preferenceRepository;
    private final UserRepository userRepository;

    public PreferenceController(PreferenceRepository preferenceRepository,
                                UserRepository userRepository) {
        this.preferenceRepository = preferenceRepository;
        this.userRepository = userRepository;
    }

    // Save or update user preference
    @PostMapping("/{userId}")
    public Preference savePreference(@PathVariable Long userId,
                                     @RequestBody Preference preference) {

        // Ensure user exists (host app provides userId)
        User user = userRepository.findById(userId)
                .orElseGet(() -> userRepository.save(new User(userId)));

        preference.setUser(user);

        return preferenceRepository.save(preference);
    }

    // Get user preference
    @GetMapping("/{userId}")
    public Preference getPreference(@PathVariable Long userId) {

        Optional<Preference> preference =
                preferenceRepository.findByUserId(userId);

        return preference.orElse(null);
    }
}