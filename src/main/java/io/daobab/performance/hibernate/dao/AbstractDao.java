package io.daobab.performance.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class AbstractDao<E> {

    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    protected AbstractDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public List<E> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    @Transactional
    public void add(E movie) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(movie);

    }


    @Transactional
    public void update(E movie) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(movie);

    }


    @Transactional
    public void delete(E movie) {
        Session session = entityManager.unwrap(Session.class);
        E movieToDelete = session.get(entityClass, 1);//movie.getId());
        session.delete(movieToDelete);
    }

    @Transactional
    public E getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(entityClass, id);
    }


}
