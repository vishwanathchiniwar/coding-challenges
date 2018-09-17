package com.mhp.coding.challenges.mapping.models;

import com.mhp.coding.challenges.mapping.models.blocks.ArticleBlock;

import java.util.Set;

/**
 * @author Asdren Hoxha (MHP) - 17.09.18.
 */
public class Article extends DBEntity {

    private String title;

    private String description;

    private String author;

    private Set<ArticleBlock> blocks;
}
