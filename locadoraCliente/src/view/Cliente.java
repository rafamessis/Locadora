/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "cliente", catalog = "locadorafilme", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM Cliente c WHERE c.nomeCliente = :nomeCliente")
    , @NamedQuery(name = "Cliente.findByCpfCliente", query = "SELECT c FROM Cliente c WHERE c.cpfCliente = :cpfCliente")
    , @NamedQuery(name = "Cliente.findByTelefoneCliente", query = "SELECT c FROM Cliente c WHERE c.telefoneCliente = :telefoneCliente")
    , @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente")
    , @NamedQuery(name = "Cliente.findByEnderecoCliente", query = "SELECT c FROM Cliente c WHERE c.enderecoCliente = :enderecoCliente")
    , @NamedQuery(name = "Cliente.findByNumeroCliente", query = "SELECT c FROM Cliente c WHERE c.numeroCliente = :numeroCliente")
    , @NamedQuery(name = "Cliente.findByBairroCliente", query = "SELECT c FROM Cliente c WHERE c.bairroCliente = :bairroCliente")})
public class Cliente implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "nomeCliente")
    private String nomeCliente;
    @Basic(optional = false)
    @Column(name = "cpfCliente")
    private int cpfCliente;
    @Basic(optional = false)
    @Column(name = "telefoneCliente")
    private String telefoneCliente;
    @Basic(optional = false)
    @Column(name = "e-mailCliente")
    private String emailCliente;
    @Basic(optional = false)
    @Column(name = "enderecoCliente")
    private String enderecoCliente;
    @Basic(optional = false)
    @Column(name = "numeroCliente")
    private String numeroCliente;
    @Basic(optional = false)
    @Column(name = "bairroCliente")
    private String bairroCliente;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nomeCliente, int cpfCliente, String telefoneCliente, String emailCliente, String enderecoCliente, String numeroCliente, String bairroCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.enderecoCliente = enderecoCliente;
        this.numeroCliente = numeroCliente;
        this.bairroCliente = bairroCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        Integer oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        String oldNomeCliente = this.nomeCliente;
        this.nomeCliente = nomeCliente;
        changeSupport.firePropertyChange("nomeCliente", oldNomeCliente, nomeCliente);
    }

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        int oldCpfCliente = this.cpfCliente;
        this.cpfCliente = cpfCliente;
        changeSupport.firePropertyChange("cpfCliente", oldCpfCliente, cpfCliente);
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        String oldTelefoneCliente = this.telefoneCliente;
        this.telefoneCliente = telefoneCliente;
        changeSupport.firePropertyChange("telefoneCliente", oldTelefoneCliente, telefoneCliente);
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        String oldEmailCliente = this.emailCliente;
        this.emailCliente = emailCliente;
        changeSupport.firePropertyChange("emailCliente", oldEmailCliente, emailCliente);
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        String oldEnderecoCliente = this.enderecoCliente;
        this.enderecoCliente = enderecoCliente;
        changeSupport.firePropertyChange("enderecoCliente", oldEnderecoCliente, enderecoCliente);
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        String oldNumeroCliente = this.numeroCliente;
        this.numeroCliente = numeroCliente;
        changeSupport.firePropertyChange("numeroCliente", oldNumeroCliente, numeroCliente);
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        String oldBairroCliente = this.bairroCliente;
        this.bairroCliente = bairroCliente;
        changeSupport.firePropertyChange("bairroCliente", oldBairroCliente, bairroCliente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Cliente[ idCliente=" + idCliente + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
