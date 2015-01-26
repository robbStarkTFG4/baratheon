/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblPendientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author NORE
 */
@Stateless
public class TblPendientesFacade extends AbstractFacade<TblPendientes> {

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblPendientesFacade() {
        super(TblPendientes.class);
    }

    public boolean checkIFListed(String noParte) {
        Query query = em.createQuery("SELECT c.razon FROM TblPendientes c WHERE c.objeto = :part");
        query.setParameter("part", noParte);
        try {
            return query.getSingleResult().toString().equals("eliminar");

        } catch (NoResultException e) {
            return false;
        }
    }

    public TblPendientes findPending(String noParte) {
        TypedQuery<TblPendientes> query = em.createQuery("SELECT c FROM TblPendientes c WHERE c.objeto = :part", TblPendientes.class);
        query.setParameter("part", noParte);

        try {
            TblPendientes res = query.getSingleResult();
            if (res.getRazon().equals("eliminar")) {
                return res;
            } else {
                return null;
            }
        } catch (javax.persistence.NoResultException e) {
            return null;
        }

    }

}
