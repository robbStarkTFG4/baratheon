/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.beans.staless;

import com.server.entity.beans.TblMaterial;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author NORE
 */
@Stateless
public class TblMaterialFacade extends AbstractFacade<TblMaterial> {
    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMaterialFacade() {
        super(TblMaterial.class);
    }

    public List<TblMaterial> autoQueryName(String patron) {
        
        TypedQuery<TblMaterial> query = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial(c.noParte,c.nombre) FROM TblMaterial c WHERE c.nombre LIKE :patron", TblMaterial.class);
        query.setParameter("patron", patron.toLowerCase() + "%");
       
        List<TblMaterial> res = query.getResultList();
        
        return res;
    }

    public List<TblMaterial> autoQueryPartNumber(String patron) {
         TypedQuery<TblMaterial> query = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial(c.noParte,c.nombre) FROM TblMaterial c WHERE c.noParte LIKE :patron", TblMaterial.class);
        query.setParameter("patron", patron.toLowerCase() + "%");

        List<TblMaterial> res = query.getResultList();

        return res;
    }
    
}
