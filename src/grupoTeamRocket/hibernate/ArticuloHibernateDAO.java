package grupoTeamRocket.hibernate;

import grupoTeamRocket.modelo.Articulo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ArticuloHibernateDAO {
    private Session sesion;
    private Transaction tx;

    private void iniciarOperacion() throws HibernateException{
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaException(HibernateException he) throws HibernateException{
        tx.rollback();
        throw new HibernateException("Ha ocurrido un error en la capa de acceso a datos", he);
    }

    public String guardarArticulo(Articulo articulo){
        String id = "";
        try{
            iniciarOperacion();
            id = (String)sesion.save(articulo);
            tx.commit();
        }catch (HibernateException he){
            manejaException(he);
            throw he;
        }finally{
            //sesion.close();
        }return id;
    }

    public void actualizaArticulo (Articulo articulo) throws HibernateException{
        try{
            iniciarOperacion();
            sesion.update(articulo);
            tx.commit();
        }catch (HibernateException he){
            manejaException(he);
            throw he;
        }finally{
            sesion.close();
        }
    }

    public void eliminaArticulo (Articulo articulo) throws HibernateException{
        try{
            iniciarOperacion();
            sesion.delete(articulo);
            tx.commit();
        }catch (HibernateException he){
            manejaException(he);
            throw he;
        }finally{
            sesion.close();
        }
    }

    public Articulo obtenerArticulo(String idArticulo) throws HibernateException{
        Articulo articulo = null;

        try{
            iniciarOperacion();
            articulo = (Articulo) sesion.get(Articulo.class, idArticulo);
        }finally{
            sesion.close();
        }return articulo;
    }

    public List<Articulo> obtenListaArticulo() throws HibernateException{
        List<Articulo> listaArticulos = null;

        try{
            iniciarOperacion();
            listaArticulos = sesion.createQuery("from Articulo").list();
        }finally {
            sesion.close();
        }
        return listaArticulos;
    }
}

