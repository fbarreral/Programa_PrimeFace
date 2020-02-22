/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FERNANDO BARRERA
 */
@Entity
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByNumeroCarne", query = "SELECT a FROM Alumno a WHERE a.numeroCarne = :numeroCarne")
    , @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumno.findByApellido", query = "SELECT a FROM Alumno a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Alumno.findByCorreo", query = "SELECT a FROM Alumno a WHERE a.correo = :correo")
    , @NamedQuery(name = "Alumno.findByTelefonon", query = "SELECT a FROM Alumno a WHERE a.telefonon = :telefonon")
    , @NamedQuery(name = "Alumno.findByDireccion", query = "SELECT a FROM Alumno a WHERE a.direccion = :direccion")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_carne")
    private Integer numeroCarne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Size(max = 15)
    @Column(name = "telefonon")
    private String telefonon;
    @Size(max = 105)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnonumerocarne")
    private Collection<Inscripcion> inscripcionCollection;
    @JoinColumn(name = "genero_idgenero", referencedColumnName = "idgenero")
    @ManyToOne(optional = false)
    private Genero generoIdgenero;

    public Alumno() {
    }

    public Alumno(Integer numeroCarne) {
        this.numeroCarne = numeroCarne;
    }

    public Alumno(Integer numeroCarne, String nombre, String apellido) {
        this.numeroCarne = numeroCarne;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getNumeroCarne() {
        return numeroCarne;
    }

    public void setNumeroCarne(Integer numeroCarne) {
        this.numeroCarne = numeroCarne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefonon() {
        return telefonon;
    }

    public void setTelefonon(String telefonon) {
        this.telefonon = telefonon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(Collection<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    public Genero getGeneroIdgenero() {
        return generoIdgenero;
    }

    public void setGeneroIdgenero(Genero generoIdgenero) {
        this.generoIdgenero = generoIdgenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCarne != null ? numeroCarne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.numeroCarne == null && other.numeroCarne != null) || (this.numeroCarne != null && !this.numeroCarne.equals(other.numeroCarne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Alumno[ numeroCarne=" + numeroCarne + " ]";
    }
    
}
