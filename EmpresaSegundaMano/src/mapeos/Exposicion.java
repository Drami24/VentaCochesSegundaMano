/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeos;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a16jorgemf
 */
@MappedSuperclass
@Table(name = "exposiciones")
@XmlRootElement
public class Exposicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEXPOSICION")
    private Integer idexposicion;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "LUGAR")
    private String lugar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exposicion", fetch = FetchType.LAZY)
    private Set<Coche> cocheSet;

    public Exposicion() {
    }

    public Exposicion(Integer idexposicion) {
        this.idexposicion = idexposicion;
    }

    public Exposicion( String nombre, String lugar) {
       
        this.nombre = nombre;
        this.lugar = lugar;
    }

    public Integer getIdexposicion() {
        return idexposicion;
    }

    public void setIdexposicion(Integer idexposicion) {
        this.idexposicion = idexposicion;
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
        hash += (idexposicion != null ? idexposicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exposicion)) {
            return false;
        }
        Exposicion other = (Exposicion) object;
        if ((this.idexposicion == null && other.idexposicion != null) || (this.idexposicion != null && !this.idexposicion.equals(other.idexposicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeos.Exposicion[ idexposicion=" + idexposicion + " ]";
    }
    
}
