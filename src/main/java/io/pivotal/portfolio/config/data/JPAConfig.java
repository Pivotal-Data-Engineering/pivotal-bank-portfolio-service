package io.pivotal.portfolio.config.data;

import io.pivotal.portfolio.repository.IdGenerator;
import io.pivotal.portfolio.repository.NullIdGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by grog on 1/25/2017.
 */
@Configuration
@Profile({"mysql", "in-memory"})
@EnableAutoConfiguration
@EnableJpaRepositories("io.pivotal.portfolio.repository")
@EntityScan("io.pivotal.portfolio.domain")
public class JPAConfig {

	@Bean
	IdGenerator entityidGenerator() {
		return new NullIdGenerator();
	}

}
