package persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static String postgres = "hibernate.postgres";
    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(postgres);
        }
        catch (Throwable th) {
            System.err.println("Initial EntityManagerFactory creation failed"
                    + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }


}
