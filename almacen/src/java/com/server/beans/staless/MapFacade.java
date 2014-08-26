/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.beans.staless;

import com.server.entity.beans.Map;
import com.server.entity.beans.Subfamilias;
import com.server.entity.beans.TblTipomaterial;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NORE
 */
@Stateless
public class MapFacade extends AbstractFacade<Map> {
    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;
 
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MapFacade() {
        super(Map.class);
    }
   public void agregarmap(TblTipomaterial tm, String nombre) {
   Subfamilias us2 = null;
    //Subfamilias sf2=null;
   Map nm =new Map();
        Query search1 = em.createQuery("SELECT t FROM Subfamilias t WHERE t.nombre = :nom");
        search1.setParameter("nom", nombre);
   
   try {
       
            us2 = (Subfamilias) search1.getSingleResult();
            System.out.println(us2);
            System.out.println(tm);
           
           nm.setSubfamilias(us2);
           nm.setTblTipomaterialIdTipomaterial(tm);
          
        // em.persist(nm);
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
   }
}
