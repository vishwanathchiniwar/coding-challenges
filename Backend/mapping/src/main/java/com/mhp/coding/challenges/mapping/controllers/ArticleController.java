package com.mhp.coding.challenges.mapping.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Asdren Hoxha (MHP) - 17.09.18.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping()
    public void list() {

    }

    @GetMapping("/{id}")
    public void details(@PathVariable Long id) {

    }
}
