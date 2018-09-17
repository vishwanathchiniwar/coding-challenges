package com.mhp.coding.challenges.mapping.models.blocks;

/**
 * @author Asdren Hoxha (MHP) - 17.09.18.
 */
public abstract class ArticleBlock {

    private int sortIndex;

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}
