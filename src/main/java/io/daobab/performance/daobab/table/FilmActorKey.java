package io.daobab.performance.daobab.table;

import io.daobab.model.Composite;
import io.daobab.model.CompositeColumns;
import io.daobab.model.Entity;
import io.daobab.model.TableColumn;
import io.daobab.performance.daobab.column.ActorId;
import io.daobab.performance.daobab.column.FilmId;

public interface FilmActorKey<E extends Entity & ActorId<E, Integer> & FilmId<E, Integer>>
        extends ActorId<E, Integer>, FilmId<E, Integer>, Composite<E> {

    default CompositeColumns<FilmActorKey<E>> compositeFilmActorKey() {
        return new CompositeColumns<>(
                new TableColumn(colActorId()).primaryKey().size(16),
                new TableColumn(colFilmId()).primaryKey().size(16));
    }


}
