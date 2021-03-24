# Spring Cloud Streams - Getting Started Examples

These samples have been hand-picked from the [Spring Cloud Stream samples](https://github.com/spring-cloud/spring-cloud-stream-samples) project in order to demonstrate the functionality of the [Spring Cloud Stream Binder for Solace PubSub+](https://github.com/SolaceProducts/spring-cloud-stream-binder-solace). Aside from their configuration, these applications have remained mostly untouched.

## Spring Cloud Stream Binder for Solace PubSub+

The repository contains example applications that uses a Solace implementation of Spring's Cloud Stream Binder for connecting applications to Solace Pubsub+ services. You can get more details on the Spring Cloud Stream Binder for Solace PubSub+ [here](https://github.com/SolaceProducts/spring-cloud-stream-binder-solace/).

This repository contains sample applications which demonstrate the following use cases:

* A simple processor application
* An application which can create and produce to dynamic destinations
* An application which can process data in a reactive manner
* An application which inserts data into a database through JDBC

What follows is a brief summary for people that want to dive straight into the code.

## Common Setup

Aside from having the credentials to an accessible Solace PubSub+ service and a running MySql service (only for the JDBC sample), each application can effectively be ran standalone.

### Building

Just clone and build. For example:

1. Clone this GitHub repository
1. Place your Solace credentials (and MySql credentials if required) in each application's `application.yml` file
1. `mvn clean package`

### Deploying

To run the individual applications:

1. cd to the project directory (e.g. `streamlistener-basic`)
1. `java -jar target/{PROJECT-NAME}-0.0.1-SNAPSHOT.jar`

Aside from the initial configuration of their `application.yml` files, each sample was designed to run with minimal intervention from the user. Unless specified otherwise in that application's specific documentation, the application can be observed by just watching its log output.

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

See the list of [contributors](https://github.com/SolaceLabs/solace-samples-spring-cloud-stream/contributors) who participated in this project.

## License

This project is licensed under the Apache License, Version 2.0. - See the [LICENSE](LICENSE) file for details.

## Resources

For more information about the Spring Cloud Streams Binder for Solace PubSub+:

- [Github Source - Spring Cloud Streams Binder for Solace PubSub+](https://github.com/SolaceProducts/spring-cloud-stream-binder-solace/)

For more information about Spring Cloud Streams try these resources:

- [Spring Docs - Spring Cloud Stream Reference Guide](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/)
- [GitHub Samples - Spring Cloud Stream Sample Applications](https://github.com/spring-cloud/spring-cloud-stream-samples)
- [Github Source - Spring Cloud Stream Source Code](https://github.com/spring-cloud/spring-cloud-stream)

For more information about Solace technology in general please visit these resources:

- The Solace Developer Portal website at: http://dev.solace.com
- Understanding [Solace technology](http://dev.solace.com/tech/)
- Ask the [Solace community](http://dev.solace.com/community/)
