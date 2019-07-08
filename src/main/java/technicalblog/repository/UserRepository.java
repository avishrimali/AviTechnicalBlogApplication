package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.User;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;

    public void registerUser(User newUser) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newUser);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public User checkUser(String username, String password) {

        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
//            u.username refers to the username in the User table and ':username' refers to the username entered on the UI. Similarly, u.password refers
//            to the password in the User table and ':password' refers to the password entered on the UI.
            typedQuery.setParameter("username", username);
            typedQuery.setParameter("password", password);

            return typedQuery.getSingleResult();
//            Suppose there exist two users in the database with the same username and password. What will the method given above return when the code is executed?
//            The code throws NonUniqueResultException. The getSingleResult() method is designed to retrieve a single result.
//            If there are multiple rows, the getSingleResult() throws NonUniqueResultException.
        }catch(NoResultException nre) {
            return null;
        }
    }

//    What is a dynamic query, and when do we use it?
//    Dynamic query is a query created at runtime by the application and is defined directly within the application’s code. We use a dynamic query when
//    the structure of the query is dependent on user inputs.
//    Here, the structure of the query depends on the username and password entered by the user on the UI. Therefore, we are defining a
//    JPQL query directly within the application’s business logic, and we will use
//    the createQuery() method of the EntityManager class to create a dynamic JPQL query.

}