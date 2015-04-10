/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entitys.Tblusuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class TblusuariosFacade extends AbstractFacade<Tblusuarios> {
    @PersistenceContext(unitName = "MRPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblusuariosFacade() {
        super(Tblusuarios.class);
    }
   public Tblusuarios logIn(String usuario, String clave){
 Tblusuarios us=null;   
 
 try{
Query consultita =em.createQuery("SELECT t FROM Tblusuarios t WHERE t.usuario = :usuario and t.password = :clave");
consultita.setParameter("usuario", usuario);
consultita.setParameter("clave", clave);

us=(Tblusuarios) consultita.getSingleResult();
 }catch(Exception e){
 return us;
 } 
 return us;
}  
}
