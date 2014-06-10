/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.stateless;

import com.server.entity.Subfamilias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORE
 */
@Stateless
public class SubfamiliasFacade extends AbstractFacade<Subfamilias> {
    @PersistenceContext(unitName = "MtlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubfamiliasFacade() {
        super(Subfamilias.class);
    }
    
}
