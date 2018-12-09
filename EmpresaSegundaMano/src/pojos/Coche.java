
package pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16jorgemf
 */
public class Coche {

    private int idCoche;
    private String marca;
    private String modelo;
    private String matricula;

    private enum tipo {
        TURISMO, INDUSTRIAL, TODOTERRENO
    }
    private double precioCompra;
    private double precioVenta;
    private boolean reparado;
    private Date fechaAlta;
    private Date fechaVenta;
    private Proveedor proveedor;
    private Exposicion exposicion;
    private Vendedor vendedor;
    private Cliente cliente;
    private Set<Reparacion> reparaciones;

    public Coche(String marca, String modelo, String matricula, double precioCompra, double precioVenta, boolean reparado, Date fechaAlta, Date fechaVenta, Proveedor proveedor, Exposicion exposicion, Vendedor vendedor, Cliente cliente) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.reparado = reparado;
        this.fechaAlta = fechaAlta;
        this.fechaVenta = fechaVenta;
        this.proveedor = proveedor;
        this.exposicion = exposicion;
        this.vendedor = vendedor;
        this.cliente = cliente;
        reparaciones = new HashSet(0);
    }

    public Coche() {
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public boolean isReparado() {
        return reparado;
    }

    public void setReparado(boolean reparado) {
        this.reparado = reparado;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Exposicion getExposicion() {
        return exposicion;
    }

    public void setExposicion(Exposicion exposicion) {
        this.exposicion = exposicion;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
