/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad.entidadv2;

import Entidad.Cliente;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author pc
 */
@Entity
@Table(name = "cuentacorriente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentacorriente.findAll", query = "SELECT c FROM Cuentacorriente c"),
    @NamedQuery(name = "Cuentacorriente.findByNumerocuenta", query = "SELECT c FROM Cuentacorriente c WHERE c.cuentacorrientePK.numerocuenta = :numerocuenta"),
    @NamedQuery(name = "Cuentacorriente.findByAlias", query = "SELECT c FROM Cuentacorriente c WHERE c.alias = :alias"),
    @NamedQuery(name = "Cuentacorriente.findBySaldoactual", query = "SELECT c FROM Cuentacorriente c WHERE c.saldoactual = :saldoactual"),
    @NamedQuery(name = "Cuentacorriente.findBySaldoretenido", query = "SELECT c FROM Cuentacorriente c WHERE c.saldoretenido = :saldoretenido"),
    @NamedQuery(name = "Cuentacorriente.findBySaldominimo", query = "SELECT c FROM Cuentacorriente c WHERE c.saldominimo = :saldominimo"),
    @NamedQuery(name = "Cuentacorriente.findByClienteDni", query = "SELECT c FROM Cuentacorriente c WHERE c.cuentacorrientePK.clienteDni = :clienteDni")})
public class Cuentacorriente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuentacorrientePK cuentacorrientePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "Alias")
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Saldoactual")
    private double saldoactual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Saldoretenido")
    private double saldoretenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldominimo")
    private double saldominimo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentacorriente")
    private Collection<Transaccion> transaccionCollection;
    @JoinColumn(name = "cliente_Dni", referencedColumnName = "Dni", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Cuentacorriente() {
    }

    public Cuentacorriente(CuentacorrientePK cuentacorrientePK) {
        this.cuentacorrientePK = cuentacorrientePK;
    }

    public Cuentacorriente(CuentacorrientePK cuentacorrientePK, String alias, double saldoactual, double saldoretenido, double saldominimo) {
        this.cuentacorrientePK = cuentacorrientePK;
        this.alias = alias;
        this.saldoactual = saldoactual;
        this.saldoretenido = saldoretenido;
        this.saldominimo = saldominimo;
    }

    public Cuentacorriente(int numerocuenta, String clienteDni) {
        this.cuentacorrientePK = new CuentacorrientePK(numerocuenta, clienteDni);
    }

    public CuentacorrientePK getCuentacorrientePK() {
        return cuentacorrientePK;
    }

    public void setCuentacorrientePK(CuentacorrientePK cuentacorrientePK) {
        this.cuentacorrientePK = cuentacorrientePK;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getSaldoactual() {
        return saldoactual;
    }

    public void setSaldoactual(double saldoactual) {
        this.saldoactual = saldoactual;
    }

    public double getSaldoretenido() {
        return saldoretenido;
    }

    public void setSaldoretenido(double saldoretenido) {
        this.saldoretenido = saldoretenido;
    }

    public double getSaldominimo() {
        return saldominimo;
    }

    public void setSaldominimo(double saldominimo) {
        this.saldominimo = saldominimo;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentacorrientePK != null ? cuentacorrientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentacorriente)) {
            return false;
        }
        Cuentacorriente other = (Cuentacorriente) object;
        if ((this.cuentacorrientePK == null && other.cuentacorrientePK != null) || (this.cuentacorrientePK != null && !this.cuentacorrientePK.equals(other.cuentacorrientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.entidadv2.Cuentacorriente[ cuentacorrientePK=" + cuentacorrientePK + " ]";
    }
    
}
