package io.pivotal.portfolio.config.data;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;
import io.pivotal.portfolio.domain.Order;
import io.pivotal.spring.cloud.service.gemfire.GemfireServiceConnectorConfig;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;

/**
 * Created by cdelashmutt@pivotal.io on 1/25/2017.
 */
@Configuration
@Profile("gemfire-cloud")
public class GemfireCloudConfig extends AbstractCloudConfig {

	@Bean
	ClientCache myClientCache() {
		GemfireServiceConnectorConfig config = new GemfireServiceConnectorConfig();
		config.setPdxReadSerialized(false);
		config.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.portfolio.domain.*"));
		return cloud().getSingletonServiceConnector(ClientCache.class, config);
	}

	@Bean
	ClientRegionFactoryBean<String, Order> accountRegion(final ClientCache cache) {
		ClientRegionFactoryBean<String, Order> accountRegion = new ClientRegionFactoryBean<>();
		accountRegion.setCache(cache);
		accountRegion.setName("Order");
		accountRegion.setShortcut(ClientRegionShortcut.PROXY);
		return accountRegion;
	}
}
