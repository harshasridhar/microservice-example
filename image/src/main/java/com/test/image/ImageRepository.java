package com.test.image;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findAllByGalleryIdOrderByIdAsc(int galleryId);
}
