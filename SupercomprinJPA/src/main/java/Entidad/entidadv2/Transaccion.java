/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad.entidadv2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findById", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.id = :id"),
    @NamedQuery(name = "Transaccion.findByFechaHora", query = "SELECT t FROM Transaccion t WHERE t.fechaHora = :fechaHora"),
    @NamedQuery(name = "Transaccion.findByMovimiento", query = "SELECT t FROM Transaccion t WHERE t.movimiento = :movimiento"),
    @NamedQuery(name = "Transaccion.findByNumerocuenta", query = "SELECT t FROM Transaccion t WHERE t.numerocuenta = :numerocuenta"),
    @NamedQuery(name = "Transaccion.findByCuentacorrienteNumerocuenta", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.cuentacorrienteNumerocuenta = :cuentacorrienteNumerocuenta")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionPK transaccionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Movimiento")
    private double movimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numerocuenta")
    private int numerocuenta;
    @JoinColumn(name = "cuentacorriente_Numerocuenta", referencedColumnName = "Numerocuenta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuentacorriente cuentacorriente;

    public Transaccion() {
    }

    public Transaccion(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Transaccion(TransaccionPK transaccionPK, Date fechaHora, double movimiento, int numerocuenta) {
        this.transaccionPK = transaccionPK;
        this.fechaHora = fechaHora;
        this.movimiento = movimiento;
        this.numerocuenta = numerocuenta;
    }

    public Transaccion(int id, int cuentacorrienteNumerocuenta) {
        this.transaccionPK = new TransaccionPK(id, cuentacorrienteNumerocuenta);
    }

    public TransaccionPK getTransaccionPK() {
        return transaccionPK;
    }

    public void setTransaccionPK(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(double movimiento) {
        this.movimiento = movimiento;
    }

    public int getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public Cuentacorriente getCuentacorriente() {
        return cuentacorriente;
    }

    public void setCuentacorriente(Cuentacorriente cuentacorriente) {
        this.cuentacorriente = cuentacorriente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionPK != null ? transaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.transaccionPK == null && other.transaccionPK != null) || (this.transaccionPK != null && !this.transaccionPK.equals(other.transaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.entidadv2.Transaccion[ transaccionPK=" + transaccionPK + " ]";
    }
    
}
