package com.store.basma.repository;

import com.store.basma.enity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl{
   /* private EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {

        // create a query
        Query theQuery =
                entityManager.createQuery("from User");

        // execute query and get result list
        List<User> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public User findById(long theId) {

        // get employee
        User theUser =
                entityManager.find(User.class, theId);

        // return employee
        return theUser;
    }

    @Override
    public void save(User theUser) {

        // save or update the employee
        User dbUser = entityManager.merge(theUser);

        // update with id from db ... so we can get generated id for save/insert
        theUser.setId(dbUser.getId());

    }

    @Override
    public void deleteById(long theId) {

        // delete object with primary key
        Query theQuery = entityManager.createQuery(
                "delete from User where id=:userId");

        theQuery.setParameter("userId", theId);

        theQuery.executeUpdate();
    }*/
}
