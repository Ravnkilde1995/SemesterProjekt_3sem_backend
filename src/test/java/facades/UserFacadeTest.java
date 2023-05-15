package facades;

import entities.Bookshelf;
import entities.User;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFacadeTest {

    private static EntityManagerFactory emf;
    private static UserFacade facade;
    User user, admin;
    Bookshelf b1, b2;

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = UserFacade.getUserFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("User.deleteAllRows").executeUpdate();
            user = new User("user", "test");
            admin = new User("admin", "test");
            b1 = new Bookshelf(user.getUserName());
            b2 = new Bookshelf(admin.getUserName());
            em.persist(user);
            em.persist(admin);
            em.persist(b1);
            em.persist(b2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void create(){
        System.out.println("Testing create(User u)");
        User u = new User("TestUser", "TestPass");
        User expected = u;
        User actual = facade.create(u);
        assertEquals(expected, actual);

    }

}