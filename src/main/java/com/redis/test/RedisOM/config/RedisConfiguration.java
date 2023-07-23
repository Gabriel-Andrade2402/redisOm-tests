package com.redis.test.RedisOM.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.redis.test.RedisOM.models.Address;
import com.redis.test.RedisOM.models.Person;
import com.redis.test.RedisOM.repositories.PeopleRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {
	@Bean
	 CommandLineRunner loadTestData(PeopleRepository repo) {
	   return args -> {
	     repo.deleteAll();

	     String thorSays = "The Rabbit Is Correct, And Clearly The Smartest One Among You.";

	     // Serendipity, 248 Seven Mile Beach Rd, Broken Head NSW 2481, Australia
	     Address thorsAddress = Address.of("248", "Seven Mile Beach Rd", "Broken Head", "NSW", "2481", "Australia");

	     Person thor = Person.of("Chris", "Hemsworth", 38, thorSays, new Point(153.616667, -28.716667), thorsAddress, Set.of("hammer", "biceps", "hair", "heart"));

	     repo.save(thor);
	   };
	 }
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}
