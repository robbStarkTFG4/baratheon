/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import entitys.Subfamilias;
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
public class SubfamiliasFacade extends AbstractFacade<Subfamilias> {
    @PersistenceContext(unitName = "AltasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubfamiliasFacade() {
        super(Subfamilias.class);
    }
   public boolean agregar(String nombre, String descripcion){
Subfamilias us2=null;
 Query search1 =em.createQuery("SELECT t FROM Subfamilias t WHERE t.nombre = :nom");
 search1.setParameter("nom", nombre);

 try{
 us2=  (Subfamilias) search1.getSingleResult();
 return false;
 }
 catch(Exception e){
  Subfamilias sf=new Subfamilias();
sf.setNombre(nombre);
sf.setDescripcion(descripcion);
em.persist(sf);
return true;
 
 }

} 
   public List<Subfamilias> listAL() {

        List<Subfamilias> list ;

            TypedQuery<Subfamilias> search = em.createQuery("SELECT NEW entitys.Subfamilias(u.idsubFam,u.nombre) FROM Subfamilias u ", Subfamilias.class);
            //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        list = search.getResultList();
     return list;
  
    }
}
