package dev.serwa.in2it.url.shortener.domain;


import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface UrlRepository extends Repository<Url, String> {
  Url save(Url url);

  Optional<Url> findById(String urlId);

  List<Url> findAll();
}