/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.Map;
import com.server.entity.beans.Subfamilias;
import com.server.entity.beans.TblTipomaterial;
import com.util.SubFamDTO;
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
public class SubfamiliasFacade extends AbstractFacade<Subfamilias> {

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;
 @EJB MapFacade mf;
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

    public boolean agregar(String nombre, String descripcion, TblTipomaterial tm) {
        System.out.println("nombre");
        Subfamilias us2 = null;
       // Subfamilias sf2=null;
        Query search1 = em.createQuery("SELECT t FROM Subfamilias t WHERE t.nombre = :nom");
        search1.setParameter("nom", nombre);

        
        
        try {
            us2 = (Subfamilias) search1.getSingleResult();
            return false;
        } catch (Exception e) {
           // Map nuevomapa =new Map();
            
            Subfamilias sf = new Subfamilias();
            sf.setNombre(nombre);
            sf.setDescripcion(descripcion);
            em.persist(sf);
         //  Query search2 = em.createQuery("SELECT t FROM Subfamilias t WHERE t.nombre = :nom");
         // sf2=(Subfamilias) search1.setParameter("nom", nombre);
            //System.out.println(sf2.getNombre()); 
            System.out.println(tm);
           
            /*nuevomapa.setSubfamilias(sf2);
            nuevomapa.setTblTipomaterialIdTipomaterial(tm);
            
            em.persist(nuevomapa);*/
            return true;

        }

    }
public boolean agregar2(String nombre, String descripcion, TblTipomaterial tm) {

    System.out.println(nombre);
    System.out.println(descripcion);
    System.out.println(tm);
    Subfamilias us2 = null;
    //Subfamilias sf2=null;
        Query search1 = em.createQuery("SELECT t FROM Subfamilias t WHERE t.nombre = :nom");
        search1.setParameter("nom", nombre);

        
        
        try {
            us2 = (Subfamilias) search1.getSingleResult();
            return false;
        } catch (Exception e) {
           
            Subfamilias sf = new Subfamilias();
            sf.setNombre(nombre);
            sf.setDescripcion(descripcion);
           
            em.persist(sf);
            em.flush();
            
       //  Query search2 = em.createQuery("SELECT t FROM Subfamilias t WHERE t.nombre = :nom");
      //  sf2=(Subfamilias) search1.setParameter("nom", nombre);
           System.out.println(sf); 
            System.out.println(tm);
           
          
         //   nuevomapa.setTblTipomaterialIdTipomaterial(tm);
            
          //  em.persist(nuevomapa);*/
            
          mf.agregarmap(tm, nombre);
            
            return true;



        }

}
    public List<Subfamilias> listAL(Integer idTipo) {

        List<Subfamilias> res = new ArrayList<>();
// com.server.entity.beans.Subfamilias(u.idsubFam,u.nombre)
        Query search = em.createQuery("SELECT c.subfamilias.idsubFam, c.subfamilias.nombre FROM Map c WHERE c.tblTipomaterialIdTipomaterial.idTipomaterial = :id");
        search.setParameter("id", idTipo);
        //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        for (Iterator it = search.getResultList().iterator(); it.hasNext();) {
            Object[] object = (Object[]) it.next();

            Subfamilias temp = new Subfamilias((int) object[0], (String) object[1]);
            res.add(temp);
        }
        return res;

    }
}
