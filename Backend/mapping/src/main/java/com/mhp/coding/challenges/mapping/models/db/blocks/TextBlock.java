package com.mhp.coding.challenges.mapping.models.db.blocks;

/**
 * @author Asdren Hoxha (MHP) - 17.09.18.
 */
public class TextBlock extends ArticleBlock {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
