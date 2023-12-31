package io.daobab.performance.daobab.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface LanguageId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

    default F getLanguageId() {
        return readParam("LanguageId");
    }

    default E setLanguageId(F val) {
        return storeParam("LanguageId", val);
    }

    /**
     * table:FILM, type:TINYINT, size:8, nullable:false
     * table:LANGUAGE, type:TINYINT, size:8, nullable:false
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    default Column<E, F, LanguageId> colLanguageId() {
        return DaobabCache.getColumn("LanguageId", "LANGUAGE_ID", (Table<?>) this, Integer.class);
    }
}
