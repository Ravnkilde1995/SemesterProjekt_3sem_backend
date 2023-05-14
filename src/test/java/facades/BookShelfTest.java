package facades;

import entities.Bookshelf;
import entities.RenameMe;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookShelfTest {

    //TODO:
    // IMPLIMENT REST ASSUSRE TESTING
    // CREATE A NEW PIPELINE ON GITHUB ACTIONS WITH THESE TESTS
    // Uncomment the line below, to temporarily disable this test
    // @Disabled

    private static EntityManagerFactory emf;
    private static BookshelfFacade facade;

    public BookShelfTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = BookshelfFacade.getBookshelfFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Bookshelf.deleteAllRows").executeUpdate();
            //em.persist(new Bookshelf("user_name", "title", "author", "description", "google_id"));
            em.persist(new Bookshelf("oleTest", "Ole's bog", "Ole er forfatter", "Dette er en test", "test"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method
    @Test
    public void testAFacadeMethod() throws Exception {
        assertEquals(1, facade.getByUsername("oleTest"), "EXPECTS METHOD TO RETURN A BOOKSHELF OBJECT BY USERNAME");
    }



    //TODO: IMPLIMENT UNIT-TESTING BELOW..

    @Test
    public void testListBookshelf () {

        List<Bookshelf> actual = Arrays.asList();
        List<Bookshelf> expected = Arrays.asList();
    }

}

