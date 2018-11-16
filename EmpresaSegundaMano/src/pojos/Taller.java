package pojos;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16jorgemf
 */
public class Taller {

    private int idTaller;
    private String nombre;
    private Set<Reparacion> reparaciones;

    public Taller(String nombre) {
        this.nombre = nombre;
        reparaciones = new HashSet(0);
    }

    public Taller() {
    }

    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(Set<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public void añadirReparacion(Reparacion reparacion) {
        reparaciones.add(reparacion);
    }

}
