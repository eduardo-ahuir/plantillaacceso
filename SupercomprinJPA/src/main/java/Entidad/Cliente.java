
package Entidad;

import Entidad.entidadv2.Clientep;
import Entidad.entidadv2.Cuentacorriente;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maria Angeles
 */
@Entity
@Table(name="cliente")//nombre en la tabla de MySQL
//consultas ejemplo. Ponemos @NamedQueries y dentro cada una de las Queries
@NamedQueries({
    @NamedQuery(name="selectAll",query="SELECT c FROM Cliente c"),
    @NamedQuery(name="selectAllOrderByName",query="SELECT c FROM Cliente c ORDER BY c.nombre"),
    @NamedQuery(name="selectSoloApellidos", query= "SELECT c.apellidos FROM Cliente c  "),
    @NamedQuery(name="selectDadoNombre", query="SELECT c FROM Cliente c WHERE c.nombre=:nombre"),
    @NamedQuery(name="clientesConWallet", query="SELECT c FROM Cliente c  INNER JOIN Ewallet E WHERE c.dniCliente=E.dniWallet"),

})
public class Cliente implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "Dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Interes")
    private String interes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Fechanac")
    private String fechanac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "User")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Pwd")
    private String pwd;
    @JoinColumn(name = "Dni", referencedColumnName = "Dni", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Clientep clientep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Cuentacorriente> cuentacorrienteCollection;

    @Id
    private String dniCliente;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
//Relación 1 a 1
    @OneToOne(targetEntity = Entidad.Ewallet.class)
    @PrimaryKeyJoinColumn(name = "dniCliente")
    private Ewallet ewallet;

    //añadimos también el constructor vacío
    public Cliente() {
    };
    
    //ahora añadimos getters, setters y ToString

    public Cliente(String dniCliente,  String nombre, String apellidos, String fechaNacimiento, Ewallet ewallet) {
        this.dniCliente = dniCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
            }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
 
    
        public void setWallet(Ewallet wallet) {
        this.ewallet = wallet;
    }

    public Ewallet getWallet() {
        return this.ewallet;
    }
    @Override
    public String toString() {
        return "Cliente{" + "dniCliente=" + dniCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    public Cliente(String dni) {
        this.dni = dni;
    }

    public Cliente(String dni, String nombre, String apellidos, String email, String interes, String direccion, String fechanac, String user, String pwd) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.interes = interes;
        this.direccion = direccion;
        this.fechanac = fechanac;
        this.user = user;
        this.pwd = pwd;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Clientep getClientep() {
        return clientep;
    }

    public void setClientep(Clientep clientep) {
        this.clientep = clientep;
    }

    @XmlTransient
    public Collection<Cuentacorriente> getCuentacorrienteCollection() {
        return cuentacorrienteCollection;
    }

    public void setCuentacorrienteCollection(Collection<Cuentacorriente> cuentacorrienteCollection) {
        this.cuentacorrienteCollection = cuentacorrienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Cliente[ dni=" + dni + " ]";
    }

}
