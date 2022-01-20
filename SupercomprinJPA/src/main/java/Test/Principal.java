/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.ClienteDAO;
import Entidad.Cliente;
import java.util.List;
import java.lang.String;
import java.util.ArrayList;

/**
 *
 * @author Maria Angeles
 */
public class Principal {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        //Obtener las wallet de los clientes dados de alta
        ClienteDAO cdao = new ClienteDAO();
        List<Cliente> lista = cdao.seleccionar();
        lista.forEach(cliente -> {System.out.println(cliente);
        System.out.println("    "+cliente.getWallet());});
        
        
       
        //Printar apellidos
        ClienteDAO cdaoApe = new ClienteDAO();
        List<String> miapellido = new ArrayList<>();
        miapellido =cdaoApe.seleccionarSoloApellidos();
        System.out.println("los apellidos son" +miapellido);
        
        
           //Printar sólo los clientes con Wallet
        ClienteDAO cdaoW = new ClienteDAO();
        List<Cliente> listaconW = cdao.seleccionarSoloClientesConWallet();
        listaconW.forEach(cliente -> {System.out.println(cliente);
        System.out.println("Clientes Sólo con Wallet    "+cliente.getNombre());});
        
       
    }
              
                                   
}


