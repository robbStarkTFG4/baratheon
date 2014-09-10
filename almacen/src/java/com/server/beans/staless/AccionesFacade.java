/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.beans.staless;

import com.server.entity.beans.Acciones;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cristian
 */
@Stateless
public class AccionesFacade extends AbstractFacade<Acciones> {
    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccionesFacade() {
        super(Acciones.class);
    }
  public void create( String descripcion, String usuario, String idelemento){
  
String dates;
String hour;
Date date = new Date();
DateFormat hourFormat = new SimpleDateFormat("HH:mm");
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
dates= dateFormat.format(date);
hour=hourFormat.format(date); 

/*      System.out.println("descripcion: "+descripcion);
      System.out.println("fecha: "+dates);
      System.out.println("hour: "+hour);
      System.out.println("Usuario: "+usuario);
      System.out.println("idelemto: "+idelemento);*/
   try{ 
       Acciones accion =new Acciones();
       if (idelemento!=null){
 
 accion.setDescripcion(descripcion);
 accion.setFecha(dates);
 accion.setHora(hour);
 accion.setUsuario(usuario);
 accion.setIdelementoModif(idelemento);
  
       }else{
 accion.setDescripcion(descripcion);
 accion.setFecha(dates);
 accion.setHora(hour);
 accion.setUsuario(usuario); 
       }
   em.persist(accion);
  
 }
 catch(Exception e){

 } 
  
  }  
}
