package io.daobab.performance.daobab.table;

import io.daobab.model.*;
import io.daobab.performance.daobab.column.CategoryId;
import io.daobab.performance.daobab.column.LastUpdate;
import io.daobab.performance.daobab.column.Name;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("rawtypes")
@TableInformation(name = "CATEGORY", idGenerator = IdGeneratorType.SEQUENCE, sequenceName = "CATEGORY_SEQ")
public class Category extends Table<Category> implements
        CategoryId<Category, Integer>,
        Name<Category, String>,
        LastUpdate<Category, LocalDateTime>,

        PrimaryKey<Category, Integer, CategoryId> {


    public Category() {
        super();
    }

    public Category(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colCategoryId()).primaryKey().size(8),
                new TableColumn(colName()).size(25),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public Column<Category, Integer, CategoryId> colID() {
        return colCategoryId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PrimaryKey<?, ?, ?> other = (PrimaryKey<?, ?, ?>) obj;
        return Objects.equals(getId(), other.getId());
    }


}
