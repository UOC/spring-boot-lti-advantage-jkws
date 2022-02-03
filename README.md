# Spring Boot LTI Advantage JKWS library

JKWS library for LTI Advantage Spring Boot projects. Adds a public keyset URI to your LTI Advantege application
See https://github.com/UOC/java-lti-1.3-provider-example for an example.

## Usage

1. Set your maven installation to work with Github packages, following https://help.github.com/en/packages/using-github-packages-with-your-projects-ecosystem/configuring-apache-maven-for-use-with-github-packages#authenticating-to-github-packages

  Repository info:
  
  ```xml
    <repositories>
      <repository>
        <id>github-uoc-lti-core</id>
        <name>GitHub UOC Apache Maven Packages</name>
        <url>https://maven.pkg.github.com/uoc/java-lti-1.3-core</url>
      </repository>				
      <repository>
        <id>github-uoc-lti-jwt</id>
        <name>GitHub UOC Apache Maven Packages</name>
        <url>https://maven.pkg.github.com/uoc/java-lti-1.3-jwt</url>
      </repository>				
      <repository>
        <id>github-uoc-lti</id>
        <name>GitHub UOC Apache Maven Packages</name>
        <url>https://maven.pkg.github.com/uoc/java-lti-1.3</url>
      </repository>				
      <repository>
        <id>github-uoc-lti-springboot</id>
        <name>GitHub UOC Apache Maven Packages</name>
        <url>https://maven.pkg.github.com/uoc/spring-boot-lti-advantage</url>
      </repository>
    </repositories>
  ```

2. Add the dependency to your `pom.xml` file:

```xml
  <dependency>
	<groupId>edu.uoc.elc.lti</groupId>
	<artifactId>spring-boot-lti-advantage-jkws</artifactId>
	<version>1.0.0</version>
  </dependency>
```  


## Installation

This library depends on the following additional libraries:

* [LTI 1.3 JWT](https://github.com/UOC/java-lti-1.3-jwt)
* [Springboot LTI Advantage](https://github.com/UOC/spring-boot-lti-advantage)

Install it using maven:

```bash
./mvnw install
```

## About

This library makes essentially one thing: Define a controller for serving Keys to a LTI platform. The Controller is
defined in `edu.uoc.elc.spring.lti.jkws.WellKnowKeysController`, and depens on `edu.uoc.elc.spring.lti.tool.registration.RegistrationService` 
(defined in [Springboot LTI Advantage](https://github.com/UOC/spring-boot-lti-advantage))for getting the keys

### Configuration

`edu.uoc.elc.spring.lti.jkws.WellKnowKeysController` defines its path via the `jkws.wellkownuri` property. So, defining this property in your `application.yaml` or `application.properties` will work.
If not present, the default path is `/.well-known/jwks.json`.

Take into account that you'll need to scan the package in your application for setting into spring mvc. This is done via adding to you Application:

```
@ComponentScan({"edu.uoc.elc.spring.lti.jkws"})
```

## Contributing

Thanks for being interested in this project. The way of contributing is the common for almost all projects:

1. Fork the project to your account
2. Implement your changes
3. Make a pull request

If you need further information contact to `xaracil at uoc dot edu`
