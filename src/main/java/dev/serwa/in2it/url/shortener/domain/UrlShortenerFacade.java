package dev.serwa.in2it.url.shortener.domain;

import dev.serwa.in2it.url.shortener.dto.UrlNotFoundException;
import org.springframework.util.StringUtils;

public class UrlShortenerFacade {

  private final UrlRepository urlRepository;

  private final UrlShortener urlShortener;

  public UrlShortenerFacade(UrlRepository urlRepository, UrlShortener urlShortener) {
    this.urlRepository = urlRepository;
    this.urlShortener = urlShortener;
  }

  public String store(String urlToShorten) {
    UrlValidator.validate(urlToShorten);

    Url url = urlShortener.shorten(urlToShorten);

    return urlRepository.save(url).id;
  }

  public String getUrl(String urlShortcut) {
    requireText(urlShortcut);

    return urlRepository.findById(urlShortcut)
      .map(foundUrl -> foundUrl.url)
      .orElseThrow(() -> new UrlNotFoundException(urlShortcut + " was not found in the database"));
  }

  private void requireText(String urlShortcut) {
    if (!StringUtils.hasText(urlShortcut))
      throw new IllegalArgumentException("Url shortcut must contain text");
  }
}