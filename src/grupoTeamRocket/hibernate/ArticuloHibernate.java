package grupoTeamRocket.hibernate;
import javax.persistence.*;


@Entity
@Table(name="articulo")
public class ArticuloHibernate {


    @Id
    @Column(name="id_articulo")
    private String idArticulo;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="precio")
    private float precio;
    @Column(name="gastos_envio")
    private float gastosEnvio;
    @Column(name="tiempo_preparacion")
    private int tiempoPreparacion;
    
    public ArticuloHibernate(String idArticulo, String descripcion, float precio, float gastosEnvio, int tiempoPreparacion){
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastosEnvio = gastosEnvio;        
    }


    public ArticuloHibernate (){
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(float gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "idArticulo='" + idArticulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", gastosEnvio=" + gastosEnvio +
                ", tiempoPreparacion=" + tiempoPreparacion +
                '}';
    }

    
}
