package com.dao.impl;

import com.model.Profile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class AbstractDaoImpl<T>{

    @Autowired
    SessionFactory sessionFactory;

    protected abstract String getClassName();

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    protected void persist(T entity){
        Session session = this.getSession();
        session.persist(entity);
        session.flush();
    }

    protected List<T> getAll(){
        Session session = getSession();
        Query query = session.createQuery("from " + this.getClassName());
        List<T> objects = query.list();
        return objects;
    }
}
