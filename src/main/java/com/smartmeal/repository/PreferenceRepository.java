package com.smartmeal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartmeal.model.Preference;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    Optional<Preference> findByUserId(Long userId);

}