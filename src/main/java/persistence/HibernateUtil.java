package persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
/* Create the SessionFactory from standard (hibernate.cfg.xml) config file. */

            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}