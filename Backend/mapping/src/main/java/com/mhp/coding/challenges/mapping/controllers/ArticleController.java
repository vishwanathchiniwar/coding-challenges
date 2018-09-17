package com.mhp.coding.challenges.mapping.controllers;

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;
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
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping()
    public List<ArticleDto> list() {
        final List<Article> result = articleRepository.list();
        //TODO Challenge
        return null;
    }

    @GetMapping("/{id}")
    public ArticleDto details(@PathVariable Long id) {
        final Article result = articleRepository.findBy(id);
        //TODO Challenge
        return null;
    }
}
