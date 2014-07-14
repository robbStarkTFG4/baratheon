/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import entitys.TblArea;
import entitys.TblTipomaterial;
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
public class TblTipomaterialFacade extends AbstractFacade<TblTipomaterial> {
    @PersistenceContext(unitName = "AltasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblTipomaterialFacade() {
        super(TblTipomaterial.class);
    }
    
     public boolean agregar(String nombre, String area){
TblTipomaterial us2=null;
 Query search1 =em.createQuery("SELECT t FROM TblTipomaterial t WHERE t.descripcion = :nom");
 search1.setParameter("nom", nombre);

 try{
 us2= (TblTipomaterial) search1.getSingleResult();
 return false;
 }
 catch(Exception e){
  TblTipomaterial tm=new TblTipomaterial();
 TblArea ar=new TblArea();
 ar.setIdArea(Integer.parseInt(area));
 tm.setDescripcion(nombre);
 tm.setTblAreaIdArea(ar);
em.persist(tm);
return true;
 
 }

}  
   public List<TblTipomaterial> listAtm() {

        List<TblTipomaterial> list ;

            TypedQuery<TblTipomaterial> search = em.createQuery("SELECT NEW entitys.TblTipomaterial(u.idTipomaterial,u.descripcion) FROM TblTipomaterial u ", TblTipomaterial.class);
            //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        list = search.getResultList();
     return list;
  
    } 
}
