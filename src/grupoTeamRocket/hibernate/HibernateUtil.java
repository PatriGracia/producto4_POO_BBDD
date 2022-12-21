package grupoTeamRocket.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException he){
            System.err.println("Ha ocurrido un error en la inicialización de la SessionFActory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
