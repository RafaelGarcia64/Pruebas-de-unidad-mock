/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.ingenieria.prn335.entities.Director;

/**
 *
 * @author rafael
 */
public class DirectorBean {

    public EntityManager em;
    final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("cinePU");

    public void iniciar() {
        this.em = EMF.createEntityManager();
    }

    public EntityTransaction getTx() {
        if (this.em != null) {
            return this.em.getTransaction();
        }
        return null;
    }

    /**
     * Metodo para agregar entidad a la base
     *
     * @param entidad
     */
    public void crear(Director entidad) {
        EntityTransaction tx = this.getTx();
        tx.begin();
        this.em.persist(entidad);
        tx.commit();

    }

    /**
     * Metodo para eliminar entidad de la base
     *
     * @param entidad
     */
    public void eliminar(Director entidad) {
        EntityTransaction tx = this.getTx();
        tx.begin();
        this.em.remove(entidad);
        tx.commit();

    }

    /**
     * Este metodo convierte una cadena con mayusculas y ninusculas
     * desordenadas, en cadena con un formato establecido
     *
     * @param Nombre cadena de texto con mayusculas desordenadas
     * @return cadena de texto con un formato especifico
     */
    public String formatoNombre(String Nombre) {
        if (!(Nombre.isEmpty() || Nombre.equals(""))) {
            String array[] = Nombre.split("\\s");
            String formato = "";
            for (String palabra : array) {
                formato += (Character.toUpperCase(palabra.charAt(0)) + palabra.substring(1, palabra.length()).toLowerCase() + " ");
            }
            formato = formato.substring(0, formato.length() - 1);
            formato += ".";
            return formato;
        }
        return Nombre;
    }
}
