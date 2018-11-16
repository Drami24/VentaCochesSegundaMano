package pojos;

import java.util.Date;

/**
 *
 * @author a16jorgemf
 */
public abstract class Reparacion {

    protected int idReparacion;
    protected Date fecha;
    protected String descripcion;
    protected Taller taller;

    public Reparacion(Date fecha, String descripcion, Taller taller) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.taller = taller;
    }

    public Reparacion() {
    }

    public int getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

}
