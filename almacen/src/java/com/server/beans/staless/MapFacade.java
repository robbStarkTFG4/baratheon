/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.Map;
import com.server.entity.beans.Subfamilias;
import com.server.entity.beans.TblTipomaterial;
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
public class MapFacade extends AbstractFacade<Map> {

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MapFacade() {
        super(Map.class);
    }

    public void agregarmap(TblTipomaterial tm, Subfamilias sub) {

        Query query = em.createQuery("SELECT MAX(c.mapPK.idMap)  FROM Map c ");
        int max = 0;
        try {
            max = (int) query.getSingleResult();
        } catch (Exception e) {
            max = 0;
        }
        System.out.println("EL MAXIMO ID ES:  " + max);
        try {
            Map nm = new Map(max + 1, sub.getIdsubFam());
            nm.setTblTipomaterialIdTipomaterial(tm);

            this.create(nm);
        } catch (Exception e) {
            System.out.println("ERROR IN Map facade:" + e.getMessage());
        }
    }
}
