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

/**
 *
 * @author pc
 */
@Embeddable
public class TransaccionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuentacorriente_Numerocuenta")
    private int cuentacorrienteNumerocuenta;

    public TransaccionPK() {
    }

    public TransaccionPK(int id, int cuentacorrienteNumerocuenta) {
        this.id = id;
        this.cuentacorrienteNumerocuenta = cuentacorrienteNumerocuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuentacorrienteNumerocuenta() {
        return cuentacorrienteNumerocuenta;
    }

    public void setCuentacorrienteNumerocuenta(int cuentacorrienteNumerocuenta) {
        this.cuentacorrienteNumerocuenta = cuentacorrienteNumerocuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) cuentacorrienteNumerocuenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionPK)) {
            return false;
        }
        TransaccionPK other = (TransaccionPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.cuentacorrienteNumerocuenta != other.cuentacorrienteNumerocuenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.entidadv2.TransaccionPK[ id=" + id + ", cuentacorrienteNumerocuenta=" + cuentacorrienteNumerocuenta + " ]";
    }
    
}
