package io.daobab.performance.daobab.table;


import io.daobab.model.*;
import io.daobab.performance.daobab.column.AddressId;
import io.daobab.performance.daobab.column.LastUpdate;
import io.daobab.performance.daobab.column.ManagerStaffId;
import io.daobab.performance.daobab.column.StoreId;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@TableInformation(name = "STORE")
public class Store extends Table<Store> implements
        StoreId<Store, Integer>,
        ManagerStaffId<Store, Integer>,
        AddressId<Store, Integer>,
        LastUpdate<Store, LocalDateTime>,

        PrimaryKey<Store, Integer, StoreId> {


    public Store() {
        super();
    }

    public Store(Map<String, Object> parameters) {
        super(parameters);
    }


    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colStoreId()).primaryKey().size(8),
                new TableColumn(colManagerStaffId()).size(8),
                new TableColumn(colAddressId()).size(16),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public Column<Store, Integer, StoreId> colID() {
        return colStoreId();
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
