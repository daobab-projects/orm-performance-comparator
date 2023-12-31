package io.daobab.performance.daobab.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface AddressId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

    default F getAddressId() {
        return readParam("AddressId");
    }

    default E setAddressId(F val) {
        return storeParam("AddressId", val);
    }

    /**
     * table:ADDRESS, type:SMALLINT, size:16, nullable:false
     * table:CUSTOMER, type:SMALLINT, size:16, nullable:false
     * table:STAFF, type:SMALLINT, size:16, nullable:false
     * table:STORE, type:SMALLINT, size:16, nullable:false
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    default Column<E, F, AddressId> colAddressId() {
        return DaobabCache.getColumn("AddressId", "ADDRESS_ID", (Table<?>) this, Integer.class);
    }
}
