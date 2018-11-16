package pojos;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16jorgemf
 */
public class Exposicion {

    private int idExposicion;
    private String nombre;
    private String lugar;
    private Set<Coche> coches;

    public Exposicion(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
        coches = new HashSet(0);
    }

    public Exposicion() {
    }

    public int getIdExposicion() {
        return idExposicion;
    }

    public void setIdExposicion(int idExposicion) {
        this.idExposicion = idExposicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
