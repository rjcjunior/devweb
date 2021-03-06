/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Ricardo Junior
 */
@Entity
@Table(name = "ESPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esporte.findAll", query = "SELECT e FROM Esporte e")
    , @NamedQuery(name = "Esporte.findById", query = "SELECT e FROM Esporte e WHERE e.id = :id")
    , @NamedQuery(name = "Esporte.findByNome", query = "SELECT e FROM Esporte e WHERE e.nome = :nome")})
public class Esporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 15)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esporte")
    private List<Hospedagemesporte> hospedagemesporteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esporteFk")
    private List<Saida> saidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esporteFk")
    private List<Usuario> usuarioList;

    public Esporte() {
    }

    public Esporte(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Hospedagemesporte> getHospedagemesporteList() {
        return hospedagemesporteList;
    }

    public void setHospedagemesporteList(List<Hospedagemesporte> hospedagemesporteList) {
        this.hospedagemesporteList = hospedagemesporteList;
    }

    @XmlTransient
    public List<Saida> getSaidaList() {
        return saidaList;
    }

    public void setSaidaList(List<Saida> saidaList) {
        this.saidaList = saidaList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esporte)) {
            return false;
        }
        Esporte other = (Esporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Esporte[ id=" + id + " ]";
    }
    
}
