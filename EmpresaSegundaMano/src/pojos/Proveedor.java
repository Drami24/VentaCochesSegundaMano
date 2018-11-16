
package pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16jorgemf
 */
public class Proveedor {

    private int idProveedor;
    private String nombre;
    private Date fechaAlta;
    private Set<Coche> coches;

    public Proveedor(String nombre, Date fechaAlta) {
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        coches = new HashSet(0);
    }

    public Proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Set<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Set<Coche> coches) {
        this.coches = coches;
    }

    public void añadirCoche(Coche coche) {
        coches.add(coche);
    }

}
