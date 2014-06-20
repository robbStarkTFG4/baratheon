/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.beans.staless;

import com.server.entity.beans.TblArea;
import com.util.AreasDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NORE
 */
@Stateless
public class TblAreaFacade extends AbstractFacade<TblArea> {
    
    @EJB
    SubfamiliasFacade subs;
    
    @EJB
    TblTipomaterialFacade tp;
    
    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblAreaFacade() {
        super(TblArea.class);
    }

   
    public List<AreasDTO> getCategories() {
        Query query=em.createQuery("SELECT c.idArea, c.descripcion FROM TblArea c ");
        List res=query.getResultList();
        
        List<AreasDTO> results=new ArrayList<>();
        
        for (Iterator it = res.iterator(); it.hasNext();) {
            Object[] object = (Object[])it.next();
            
            AreasDTO temp=new AreasDTO();
            temp.setId((Integer) object[0]);
            temp.setNombre((String) object[1]);
            temp.setTipo(tp.getTypes((int)object[0]));
            
            results.add(temp);
        }
       return results;
    }
    
    
}
