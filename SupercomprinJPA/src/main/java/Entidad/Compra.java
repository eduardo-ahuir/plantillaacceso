package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Maria Angeles
 */
@Entity
@Table(name = "compra")

public class Compra implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;
    private String fecha;
    private float importeTotalEuros;
    private int importeTotalPuntos;
    private String dniCompra;
//Relacion bidireccional muchos a 1
 /*   @ManyToOne
    @JoinColumn(name = "dniCompra")
    private Ewallet walletC;*/

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public Compra() {
    }

    ;
    
    public Compra(int idCompra, String fecha, float importeTotalEuros, int importeTotalPuntos, String dniCompra) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.importeTotalEuros = importeTotalEuros;
        this.importeTotalPuntos = importeTotalPuntos;
        this.dniCompra = dniCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", fecha=" + fecha + ", importeTotalEuros=" + importeTotalEuros + ", importeTotalPuntos=" + importeTotalPuntos + ", dniCompra=" + dniCompra + '}';
    }
}
