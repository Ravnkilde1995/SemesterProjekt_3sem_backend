package facades;

import entities.Book;
import entities.Bookshelf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oliver
 */
public class BookshelfFacade {

    private static EntityManagerFactory emf;
    private static BookshelfFacade instance;

    private BookshelfFacade() {
    }

    /**
     * @param _emf
     * @return the instance of this facade.
     */
    public static BookshelfFacade getBookshelfFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookshelfFacade();
        }
        return instance;
    }

    public List<Bookshelf> getByUsername(String user_name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Bookshelf> query = em.createQuery("SELECT b FROM Bookshelf b where b.user_name = :user_name", Bookshelf.class);
        query.setParameter("user_name", user_name);
        List<Bookshelf> bookshelves = query.getResultList();

        return bookshelves;
    }

    public Bookshelf addBookshelf(String user_name, String title, String author, String description) {
        EntityManager em = emf.createEntityManager();
        Bookshelf bookshelf = new Bookshelf(user_name, title, author, description);
        em.getTransaction().begin();
        em.persist(bookshelf);
        em.getTransaction().commit();
        em.close();


        return bookshelf;
    }

}