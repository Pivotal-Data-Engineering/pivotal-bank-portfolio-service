package io.pivotal.portfolio.config.data;

import com.gemstone.gemfire.cache.GemFireCache;
import io.pivotal.portfolio.domain.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import java.util.Properties;

/**
 * Created by grog on 1/25/2017.
 */
@Configuration
@Profile("gemfire-local")
public class GemfireLocalConfig {

	@Bean
	Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "DataGemFireApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		gemfireProperties.setProperty("log-level", "config");
		return gemfireProperties;
	}

	@Bean
	CacheFactoryBean gemfireCache() {
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setClose(true);
		gemfireCache.setProperties(gemfireProperties());
		return gemfireCache;
	}

	@Bean
	LocalRegionFactoryBean<String, Order> orderRegion(final GemFireCache cache) {
		LocalRegionFactoryBean<String, Order> orderRegion = new LocalRegionFactoryBean<>();
		orderRegion.setCache(cache);
		orderRegion.setClose(false);
		orderRegion.setName("Order");
		orderRegion.setPersistent(false);
		return orderRegion;
	}

}
