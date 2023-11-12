package io.daobab.performance.daobab.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import io.daobab.performance.daobab.Lang;

public interface NameLang<E extends Entity> extends RelatedTo<E>, MapHandler<E> {


    /**
     * db name: NAME,
     * db type: VARCHAR
     */
    default Lang getName() {
        return readParam("Name");
    }

    default E setName(Lang val) {
        return storeParam("Name", val);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, Lang, NameLang> colName() {
        return DaobabCache.getColumn("Name", "NAME", (Table<?>) this, Lang.class);
    }


}
