package net.spring.coding.sesstion;

import net.spring.coding.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/* This class manages hibernate session. */
public class HibernateSesstion {

    private static SessionFactory sessionFactory = null;

    public HibernateSesstion () {

        loadSesstionFactory();
        /* when this class is working loadSesstionFactory() method is working too.*/

    }
    public static void loadSesstionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-config/hibernate.cfg.xml"); /* load file xml */
        configuration.addAnnotatedClass(Employee.class); /* load class */
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public static Session getSesstion() throws HibernateException {

        Session session = null;

            try {

                session = sessionFactory.openSession(); /** getting session object from session factory*/

            }   catch (Throwable mess) {

                System.out.println("Exception while getting session.. " +mess);

            }
            if (session == null) {

                System.err.println("session is discovered null");

            }
            return session;
    } /* end getSesstion() */
}
