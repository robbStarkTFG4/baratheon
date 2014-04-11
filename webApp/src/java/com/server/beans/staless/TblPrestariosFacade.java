/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblPrestarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NORE
 */
@Stateless
public class TblPrestariosFacade extends AbstractFacade<TblPrestarios> {

    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblPrestariosFacade() {
        super(TblPrestarios.class);
    }

    public TblPrestarios getPres(String matricula) {
        Query query = em.createQuery("SELECT c FROM TblPrestarios c WHERE c.usuario = :usuario");
        query.setParameter("usuario", matricula);
        TblPrestarios res = null;
        try {
            res = (TblPrestarios) query.getSingleResult();
            return res;
        } catch (javax.persistence.NoResultException e) {
            //   e.printStackTrace();
            return null;
        }
      
    }

}
