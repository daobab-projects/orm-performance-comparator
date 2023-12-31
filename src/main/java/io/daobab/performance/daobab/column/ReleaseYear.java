package io.daobab.performance.daobab.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;

import java.time.LocalDate;

public interface ReleaseYear<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

    default F getReleaseYear() {
        return readParam("ReleaseYear");
    }

    default E setReleaseYear(F val) {
        return storeParam("ReleaseYear", val);
    }

    /**
     * table:FILM, type:DATE, size:10, nullable:true
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    default Column<E, F, ReleaseYear> colReleaseYear() {
        return DaobabCache.getColumn("ReleaseYear", "RELEASE_YEAR", (Table<?>) this, LocalDate.class);
    }
}
