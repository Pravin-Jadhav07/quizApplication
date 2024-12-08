
##how to create an eureka service-registry
1.create spring boot web app using two dependencies
  a.Spring Web
  b.Eureka Server
  
2. Enable eureka server using @EnableEurekaServer annotation with @SpringBootApplication on main method.
   
3.configure in application.properties file
  spring.application.name=service-registry
  server.port=8761
  
  eureka.instance.hostname=lcalhost
  eureka.client.fetch-registry=false
  eureka.client.register-with-eureka=false
