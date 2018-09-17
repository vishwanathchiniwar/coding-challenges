package com.mhp.coding.challenges.mapping.controllers;

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Asdren Hoxha (MHP) - 17.09.18.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public List<ArticleDto> list() {
        return articleService.list();
    }

    @GetMapping("/{id}")
    public ArticleDto details(@PathVariable Long id) {
        return articleService.findBy(id);
    }
}
