package io.daobab.performance.daobab.table.enhanced;

import io.daobab.model.Column;
import io.daobab.model.EnhancedEntity;
import io.daobab.model.TableInformation;
import io.daobab.performance.daobab.table.City;
import io.daobab.performance.daobab.table.Country;
import io.daobab.query.base.Query;
import io.daobab.query.base.QueryJoin;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@TableInformation(name = "CITY")
public class CountryCity extends City implements
        io.daobab.performance.daobab.column.Country<City, Integer>,
        EnhancedEntity {

    private static final Country tabCountry = new Country();

    public CountryCity() {
        super();
    }

    public CountryCity(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public List<Column> joinedColumns() {
        return Collections.singletonList(
                tabCountry.colCountry()
        );
    }


    @Override
    public <Q extends Query & QueryJoin<Q>> Q enhanceQuery(Q query) {
        return query
                .join(tabCountry, colCountryId());
    }
}
