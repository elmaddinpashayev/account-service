package com.haydikodlayalim.accountservice.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories
@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    @Value("${spring.data.cassandra.local-datacenter}")
    private String localDatacenter;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.username}")
    private String username;

    @Value("${spring.data.cassandra.password}")
    private String password;

    @Value("${spring.data.cassandra.schema-action}")
    private String schemaAction;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected String getLocalDataCenter() {
        return localDatacenter;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.haydikodlayalim.accountservice"};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.valueOf(schemaAction);
    }

    @Bean
    @Primary
    public CqlSessionFactoryBean session() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints(getContactPoints());
        session.setKeyspaceName(getKeyspaceName());
        session.setLocalDatacenter(getLocalDataCenter());
        session.setSchemaAction(getSchemaAction());
        session.setUsername(username);
        session.setPassword(password);
        session.setPort(port);

        return session;
    }

    @Bean
    public CassandraConverter cassandraConverter() {
        return new MappingCassandraConverter(cassandraMappingContext());
    }

    @Bean
    public CassandraMappingContext cassandraMappingContext() {
        return new CassandraMappingContext();
    }
    @Bean
    public CassandraOperations cassandraTemplate(CqlSession session, CassandraConverter converter) {
        return new CassandraAdminTemplate(session, converter);
    }

    @Bean
    public CassandraConverter cassandraConverter(CassandraMappingContext mappingContext) {
        return new MappingCassandraConverter(mappingContext);
    }
    
}