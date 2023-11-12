package io.daobab.performance.jpa.repository;

import io.daobab.performance.hibernate.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorJpaService extends JpaRepository<Actor, Integer> {

    @Query("select a from Actor a where a.id=:id")
    Actor findActorById(@Param("id") int id);

}
