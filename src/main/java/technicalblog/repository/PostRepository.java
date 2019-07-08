package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;
import technicalblog.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;

    public List<Post> getAllPosts(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post p", Post.class);//JPQL equivalent to sql for JPA
        List<Post> resultList = query.getResultList();
        return resultList;
    }

    public Post getLatestPost() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Post.class, 3);
    }

    public Post createPost(Post newPost){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newPost);// at this stage id will be generated for the post object.
//            An entity in transient state is just created and has no primary key (identifier) value,
//            but when the entity comes in persistent state, the primary key value is generated (identifier).
//            Hence, an entity in persistent state has an identifier value.
            transaction.commit();
//            Whenever a query is performed on a table, it is better to start a transaction to make it explicit. This will result
//            in a lock on the table on which the query is performed so that there is no concurrent query performed on that table.
//            This can, in turn, change the content of that table and disturb the current transaction.
//            The lock is lifted only after the transaction is committed or rolled back.This property of either completing something successfully
//            or going back to its initial state, if not successful, is called atomicity. So, the atomicity of a transaction is also maintained.

        } catch (Exception e){
            transaction.rollback();
        }
        return newPost;
    }

    public Post getPost(Integer postId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       return entityManager.find(Post.class, postId);
    }

    public void updatePost(Post updatedPost) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(updatedPost);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

//    The persist() method changes the state of the entity object from transient to persistent,
//    and is used to save the new entries in the database. On the other hand, the merge() method changes
//    the state of the entity object from detached to persistent, and is used to update the existing records in the database.

    public void deletePost(Integer postId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Post post = em.find(Post.class, postId);
            em.remove(post);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

//    If the delete is implemented using post title:
//    public void deletePost(String postTitle) {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//
//        try {
//            transaction.begin();
//            TypedQuery<Post> query = createQuery("SELECT p FROM Post p WHERE title =:title",Post.class);
//            query.setParameter("title",postTitle);
//            Post post = query.getSingleResult();
//            em.remove(post);
//            transaction.commit();
//        }catch(Exception e) {
//            transaction.rollback();
//        }
//    }
}
