package com.boyal.demo.springr2dbcsamples.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;

//
// How to tweak NamingStrategy for Spring Data JDBC
// https://stackoverflow.com/questions/53334685/how-to-tweak-namingstrategy-for-spring-data-jdbc/53335830#53335830
//

@Configuration
public class R2dbcConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(R2dbcConfig.class);

	@Bean
	public NamingStrategy namingStrategy() {
		return new NamingStrategy() {
			@Override
			public String getTableName(Class<?> type) {
//				LOGGER.debug("@@@@@@ getTableName {}", type.getSimpleName());
				return type.getSimpleName();
			}

			@Override
			public String getColumnName(RelationalPersistentProperty property) {
//				LOGGER.debug("@@@@@@ getColumnName {}", property.getName());
				return property.getName();
			}
		};
	}
}
