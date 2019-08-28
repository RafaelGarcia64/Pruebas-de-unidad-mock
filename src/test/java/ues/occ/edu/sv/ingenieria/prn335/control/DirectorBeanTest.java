/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.ingenieria.prn335.entities.Director;

/**
 *
 * @author rafael
 */
@ExtendWith(MockitoExtension.class)
public class DirectorBeanTest {

    /**
     * Test of crear method, of class DirectorBean.
     */
    @Test
    public void testCrear() {
        System.out.println("Crear");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTx = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTx);
        DirectorBean cut = new DirectorBean();
        cut.em=mockEM;
        Director director = new Director();
        director.setIdDirector(1);
        director.setNombre("Nombre");
        director.setApellido("Apellido");
        director.setActivo(true);
        cut.crear(director);
        Mockito.verify(mockEM,Mockito.times(1)).persist(Mockito.any());
    }

    /**
     * Test of eliminar method, of class DirectorBean.
     */
    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTx = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTx);
        DirectorBean cut = new DirectorBean();
        cut.em=mockEM;
        Director director = new Director();
        director.setIdDirector(1);
        director.setNombre("Nombre");
        director.setApellido("Apellido");
        director.setActivo(true);
        cut.eliminar(director);
        Mockito.verify(mockEM,Mockito.times(1)).remove(Mockito.any());
    }

    

    /**
     * Test of formatoNombre method, of class DirectorBean.
     */
    @Test
    public void testFormatoNombre() {
        System.out.println("FormatoMombre");
        DirectorBean cut = new DirectorBean();
        String prueba = "hOlA MuNdO";
        String expResult = "Hola Mundo.";
        String result = cut.formatoNombre(prueba);
        Assert.assertTrue(expResult.equals(result));
    }
    
}
