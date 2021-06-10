package lesgens.reactive.microservices;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "datasource.post")
    public DataSource postDataSource() {
        return DataSourceBuilder.create().build();
    }

   @Bean
   @ConfigurationProperties(prefix = "datasource.user")
    public DataSource userDataSource() {
       return DataSourceBuilder.create().build();
   }

    @Bean
    @ConfigurationProperties(prefix = "datasource.post.liquibase")
    public LiquibaseProperties postLiquibaseProperties() {
        return new LiquibaseProperties();
    }

  @Bean
    public SpringLiquibase postLiquibase() {
        return springLiquibase(postDataSource(), postLiquibaseProperties());
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.user.liquibase")
    public LiquibaseProperties userLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase userLiquibase() {
        return springLiquibase(userDataSource(), userLiquibaseProperties());
    }

    private static SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        liquibase.setContexts(properties.getContexts());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        liquibase.setLabels(properties.getLabels());
        liquibase.setChangeLogParameters(properties.getParameters());
        liquibase.setRollbackFile(properties.getRollbackFile());
        return liquibase;
    }
}
