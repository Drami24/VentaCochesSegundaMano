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
@Table(name = "talleres")
@XmlRootElement
public class Taller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTALLER")
    private int idtaller;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taller", fetch = FetchType.LAZY)
    private Set<Reparacion> reparacionSet;

    public Taller() {
    }

    public Taller(Integer idtaller) {
        this.idtaller = idtaller;
    }

    public Taller(String nombre) {
        
        this.nombre = nombre;
    }

    public int getIdtaller() {
        return idtaller;
    }

    public void setIdtaller(int idtaller) {
        this.idtaller = idtaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Set<Reparacion> getReparacionSet() {
        return reparacionSet;
    }

    public void setReparacionSet(Set<Reparacion> reparacionSet) {
        this.reparacionSet = reparacionSet;
    }

   

    
   

    @Override
    public String toString() {
        return "mapeos.Taller[ idtaller=" + idtaller + " ]";
    }
    
}
