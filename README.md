# canban-api

Spring Boot + MySQL + Docker Example

## Production

```
./gradlew build -x test
docker-compose up --build
```

## Development

Remote debugging port `5005`

Hot Swapping support


```
docker-compose -f docker-compose-dev.yml up --build
```
