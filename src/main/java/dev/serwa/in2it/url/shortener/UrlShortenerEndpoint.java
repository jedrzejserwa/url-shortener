package dev.serwa.in2it.url.shortener;

import dev.serwa.in2it.url.shortener.domain.UrlShortenerFacade;
import dev.serwa.in2it.url.shortener.dto.UrlShortcut;
import dev.serwa.in2it.url.shortener.dto.UrlShortenerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UrlShortenerEndpoint {

  private static final Logger logger = LoggerFactory.getLogger(UrlShortenerFacade.class);

  private final UrlShortenerFacade urlShortenerFacade;

  public UrlShortenerEndpoint(UrlShortenerFacade urlShortenerFacade) {
    this.urlShortenerFacade = urlShortenerFacade;
  }

  @PostMapping("/shorten")
  @ResponseStatus(code = HttpStatus.CREATED)
  public UrlShortcut shorten(@RequestBody UrlShortenerRequest urlShortenerRequest) {
    logger.info("Shortening url for: {}", urlShortenerRequest);

    String urlShortcut = urlShortenerFacade.store(urlShortenerRequest.url);

    return new UrlShortcut(urlShortcut);
  }

  @GetMapping("/{urlShortcut}")
  public ResponseEntity<Object> redirect(@PathVariable String urlShortcut) {
    logger.info("Redirecting for url shortcut: {}", urlShortcut);

    String url = urlShortenerFacade.getUrl(urlShortcut);

    return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
      .header(HttpHeaders.LOCATION, url)
      .build();
  }
}