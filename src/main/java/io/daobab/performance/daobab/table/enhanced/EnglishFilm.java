package io.daobab.performance.daobab.table.enhanced;

import io.daobab.model.EnhancedEntity;
import io.daobab.model.TableInformation;
import io.daobab.performance.daobab.table.Film;
import io.daobab.performance.daobab.table.Language;
import io.daobab.query.base.Query;
import io.daobab.query.base.QueryJoin;

import java.util.Map;

import static io.daobab.performance.daobab.Lang.English;

@TableInformation(name = "FILM")
public class EnglishFilm extends Film implements EnhancedEntity {

    private static final Language tabLanguage = new Language();

    public EnglishFilm() {
        super();
    }

    public EnglishFilm(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public <Q extends Query & QueryJoin<Q>> Q enhanceQuery(Q query) {
        return query.join(tabLanguage, colLanguageId(), and().equal(tabLanguage.colName(), English));
    }

}
