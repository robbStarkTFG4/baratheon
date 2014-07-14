/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import entitys.Almacen;
import entitys.TblArea;
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
public class TblAreaFacade extends AbstractFacade<TblArea> {
    @PersistenceContext(unitName = "AltasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblAreaFacade() {
        super(TblArea.class);
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

            TypedQuery<TblArea> search = em.createQuery("SELECT NEW entitys.TblArea(u.idArea,u.descripcion) FROM TblArea u ", TblArea.class);
            //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        list = search.getResultList();
     return list;
  
    }
 
}
