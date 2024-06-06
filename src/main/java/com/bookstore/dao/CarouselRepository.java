package com.bookstore.dao;

import com.bookstore.model.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarouselRepository extends JpaRepository<Carousel, Long> {

}
