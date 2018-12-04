/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a16jorgemf
 */
@MappedSuperclass
@Table(name = "coches")
@XmlRootElement
public class Coche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOCHE")
    private Integer idcoche;
    @Basic(optional = false)
    @Column(name = "MARCA")
    private String marca;
    @Basic(optional = false)
    @Column(name = "MODELO")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "MATRICULA")
    private String matricula;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "PRECIOCOMPRA")
    private double preciocompra;
    @Basic(optional = false)
    @Column(name = "PRECIOVENTA")
    private double precioventa;
    @Basic(optional = false)
    @Column(name = "REPARADO")
    private boolean reparado;
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaalta;
    @Column(name = "FECHAVENTA")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
    @JoinColumn(name = "PROVEEDOR", referencedColumnName = "IDPROVEEDOR")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor proveedor;
    @JoinColumn(name = "EXPOSICION", referencedColumnName = "IDEXPOSICION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Exposicion exposicion;
    @JoinColumn(name = "CLIENTE", referencedColumnName = "DNI")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "VENDEDOR", referencedColumnName = "DNI")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vendedor vendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coche", fetch = FetchType.LAZY)
    private Set<Reparacion> reparacionSet;

    public Coche() {
    }

    public Coche(Integer idcoche) {
        this.idcoche = idcoche;
    }

    public Coche(Integer idcoche, String marca, String modelo, String matricula, String tipo, double preciocompra, double precioventa, boolean reparado) {
        this.idcoche = idcoche;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.tipo = tipo;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
        this.reparado = reparado;
    }

    public Integer getIdcoche() {
        return idcoche;
    }

    public void setIdcoche(Integer idcoche) {
        this.idcoche = idcoche;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public boolean getReparado() {
        return reparado;
    }

    public void setReparado(boolean reparado) {
        this.reparado = reparado;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @XmlTransient
    public Set<Reparacion> getReparacionSet() {
        return reparacionSet;
    }

    public void setReparacionSet(Set<Reparacion> reparacionSet) {
        this.reparacionSet = reparacionSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcoche != null ? idcoche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coche)) {
            return false;
        }
        Coche other = (Coche) object;
        if ((this.idcoche == null && other.idcoche != null) || (this.idcoche != null && !this.idcoche.equals(other.idcoche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeos.Coche[ idcoche=" + idcoche + " ]";
    }
    
}
