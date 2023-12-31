package io.daobab.performance.daobab.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Address<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

    default F getAddress() {
        return readParam("Address");
    }

    default E setAddress(F val) {
        return storeParam("Address", val);
    }

    /**
     * table:ADDRESS, type:VARCHAR, size:50, nullable:false
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    default Column<E, F, Address> colAddress() {
        return DaobabCache.getColumn("Address", "ADDRESS", (Table<?>) this, String.class);
    }
}
