/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblArea;
import com.server.entity.beans.TblTipomaterial;
import com.util.TipoDTO;
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
public class TblTipomaterialFacade extends AbstractFacade<TblTipomaterial> {
    
    @EJB
    SubfamiliasFacade subs;

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblTipomaterialFacade() {
        super(TblTipomaterial.class);
    }

    public List<TipoDTO> getTypes(int id) {
        Query query = em.createQuery("SELECT c.idTipomaterial, c.descripcion FROM TblTipomaterial c WHERE c.tblAreaIdArea.idArea = :id");
        query.setParameter("id", id);

        List<TipoDTO> res = new ArrayList<>();

        List obj = query.getResultList();

        for (Iterator it = obj.iterator(); it.hasNext();) {
            Object[] object = (Object[]) it.next();

            TipoDTO temp = new TipoDTO();
            temp.setId((int) object[0]);
            temp.setNombre((String) object[1]);
            temp.setFams(subs.getSubsFam((int) object[0]));
            res.add(temp);
        }
        return res;
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

            TypedQuery<TblTipomaterial> search = em.createQuery("SELECT NEW com.server.beans.staless.TblTipomaterial(u.idTipomaterial,u.descripcion) FROM TblTipomaterial u ", TblTipomaterial.class);
            //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        list = search.getResultList();
     return list;
  
    } 
}
