package facades;

import entities.Review;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import security.errorhandling.AuthenticationException;

/**
 * @author Christoffer
 */
public class ReviewFacade {

    private static EntityManagerFactory emf;
    private static ReviewFacade instance;

    private ReviewFacade() {
    }

    /**
     * @param _emf
     * @return the instance of this facade.
     */
    public static ReviewFacade getReviewFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ReviewFacade();
        }
        return instance;
    }

    public Review addReview(int bookshelf_id, int review_score, String review_text) {
        EntityManager em = emf.createEntityManager();
        Review review = new Review(bookshelf_id, review_score, review_text);
        em.getTransaction().begin();
        em.persist(review);
        em.getTransaction().commit();
        em.close();

        return review;
    }

public Review editReview(int review_id, int bookshelf_id, int review_score, String review_text) {
        EntityManager em = emf.createEntityManager();
        Review review = em.find(Review.class, review_id);
        review.setBookshelf_id(bookshelf_id);
        review.setReview_score(review_score);
        review.setReview_text(review_text);
        em.getTransaction().begin();
        em.merge(review);
        em.getTransaction().commit();
        em.close();

        return review;
    }

    public Review deleteReview(int review_id) {
        EntityManager em = emf.createEntityManager();
        Review review = em.find(Review.class, review_id);
        em.getTransaction().begin();
        em.remove(review);
        em.getTransaction().commit();
        em.close();

        return review;
    }

    public Review getReview(int review_id) {
        EntityManager em = emf.createEntityManager();
        Review review = em.find(Review.class, review_id);
        em.close();

        return review;
    }

    public Review getReviewByBookshelfId(int bookshelf_id) {
        EntityManager em = emf.createEntityManager();
        Review review = em.find(Review.class, bookshelf_id);
        em.close();

        return review;
    }

    public Review getReviewByReviewScore(int review_score) {
        EntityManager em = emf.createEntityManager();
        Review review = em.find(Review.class, review_score);
        em.close();

        return review;
    }

    public Review getReviewByReviewText(String review_text) {
        EntityManager em = emf.createEntityManager();
        Review review = em.find(Review.class, review_text);
        em.close();

        return review;
    }




}
