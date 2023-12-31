package io.daobab.performance.daobab.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface FirstName<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

    default F getFirstName() {
        return readParam("FirstName");
    }

    default E setFirstName(F val) {
        return storeParam("FirstName", val);
    }

    /**
     * table:ACTOR, type:VARCHAR, size:45, nullable:false
     * table:CUSTOMER, type:VARCHAR, size:45, nullable:false
     * table:STAFF, type:VARCHAR, size:45, nullable:false
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    default Column<E, F, FirstName> colFirstName() {
        return DaobabCache.getColumn("FirstName", "FIRST_NAME", (Table<?>) this, String.class);
    }
}
