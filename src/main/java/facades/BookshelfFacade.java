package facades;

import entities.Bookshelf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author oliver
 */
public class BookshelfFacade {

    private static EntityManagerFactory emf;
    private static BookshelfFacade instance;

    private BookshelfFacade() {
    }

    /**
     *
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

    public Bookshelf addBookshelf(String user_name, String book_id, String title, String author, String description) {
        EntityManager em = emf.createEntityManager();
        Bookshelf bookshelf = new Bookshelf(user_name, book_id, title, author, description);
        em.getTransaction().begin();
        em.persist(bookshelf);
        em.getTransaction().commit();
        em.close();


        return bookshelf;
    }

}