/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a16jorgemf
 */
@MappedSuperclass
@Table(name = "reparaciones")
@XmlRootElement
public class Reparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDREPARACION")
    private Integer idreparacion;
    @Basic(optional = false)
    @Column(name = "FECHAREPARACION")
    @Temporal(TemporalType.DATE)
    private Date fechareparacion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reparacion", fetch = FetchType.EAGER)
    private ReparacionChapa reparacionChapa;
    @JoinColumn(name = "TALLER", referencedColumnName = "IDTALLER")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Taller taller;
    @JoinColumn(name = "COCHE", referencedColumnName = "IDCOCHE")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Coche coche;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reparacion", fetch = FetchType.EAGER)
    private ReparacionMecanica reparacionMecanica;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reparacion", fetch = FetchType.EAGER)
    private ReparacionElectrica reparacionElectrica;

    public Reparacion() {
    }

    public Reparacion(Integer idreparacion) {
        this.idreparacion = idreparacion;
    }

    public Reparacion(Integer idreparacion, Date fechareparacion) {
        this.idreparacion = idreparacion;
        this.fechareparacion = fechareparacion;
    }

    public Integer getIdreparacion() {
        return idreparacion;
    }

    public void setIdreparacion(Integer idreparacion) {
        this.idreparacion = idreparacion;
    }

    public Date getFechareparacion() {
        return fechareparacion;
    }

    public void setFechareparacion(Date fechareparacion) {
        this.fechareparacion = fechareparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ReparacionChapa getReparacionChapa() {
        return reparacionChapa;
    }

    public void setReparacionChapa(ReparacionChapa reparacionChapa) {
        this.reparacionChapa = reparacionChapa;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public ReparacionMecanica getReparacionMecanica() {
        return reparacionMecanica;
    }

    public void setReparacionMecanica(ReparacionMecanica reparacionMecanica) {
        this.reparacionMecanica = reparacionMecanica;
    }

    public ReparacionElectrica getReparacionElectrica() {
        return reparacionElectrica;
    }

    public void setReparacionElectrica(ReparacionElectrica reparacionElectrica) {
        this.reparacionElectrica = reparacionElectrica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreparacion != null ? idreparacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparacion)) {
            return false;
        }
        Reparacion other = (Reparacion) object;
        if ((this.idreparacion == null && other.idreparacion != null) || (this.idreparacion != null && !this.idreparacion.equals(other.idreparacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeos.Reparacion[ idreparacion=" + idreparacion + " ]";
    }
    
}
