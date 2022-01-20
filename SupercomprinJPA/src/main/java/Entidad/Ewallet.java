
 
package Entidad;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Maria Angeles
 */

 @Entity 
 @Table (name="ewallet")

 public class Ewallet implements Serializable{
    @Id
    private String dniWallet;
    private int saldoPuntos;
    private float saldoEuros;
    
  //Relación 1 a 1 bidiereccional
    @OneToOne
    @JoinColumn(name="dniWallet",nullable=false, updatable=false,insertable=false)
    private Cliente cli;
    
    //Relación 1 a muchos
   /* @OneToMany(mappedBy="dniCompra")
    private Set<Compra> compras;
    
    public Ewallet(){};*/

    public String getDniWallet() {
        return dniWallet;
    }

    public void setDniWallet(String dniWallet) {
        this.dniWallet = dniWallet;
    }

    public int getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(int saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public float getSaldoEuros() {
        return saldoEuros;
    }

    public void setSaldoEuros(float saldoEuros) {
        this.saldoEuros = saldoEuros;
    }

    public Ewallet(String dniWallet, int saldoPuntos, float saldoEuros) {
        this.dniWallet = dniWallet;
        this.saldoPuntos = saldoPuntos;
        this.saldoEuros = saldoEuros;
    }

    public Ewallet() {
        
    }
    @Override
    public String toString() {
        return "Ewallet{" + "dniWallet=" + dniWallet + ", saldoPuntos=" + saldoPuntos + ", saldoEuros=" + saldoEuros + '}';
    }
}
