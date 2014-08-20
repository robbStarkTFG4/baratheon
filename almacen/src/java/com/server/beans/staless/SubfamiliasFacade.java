/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.Subfamilias;
import com.util.SubFamDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class SubfamiliasFacade extends AbstractFacade<Subfamilias> {

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubfamiliasFacade() {
        super(Subfamilias.class);
    }

    public List<SubFamDTO> getSubsFam(int id) {
        Query query = em.createQuery("SELECT c.subfamilias.idsubFam, c.subfamilias.nombre  FROM Map c WHERE c.tblTipomaterialIdTipomaterial.idTipomaterial = :id");
        query.setParameter("id", id);

        List<SubFamDTO> res = new ArrayList<>();

        List data = query.getResultList();

        for (Iterator it = data.iterator(); it.hasNext();) {
            Object[] object = (Object[]) it.next();

            SubFamDTO temp = new SubFamDTO();
            temp.setId((Integer) object[0]);
            temp.setNombre((String) object[1]);

            res.add(temp);
        }
        return res;
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

            TypedQuery<Subfamilias> search = em.createQuery("SELECT NEW com.server.entity.beans.Subfamilias(u.idsubFam,u.nombre) FROM Subfamilias u ", Subfamilias.class);
            //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        list = search.getResultList();
     return list;
  
    }
}
