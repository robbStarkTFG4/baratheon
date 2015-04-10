/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entitys.Fabricacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class FabricacionFacade extends AbstractFacade<Fabricacion> {
    @PersistenceContext(unitName = "MRPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FabricacionFacade() {
        super(Fabricacion.class);
    }
    public List<Fabricacion> tomarorden (int id,int cant) {
   List<Fabricacion> fab=null;
        System.out.println("CANT: "+cant);
   try{
  Query consultita =em.createQuery("SELECT t FROM Fabricacion t WHERE t.tblProductoidTblProducto.idTblProducto = :id and t.cantidad * :cant > t.tblMateriaidTblMateria.stock");
   //Query consultita =em.createQuery("SELECT t FROM Fabricacion t WHERE t.tblProductoidTblProducto.idTblProducto = :id ");
   consultita.setParameter("id", id);
   consultita.setParameter("cant", cant);
   fab=consultita.getResultList();
       //System.out.println(fab);
   }catch (Exception e){
   System.out.println("ERROR IN Question FACADEeeeee:" + e.getMessage());
   
   }
   return fab;
   }   
    
    public Fabricacion fab(int f){
    Fabricacion fab = null;
    try{
   Query consultita =em.createQuery("SELECT t FROM Fabricacion t WHERE t.idFabricacioncol = :id");
   consultita.setParameter("id", f);
   fab=(Fabricacion) consultita.getSingleResult();

    } catch (Exception e){
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
    return fab;
    
    }
}
