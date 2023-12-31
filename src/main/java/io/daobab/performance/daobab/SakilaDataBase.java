package io.daobab.performance.daobab;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.daobab.model.Entity;
import io.daobab.performance.daobab.table.Rental;
import io.daobab.target.database.DataBaseIdGeneratorSupplier;
import io.daobab.target.database.DataBaseTarget;
import io.daobab.target.database.connection.SqlProducer;
import io.daobab.target.protection.Access;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.h2.tools.RunScript;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SakilaDataBase extends DataBaseTarget implements SakilaTables, SqlProducer {

    private final RentalGenerator rentalGenerator;
    boolean recreate_database_on_start = false;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String pass;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Override
    protected DataSource initDataSource() {

        var config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(pass);
        config.setDriverClassName(driverClassName);
        config.setSchema("PUBLIC");
        var db = new HikariDataSource(config);

        if (recreate_database_on_start) {
            createDatabaseContent(db);
        }

        return db;
    }

    @PostConstruct
    public void init() {
        getAccessProtector().setColumnAccess(tabActor.colLastName(), Access.NO_INSERT, Access.NO_UPDATE);
        setShowSql(false);
    }


    @Override
    public List<Entity> initTables() {
        return Arrays.asList(
                tabActor,
                tabAddress,
                tabCategory,
                tabCity,
                tabCountry,
                tabCustomer,
                tabFilm,
                tabFilmActor,
                tabFilmCategory,
                tabFilmText,
                tabInventory,
                tabLanguage,
                tabPayment,
                tabRental,
                tabStaff,
                tabStore
        );
    }


    private void createDatabaseContent(DataSource ds) {

        try {
            var con = ds.getConnection();

            RunScript.execute(con, new BufferedReader(
                    new InputStreamReader(new ClassPathResource("schema.sql").getInputStream())));

            RunScript.execute(con, new BufferedReader(
                    new InputStreamReader(new ClassPathResource("data.sql").getInputStream())));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database initialize script error");
        }

    }

    @Override
    public <E extends Entity> DataBaseIdGeneratorSupplier<?> getPrimaryKeyGenerator(E entity) {

        if (entity.getClass().equals(Rental.class)) {
            return rentalGenerator;
        }
        return null;
    }

}
