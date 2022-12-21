package grupoTeamRocket.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class GuardarArticuloPrueba {

    public static void main(String[] args){

        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ArticuloHibernate.class).buildSessionFactory();

        Session miSession=miFactory.openSession();

        try {

            ArticuloHibernate articuloHibernate1 = new ArticuloHibernate("id3", "3", 3, 3, 3);
            miSession.beginTransaction();
            miSession.save(articuloHibernate1);
            miSession.getTransaction().commit();
            System.out.println("Registro en BBDD");
            miSession.close();

        }finally {
            miFactory.close();
        }


    }
}
