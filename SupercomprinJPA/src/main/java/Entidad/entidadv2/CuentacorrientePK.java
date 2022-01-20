/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad.entidadv2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Embeddable
public class CuentacorrientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Numerocuenta")
    private int numerocuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cliente_Dni")
    private String clienteDni;

    public CuentacorrientePK() {
    }

    public CuentacorrientePK(int numerocuenta, String clienteDni) {
        this.numerocuenta = numerocuenta;
        this.clienteDni = clienteDni;
    }

    public int getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numerocuenta;
        hash += (clienteDni != null ? clienteDni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentacorrientePK)) {
            return false;
        }
        CuentacorrientePK other = (CuentacorrientePK) object;
        if (this.numerocuenta != other.numerocuenta) {
            return false;
        }
        if ((this.clienteDni == null && other.clienteDni != null) || (this.clienteDni != null && !this.clienteDni.equals(other.clienteDni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.entidadv2.CuentacorrientePK[ numerocuenta=" + numerocuenta + ", clienteDni=" + clienteDni + " ]";
    }
    
}
