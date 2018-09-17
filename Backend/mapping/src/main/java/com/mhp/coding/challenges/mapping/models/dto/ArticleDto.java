package com.mhp.coding.challenges.mapping.models.dto;


import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

import java.util.Collection;

/**
 * @author Asdren Hoxha (MHP) - 17.09.18.
 */
public class ArticleDto {

    private String title;

    private String description;

    private String author;

    private Collection<ArticleBlockDto> blocks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Collection<ArticleBlockDto> getBlocks() {
        return blocks;
    }

    public void setBlocks(Collection<ArticleBlockDto> blocks) {
        this.blocks = blocks;
    }
}
