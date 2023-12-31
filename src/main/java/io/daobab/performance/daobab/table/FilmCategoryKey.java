package io.daobab.performance.daobab.table;

import io.daobab.model.Composite;
import io.daobab.model.CompositeColumns;
import io.daobab.model.Entity;
import io.daobab.model.TableColumn;
import io.daobab.performance.daobab.column.CategoryId;
import io.daobab.performance.daobab.column.FilmId;

public interface FilmCategoryKey<E extends Entity & FilmId<E, Integer> & CategoryId<E, Integer>>
        extends FilmId<E, Integer>, CategoryId<E, Integer>, Composite<E> {

    default CompositeColumns<FilmCategoryKey<E>> compositeFilmCategoryKey() {
        return new CompositeColumns<>(
                new TableColumn(colFilmId()).primaryKey().size(16),
                new TableColumn(colCategoryId()).primaryKey().size(8));
    }


}
