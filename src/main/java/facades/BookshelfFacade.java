package facades;

import dtos.RenameMeDTO;
import entities.Bookshelf;
import entities.RenameMe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
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

    public Bookshelf addBookshelf(String user_name, String title, String author, String description) {
        EntityManager em = emf.createEntityManager();
        Bookshelf bookshelf = new Bookshelf(user_name, title, author, description);
        em.getTransaction().begin();
        em.persist(bookshelf);
        em.getTransaction().commit();
        em.close();


        return bookshelf;
    }

    /*
    public Bookshelf checkBook(String title, String user_name){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Bookshelf> query = em.createQuery("SELECT r FROM bookshelf r WHERE user_name = ? AND title = ?", Bookshelf.class);
        PreparedStatement ps = emf.prepareStatement();
        List<Bookshelf> rms = query.getResultList();
        return RenameMeDTO.getDtos(rms);
    }*/

}