package io.daobab.performance.daobab.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface ManagerStaffId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

    default F getManagerStaffId() {
        return readParam("ManagerStaffId");
    }

    default E setManagerStaffId(F val) {
        return storeParam("ManagerStaffId", val);
    }

    /**
     * table:STORE, type:TINYINT, size:8, nullable:false
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    default Column<E, F, ManagerStaffId> colManagerStaffId() {
        return DaobabCache.getColumn("ManagerStaffId", "MANAGER_STAFF_ID", (Table<?>) this, Integer.class);
    }
}
