package dev.serwa.in2it.url.shortener.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UrlShortenerFacadeConfiguration {

  UrlShortenerFacade inMemoryImplementation() {
    return create(new InMemoryUrlRepository());
  }

  @Bean
  UrlShortenerFacade facade(UrlRepository urlRepository) {
    return create(urlRepository);
  }

  private UrlShortenerFacade create(UrlRepository urlRepository) {
    return new UrlShortenerFacade(urlRepository, new UrlShortener());
  }
}