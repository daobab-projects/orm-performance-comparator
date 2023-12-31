package io.daobab.performance.daobab.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Rating<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

    default F getRating() {
        return readParam("Rating");
    }

    default E setRating(F val) {
        return storeParam("Rating", val);
    }

    /**
     * table:FILM, type:VARCHAR, size:5, nullable:true
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    default Column<E, F, Rating> colRating() {
        return DaobabCache.getColumn("Rating", "RATING", (Table<?>) this, String.class);
    }
}
