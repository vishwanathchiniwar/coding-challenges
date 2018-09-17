package com.mhp.coding.challenges.mapping.models.db.blocks;

/**
 * @author Asdren Hoxha (MHP) - 17.09.18.
 */
public class VideoBlock extends ArticleBlock {

    private String url;

    private VideoBlockType type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VideoBlockType getType() {
        return type;
    }

    public void setType(VideoBlockType type) {
        this.type = type;
    }
}
