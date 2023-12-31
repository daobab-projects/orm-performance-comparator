package io.daobab.performance.daobab.table;

import io.daobab.model.*;
import io.daobab.performance.daobab.column.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@TableInformation(name = "CUSTOMER")
public class Customer extends Table<Customer> implements
        CustomerId<Customer, Integer>,
        StoreId<Customer, Integer>,
        FirstName<Customer, String>,
        LastName<Customer, String>,
        Email<Customer, String>,
        AddressId<Customer, Integer>,
        Active<Customer, Boolean>,
        CreateDate<Customer, LocalDateTime>,
        LastUpdate<Customer, LocalDateTime>,

        PrimaryKey<Customer, Integer, CustomerId> {


    public Customer() {
        super();
    }

    public Customer(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colCustomerId()).primaryKey().size(16),
                new TableColumn(colStoreId()).size(8),
                new TableColumn(colFirstName()).size(45),
                new TableColumn(colLastName()).size(45),
                new TableColumn(colEmail()).size(50),
                new TableColumn(colAddressId()).size(16),
                new TableColumn(colActive()).size(1),
                new TableColumn(colCreateDate()).size(26).scale(6),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public Column<Customer, Integer, CustomerId> colID() {
        return colCustomerId();
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
