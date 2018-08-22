package com.asek.spring.app.dao;

import com.asek.spring.app.model.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
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
        UserModel user = session.load(UserModel.class, id);

        tmap.put("ID", String.valueOf(user.getUser_id()));
        tmap.put("fave_colour", user.getFave_colour());
        transaction.commit();
        session.close();

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
        Session session = getSession();
        Transaction transaction = getSession().beginTransaction();

        session.saveOrUpdate(u);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteById(long id) {
        Session session = getSession();
        Transaction transaction = getSession().beginTransaction();

        UserModel user = session.load(UserModel.class, id);
        session.delete(user);

        transaction.commit();
        session.close();
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> userList;
        Session session = getSession();

        userList = session.createCriteria(UserModel.class).list();

        return userList;

    }
}
