package grupoTeamRocket.hibernate;

import grupoTeamRocket.modelo.Articulo;

import java.util.List;

public class GuardarArticuloPrueba {

  /*  public static void main(String[] args){

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


    }*/

    public static void main(String[] args){

        ArticuloHibernateDAO articuloHibernateDAO1 = new ArticuloHibernateDAO();
        Articulo articulorecuperado = null;
        String idAEliminar = "";

        //Crear 3 instancias
        Articulo art1 = new Articulo ("art1", "art1", 1, 1, 1);
        Articulo art2 = new Articulo ("art2", "art2", 1, 1, 1);
        Articulo art3 = new Articulo ("art3", "art3", 1, 1, 1);

        //Guardar las instancias, guardar id de art1 para despues
        idAEliminar = articuloHibernateDAO1.guardarArticulo(art1);
        articuloHibernateDAO1.guardarArticulo(art2);
        articuloHibernateDAO1.guardarArticulo(art3);
        System.out.println("Se han guardado los articulos");

        //Modificamos contacto 2 y se actualiza
        //no lo hago, porque no lo necesitamos

        //Recuperar el art1 de la bbdd
        articulorecuperado = articuloHibernateDAO1.obtenerArticulo(idAEliminar);
        System.out.println("Recuperamos a " + articulorecuperado.getIdArticulo());

        //Eliminamos el articuloRecuperado de la bbdd
        articuloHibernateDAO1.eliminaArticulo(articulorecuperado);
        System.out.println("Se ha eliminado");

        //obtener lista
        List<Articulo> listaArticulos = articuloHibernateDAO1.obtenListaArticulo();
        System.out.println("Hay " + listaArticulos.size() + "articulos en la bbdd");
        for(Articulo a : listaArticulos){
            System.out.println("-> " + a.getIdArticulo());
        }

    }
}
