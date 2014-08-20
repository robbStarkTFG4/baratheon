/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.beans.staless;

import com.server.entity.beans.TblArea;
import com.util.AreasDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author NORE
 */
@Stateless
public class TblAreaFacade extends AbstractFacade<TblArea> {
    
    @EJB
    SubfamiliasFacade subs;
    
    @EJB
    TblTipomaterialFacade tp;
    
    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblAreaFacade() {
        super(TblArea.class);
    }

   
    public List<AreasDTO> getCategories() {
        Query query=em.createQuery("SELECT c.idArea, c.descripcion FROM TblArea c ");
        List res=query.getResultList();
        
        List<AreasDTO> results=new ArrayList<>();
        
        for (Iterator it = res.iterator(); it.hasNext();) {
            Object[] object = (Object[])it.next();
            
            AreasDTO temp=new AreasDTO();
            temp.setId((Integer) object[0]);
            temp.setNombre((String) object[1]);
            temp.setTipo(tp.getTypes((int)object[0]));
            
            results.add(temp);
        }
       return results;
    }
    
   public boolean agregar(String descripcion){
TblArea us2=null;
 Query search1 =em.createQuery("SELECT t FROM TblArea t WHERE t.descripcion = :nom");
 search1.setParameter("nom", descripcion);

 try{
 us2=    (TblArea) search1.getSingleResult();
 return false;
 }
 catch(Exception e){
TblArea a=new TblArea();
a.setDescripcion(descripcion);
em.persist(a);
return true;
 
 }

} 
 
 public List<TblArea> listAr() {

        List<TblArea> list ;

            TypedQuery<TblArea> search = em.createQuery("SELECT NEW com.server.entity.beans.TblArea(u.idArea,u.descripcion) FROM TblArea u ", TblArea.class);
            //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        list = search.getResultList();
     return list;
  
    }
  
}
