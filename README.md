# Thermodataco

Technical test for Instaply

## Getting Started

Unzip the file or clone the project from the Github repository (https://github.com/imedgar/thermodataco) and import into your prefered IDE.


### Prerequisites

Java SE Development Kit 8


### Installing

In order to test the project, you should do a SpringBoot run command and it will deploy the project into the embedded tomcat

```
spring-boot:run
```

## Running the tests

From Eclipse:

Right click the src/test/java and Run as Junit test the whole package


## Request Examples:

There is 2 kind of ROLES and 2 Users for the testing set:

Roles - (USER, ADMIN)
User - (user, admin) Pwd - (password)

- USER role can report temperatures and check historial from Zones:

POST temperatures (report new temperature)

```
curl -X POST localhost:8080/temperatures -H "Content-type:application/json" 
	-d {\"zone\":\"A\",\"temperature\":{\"degrees\":20,\"scale\":\"CELSIUS\"}} -u user:password
```

GET historicals (get historical for a single Zone)
	
```
curl localhost:8080/historicals?zone=A -u user:password
```

- ADMIN role can also check all the zones

GET zones (get all the zones)

```
curl localhost:8080/zones -u admin:password
```


## Authors

* **Edgar Garcia**

