/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "proveedores")
@XmlRootElement
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPROVEEDOR")
    private Integer idproveedor;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaalta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor", fetch = FetchType.LAZY)
    private Set<Coche> cocheSet;

    public Proveedor() {
    }
    
    
    
    public Proveedor(Integer idproveedor){
        this.idproveedor=idproveedor;
    }

    public Proveedor (String nombre, Date fechaalta) {
       
        this.nombre = nombre;
        this.fechaalta = fechaalta;
        cocheSet=new HashSet<>();
    }

    
        
    

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    @XmlTransient
    public Set<Coche> getCocheSet() {
        return cocheSet;
    }

    public void setCocheSet(Set<Coche> cocheSet) {
        this.cocheSet = cocheSet;
    }

    
    

   

    @Override
    public String toString() {
        return "mapeos.Proveedor[ idproveedor=" + idproveedor + " ]";
    }
    
}
