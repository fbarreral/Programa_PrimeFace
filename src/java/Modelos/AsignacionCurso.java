/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FERNANDO BARRERA
 */
@Entity
@Table(name = "asignacion_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionCurso.findAll", query = "SELECT a FROM AsignacionCurso a")
    , @NamedQuery(name = "AsignacionCurso.findByIdasignacionCurso", query = "SELECT a FROM AsignacionCurso a WHERE a.idasignacionCurso = :idasignacionCurso")})
public class AsignacionCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idasignacion_curso")
    private Integer idasignacionCurso;
    @JoinColumn(name = "curso_codigo_curso", referencedColumnName = "codigo_curso")
    @ManyToOne(optional = false)
    private Curso cursoCodigoCurso;
    @JoinColumn(name = "inscripcion_idinscripcion", referencedColumnName = "idinscripcion")
    @ManyToOne(optional = false)
    private Inscripcion inscripcionIdinscripcion;

    public AsignacionCurso() {
    }

    public AsignacionCurso(Integer idasignacionCurso) {
        this.idasignacionCurso = idasignacionCurso;
    }

    public Integer getIdasignacionCurso() {
        return idasignacionCurso;
    }

    public void setIdasignacionCurso(Integer idasignacionCurso) {
        this.idasignacionCurso = idasignacionCurso;
    }

    public Curso getCursoCodigoCurso() {
        return cursoCodigoCurso;
    }

    public void setCursoCodigoCurso(Curso cursoCodigoCurso) {
        this.cursoCodigoCurso = cursoCodigoCurso;
    }

    public Inscripcion getInscripcionIdinscripcion() {
        return inscripcionIdinscripcion;
    }

    public void setInscripcionIdinscripcion(Inscripcion inscripcionIdinscripcion) {
        this.inscripcionIdinscripcion = inscripcionIdinscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignacionCurso != null ? idasignacionCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionCurso)) {
            return false;
        }
        AsignacionCurso other = (AsignacionCurso) object;
        if ((this.idasignacionCurso == null && other.idasignacionCurso != null) || (this.idasignacionCurso != null && !this.idasignacionCurso.equals(other.idasignacionCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.AsignacionCurso[ idasignacionCurso=" + idasignacionCurso + " ]";
    }
    
}
