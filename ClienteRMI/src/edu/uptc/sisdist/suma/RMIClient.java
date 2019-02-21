/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.sisdist.suma;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainWindow;
import view.Registrarse;

/**
 * Ejemplo de un cliente RMI
 *
 * @author Carlos Arenas
 */
public class RMIClient {

    public MainWindow mainWindow;
    public InterfaceRemota objetoRemoto;

//    private InterfaceRemota objetoRemoto;
    public RMIClient(String obtenerNombre, String nm) {

        mainWindow = new MainWindow(nm, this);

        try {
            // Lugar en el que esta el objeto remoto.
            // Debe reemplazarse "localhost" por el nombre o ip donde
            // esta corriendo "rmiregistry".
            // Naming.lookup() obtiene el objeto remoto

            objetoRemoto
                    = (InterfaceRemota) Naming.lookup("//localhost/ObjetoRemoto");
            Registry registry = LocateRegistry.getRegistry();
            String[] boundNames = registry.list();
            for (String name : boundNames) {
                System.out.println(name);
            }
            // Se realiza la suma remota.
            System.out.println("hooooooooooooooooo");
            System.out.println(objetoRemoto.suma(5, 6));
//                        mainWindow.pintarUsuariosConectados(objetoRemoto.listaUsuarios(obtenerNombre));
//            ArrayList<String> hh = objetoRemoto.listaUsuarios(obtenerNombre
             objetoRemoto.listaUsuarios(obtenerNombre);
            mainWindow.pintarUsuariosConectados(objetoRemoto.listaUsuarios1(obtenerNombre));
            mainWindow.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //
    }

    public void enviarChat(String n) throws RemoteException {
        mainWindow.pintarChat(objetoRemoto.enviarChat(n));

    }

}
