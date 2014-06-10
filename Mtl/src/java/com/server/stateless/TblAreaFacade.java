/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.stateless;

import com.server.entity.TblArea;
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
public class TblAreaFacade extends AbstractFacade<TblArea> {

    @PersistenceContext(unitName = "MtlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblAreaFacade() {
        super(TblArea.class);
    }

    public List<TblArea> list() {
        TypedQuery<TblArea> query = em.createQuery("SELECT   NEW com.server.entity.TblArea(c.idArea,c.descripcion) FROM TblArea c",TblArea.class);
        List<TblArea> res = query.getResultList();
        res.size();
      
        
        return res;
    }

}
