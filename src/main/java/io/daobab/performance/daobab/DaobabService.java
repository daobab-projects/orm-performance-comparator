package io.daobab.performance.daobab;

import io.daobab.performance.daobab.table.Actor;
import io.daobab.performance.daobab.table.Payment;
import io.daobab.statement.function.FunctionWhispererH2;
import io.daobab.target.buffer.single.Entities;
import io.daobab.target.buffer.single.Plates;
import io.daobab.target.database.query.frozen.FrozenDataBaseQueryEntity;
import io.daobab.target.database.query.frozen.FrozenDataBaseQueryField;
import io.daobab.target.database.query.frozen.FrozenDataBaseQueryPlate;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static io.daobab.target.database.query.frozen.DaoParam.param;

@Component
@RequiredArgsConstructor
public class DaobabService implements SakilaTables, FunctionWhispererH2 {

    private final SakilaDataBase db;

    private FrozenDataBaseQueryEntity<Actor> getActorById;
    private FrozenDataBaseQueryEntity<Actor> getActors;
    private FrozenDataBaseQueryField<Payment, Double> getCustomerPaymentsSum;

    private FrozenDataBaseQueryPlate getCustomerAdsresses;

    @PostConstruct
    protected void init() {
        getActorById = db.select(tabActor).whereEqual(tabActor.colID(), param(1)).freezeQuery();
        getActors = db.select(tabActor).freezeQuery();
        getCustomerPaymentsSum = db.select(sum(tabPayment.colAmount()).cast(Double.class)).whereEqual(tabPayment.colCustomerId(), param(1)).freezeQuery();
        getCustomerAdsresses = db
                .select(tabCustomer.colFirstName(), tabCustomer.colLastName(), tabAddress.colAddress(), tabCity.colCity())
                .join(tabAddress, tabCustomer.colAddressId())
                .join(tabCity, tabAddress.colCityId())
                .freezeQuery();
    }

    public Actor getActorById(int id) {
        return getActorById.withParameters(id).findOne();
    }

    public Entities<Actor> getActors() {
        return getActors.findMany();
    }

    public Double getCustomerPaymentsSum(Integer customerId) {
        return getCustomerPaymentsSum.withParameters(customerId).findOne();
    }

    public Plates getCustomerAddresses() {
        return getCustomerAdsresses.findMany();
    }


}
