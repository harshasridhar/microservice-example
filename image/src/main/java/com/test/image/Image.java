package com.test.image;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image {

    @Id
    private int id;
    @JsonIgnore
    @Column(name = "galleryId")
    private int galleryId;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;

    public Image(int id, int galleryId, String name, String url) {
        this.id = id;
        this.galleryId = galleryId;
        this.name = name;
        this.url = url;
    }

    public Image() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
