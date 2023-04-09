package com.haydikodlayalim.accountservice.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.net.InetSocketAddress;

@EnableCassandraRepositories()
@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    @Value("${spring.data.cassandra.username}")
    private String username;

    @Value("${spring.data.cassandra.password}")
    private String password;

    @Value("${spring.data.cassandra.local-datacenter}")
    private String localDatacenter;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Bean
    @Primary
    public CqlSession session() {
        CqlSessionBuilder builder = CqlSession.builder()
                .withLocalDatacenter(localDatacenter)
                .addContactPoint(new InetSocketAddress(contactPoints, port))
                .withAuthCredentials(username, password);
        return builder.build();
    }
}