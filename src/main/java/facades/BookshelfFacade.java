package facades;
import entities.Bookshelf;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
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

    public Bookshelf addBookshelf(String user_name, String title, String author, String description, String google_id) {
        EntityManager em = emf.createEntityManager();
        Bookshelf bookshelf = new Bookshelf(user_name, title, author, description, google_id);
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

    /*
    Todo: edit update function if time.
    public HobbyDTO updateHobby(long id,HobbyDTO hdto) {
        EntityManager em = emf.createEntityManager();
        Hobby hobby = em.find(Hobby.class, id);
        System.out.println("updateHobby: " +hobby);
        System.out.println("idIsNotNull: " + id);
        hobby.setName(hdto.getName());
        hobby.setDescription(hdto.getDescription());
        hobby.setCategory(hdto.getCategory());

        try {
            em.getTransaction().begin();
            em.merge(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HobbyDTO(hobby);

    }*/

}