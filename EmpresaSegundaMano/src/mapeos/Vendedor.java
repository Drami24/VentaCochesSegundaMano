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
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "vendedores")
@XmlRootElement
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Basic(optional = false)
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Basic(optional = false)
    @Column(name = "MOVIL")
    private String movil;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaalta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vendedor", fetch = FetchType.EAGER)
    private VendedorComision vendedorComision;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vendedor", fetch = FetchType.EAGER)
    private VendedorAsalariados vendedorAsalariados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor", fetch = FetchType.EAGER)
    private Set<Coche> cocheSet;

    public Vendedor() {
    }

    public Vendedor(String dni) {
        this.dni = dni;
    }

    public Vendedor(String dni, String nombre, String apellido1, String apellido2, String movil, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.movil = movil;
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public VendedorComision getVendedorComision() {
        return vendedorComision;
    }

    public void setVendedorComision(VendedorComision vendedorComision) {
        this.vendedorComision = vendedorComision;
    }

    public VendedorAsalariados getVendedorAsalariados() {
        return vendedorAsalariados;
    }

    public void setVendedorAsalariados(VendedorAsalariados vendedorAsalariados) {
        this.vendedorAsalariados = vendedorAsalariados;
    }

    @XmlTransient
    public Set<Coche> getCocheSet() {
        return cocheSet;
    }

    public void setCocheSet(Set<Coche> cocheSet) {
        this.cocheSet = cocheSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeos.Vendedor[ dni=" + dni + " ]";
    }
    
}
