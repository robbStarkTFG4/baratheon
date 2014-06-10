/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.stateless;

import com.server.entity.TblTipomaterial;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NORE
 */
@Stateless
public class TblTipomaterialFacade extends AbstractFacade<TblTipomaterial> {

    @PersistenceContext(unitName = "MtlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblTipomaterialFacade() {
        super(TblTipomaterial.class);
    }

    public List<TblTipomaterial> getTypes(int id) {
        Query query = em.createQuery("SELECT NEW com.server.entity.TblTipomaterial(c.idTipomaterial,c.descripcion)   FROM TblTipomaterial c WHERE c.tblAreaIdArea.idArea = :id");
        query.setParameter("id", id);
        List<TblTipomaterial> rest = query.getResultList();
        return rest;
    }

}
