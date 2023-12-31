package io.daobab.performance.daobab.table;

import io.daobab.model.*;
import io.daobab.performance.daobab.column.CityId;
import io.daobab.performance.daobab.column.CountryId;
import io.daobab.performance.daobab.column.LastUpdate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@TableInformation(name = "CITY")
public class City extends Table<City> implements
        CityId<City, Integer>,
        io.daobab.performance.daobab.column.City<City, String>,
        CountryId<City, Integer>,
        LastUpdate<City, LocalDateTime>,

        PrimaryKey<City, Integer, CityId> {


    public City() {
        super();
    }

    public City(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colCityId()).primaryKey().size(16),
                new TableColumn(colCity()).size(50),
                new TableColumn(colCountryId()).size(16),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public Column<City, Integer, CityId> colID() {
        return colCityId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PrimaryKey<?, ?, ?> other = (PrimaryKey<?, ?, ?>) obj;
        return Objects.equals(getId(), other.getId());
    }


}
