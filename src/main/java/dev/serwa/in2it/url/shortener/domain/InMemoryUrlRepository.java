package dev.serwa.in2it.url.shortener.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryUrlRepository implements UrlRepository {

  private final Map<String, Url> urls;

  InMemoryUrlRepository() {
    this.urls = new ConcurrentHashMap<>();
  }

  @Override
  public Url save(Url url) {
    urls.put(url.id, url);

    return url;
  }

  @Override
  public Optional<Url> findById(String urlId) {
    return Optional.ofNullable(urls.get(urlId));
  }

  @Override
  public List<Url> findAll() {
    return new ArrayList<>(urls.values());
  }
}