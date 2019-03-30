# url-shortener

Web application initially coded during IN2IT Workshops.

Domain: 
* Url shortener - see https://en.wikipedia.org/wiki/URL_shortening for details

Tech stack:
* Java 11
* Maven
* Spring boot 2.0
* Spock
* Redis

## Getting Started

### Prerequisites

* Java 11
* Redis Server

### Installing

Provide properties for Redis Server located under application.properties

```
spring.redis.host
spring.redis.port
spring.redis.password
```

## Running the tests

./mvnw clean test

## Deployment

./mvnw clean spring-boot:run

## Using


Shorten url:
````
curl -X POST \
  http://localhost:8080/url-shortener/v1/shorten \
  -d '{
	"url" : "https://sample-url.com"
}'
````

Access shortened url:
```
curl http://localhost:8080/url-shortener/v1/{urlShortcut}
```

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE](LICENSE) file for details

