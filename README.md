Spring Boot Web Application for Item Validation

# Technologies used:
- [x] Java
- [x] Spring Boot
- [x] Postman
- [x] IntelliJ Idea

## Sample Test Cases
```
status code : 200
curl --location --request POST 'localhost:8080/api/items/validate' \
--header 'Content-Type: application/json' \
--data-raw '{
  "siteId": 123,
  "categoryId": 123,
  "title": "Example Item",
  "condition": "NEW",
  "price": 99.99,
  "quantity": 1,
  "imageURLs": [
    "https://example.com/image1.jpg",
    "https://example.com/image2.jpg"
  ],
    "itemSpecifics": [
        "test",
        "check"
    ],
  "description": "This is an example item"
}
'
status code : 200
error:
curl --location --request POST 'localhost:8080/api/items/validate' \
--header 'Content-Type: application/json' \
--data-raw '{
  "siteId": 123,
  "categoryId": null,
  "title": "Example Item",
  "condition": "NEW",
  "price": 99.99,
  "quantity": -1,
  "imageURLs": [
    "https://example.com/image1.jpg",
    "https://example.com/image2.jpg"
  ],
    "itemSpecifics": [
        "test",
        "check"
    ],
  "description": "This is an example item"
}
'
```
Sample Test Case for POST /api/items/validate

If you want to check the metrics :
use the below command:
```agsl
docker run -d -p 9411:9411 openzipkin/zipkin
```
or if docker is not installed,
```agsl
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```
Then navigate to http://127.0.0.1:9411/zipkin/ to see metrics

![Screenshot 2023-04-06 at 23.32.31.png](..%2F..%2F..%2F..%2Fvar%2Ffolders%2F60%2F55zqbfs91b33bbd62lb_ygfm0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_aY3PbL%2FScreenshot%202023-04-06%20at%2023.32.31.png)
