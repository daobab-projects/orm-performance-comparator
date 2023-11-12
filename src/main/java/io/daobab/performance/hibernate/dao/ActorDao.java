package io.daobab.performance.hibernate.dao;

import io.daobab.performance.hibernate.entity.Actor;
import org.springframework.stereotype.Repository;


@Repository
public class ActorDao extends AbstractDao<Actor> {


    protected ActorDao() {
        super(Actor.class);
    }
}
