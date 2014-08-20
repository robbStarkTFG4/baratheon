/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.beans.staless;


import com.server.entity.beans.Almacen;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author cristian
 */
@Stateless
public class AlmacenFacade extends AbstractFacade<Almacen> {
    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlmacenFacade() {
        super(Almacen.class);
    }
 public boolean agregar(String descripcion){
Almacen us2=null;
 Query search1 =em.createQuery("SELECT t FROM Almacen t WHERE t.descripcion = :nom");
 search1.setParameter("nom", descripcion);

 try{
 us2=   (Almacen) search1.getSingleResult();
 return false;
 }
 catch(Exception e){
Almacen al=new Almacen();
al.setDescripcion(descripcion);
em.persist(al);
return true;
 
 }

} 
 public List<Almacen> listAL() {

        List<Almacen> list ;

            TypedQuery<Almacen> search = em.createQuery("SELECT NEW com.server.entity.beans.Almacen(u.idalmacen,u.descripcion) FROM Almacen u ", Almacen.class);
            //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        list = search.getResultList();
     return list;
  
    }
 
 
}
