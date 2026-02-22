package com.smartmeal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartmeal.model.MenuItem;
import com.smartmeal.repository.MenuItemRepository;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    private final MenuItemRepository menuItemRepository;

    public MenuItemController(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    // Add new menu item
    @PostMapping
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    // Get all menu items
    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    // Get menu item by id
    @GetMapping("/{id}")
    public MenuItem getMenuItem(@PathVariable Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }
}