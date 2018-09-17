package com.mhp.coding.challenges.mapping.models;

import com.mhp.coding.challenges.mapping.models.blocks.ImageSize;

/**
 * @author Asdren Hoxha (MHP) - 17.09.18.
 */
public class Image extends DBEntity {

    private String url;

    private ImageSize imageSize;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageSize getImageSize() {
        return imageSize;
    }

    public void setImageSize(ImageSize imageSize) {
        this.imageSize = imageSize;
    }
}
