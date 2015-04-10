/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entitys.Tblprovedores;
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
public class TblprovedoresFacade extends AbstractFacade<Tblprovedores> {
    @PersistenceContext(unitName = "MRPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblprovedoresFacade() {
        super(Tblprovedores.class);
    }
  public List<Tblprovedores> cargarProvedores (int id) {
 List<Tblprovedores> listprove=null;
   try{
   Query consultita =em.createQuery("SELECT t.tblProvedoresidTblProvedores FROM TblmaterialProvedor t WHERE t.tblMateriaidTblMateria.idTblMateria = :id ");
   consultita.setParameter("id", id);
   listprove=consultita.getResultList();
   }catch (Exception e){
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
   return listprove;
   } 
  
  public String precioprovedor (int idpro,int  idmat) {
 String precio=null;
   try{
   Query consultita =em.createQuery("SELECT t.precio FROM TblmaterialProvedor t WHERE t.tblMateriaidTblMateria.idTblMateria = :idmat AND t.tblProvedoresidTblProvedores.idTblProvedores = :idp");
   consultita.setParameter("idmat", idmat);
   consultita.setParameter("idp", idpro);
   precio=(String) consultita.getSingleResult();
   }catch (Exception e){
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
   return precio;
   }   
  
  
}




