package com.asek.spring.app.dao;

import com.asek.spring.app.model.UserModel;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Repository("userDao")
@EnableJpaRepositories
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Map<String, String> findById(long id) {
        TreeMap<String, String > tmap = new TreeMap<>();
        Session session = getSession();
        Transaction transaction = getSession().beginTransaction();
        String output = "";
        UserModel user = session.load(UserModel.class, id);

        tmap.put("ID", String.valueOf(user.getUser_id()));
        tmap.put("fave_colour", user.getFave_colour());

        return tmap;
    }

    @Override
    public void saveUser(UserModel u) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(u);
        transaction.commit();
        session.close();
    }

    @Override
    public void saveOrUpdate(UserModel u) {

    }

    @Override
    public void deleteById(long id) {

    }
}
