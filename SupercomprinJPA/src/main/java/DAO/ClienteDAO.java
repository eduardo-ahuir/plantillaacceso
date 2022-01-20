/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Maria Angeles
 */
public class ClienteDAO {

    static Logger log = LogManager.getRootLogger();
    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SCPU");

    public ClienteDAO() {
    }

    public List<Cliente> seleccionar() {
        EntityManager em = emfactory.createEntityManager();
        Query query1 = em.createNamedQuery("selectAllOrderByName",Cliente.class);
        List<Cliente> lista = (List<Cliente>) query1.getResultList();
        em.close();
        return lista;
        
    }
    public List<String> seleccionarSoloApellidos() {
        EntityManager em = emfactory.createEntityManager();
        Query query1 = em.createNamedQuery("selectSoloApellidos",Cliente.class);
        List<String> lista = (List<String>) query1.getResultList();
        em.close();
        return lista;}
        
          public List<Cliente> seleccionarSoloClientesConWallet() {
        EntityManager em = emfactory.createEntityManager();
        Query query1 = em.createNamedQuery("clientesConWallet",Cliente.class);
        List<Cliente> lista = (List<Cliente>) query1.getResultList();
        em.close();
        return lista;
        
    }
        
    
    public void insertar(Cliente cliente) {
      
        EntityManager em = emfactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        log.debug("Objeto a persistir: " + cliente);
        em.persist(cliente);
        tx.commit();
        log.debug("Objeto persistido correctamente " + cliente);
        em.close();
        
        //Wallet
        emfactory = Persistence.createEntityManagerFactory("WalletPU");
        em = emfactory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        log.debug("Objeto a persistir: " + cliente.getWallet());
        em.persist(cliente.getWallet());
        tx.commit();
        log.debug("Objeto persistido correctamente " + cliente.getWallet());
        em.close();
       
    }
    
    /*public void upwallet(cliente c){
        EntityManager em = emfactory.createEntityManager();
        Query query1 = em.createNamedQuery("upwallet");
        query1.setParameter("dinero", c.getDinero());
        query1.setParameter("puntos", c.getPuntos());
        query1.setParameter("dni", c.getDni());
        try{
        query1.executeUpdate();
        }
    }*/

}
