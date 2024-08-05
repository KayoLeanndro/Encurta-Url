package com.greensalad.URL_shortner.repository;

import com.greensalad.URL_shortner.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Integer> {

    @Query(value = "select original_url from url where short_url = ?1", nativeQuery = true)
    String findByShortUrl(String id);

    @Override
    Optional<Url> findById(Integer id);


}
