/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.stateless;

import com.server.entity.MapF;
import com.server.entity.Subfamilias;
import java.util.ArrayList;
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
public class MapFacade extends AbstractFacade<MapF> {

    @PersistenceContext(unitName = "MtlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MapFacade() {
        super(MapF.class);
    }

    public List<Subfamilias> getSubs(int idFamilia) {
        TypedQuery<Subfamilias> q = em.createQuery("SELECT  NEW com.server.entity.Subfamilias(g.idsubFam,g.nombre) FROM MapF c  JOIN c.subfamilias g WHERE c.tblTipomaterialIdTipomaterial.idTipomaterial = :familia ", Subfamilias.class);
        q.setParameter("familia", idFamilia);
        List<Subfamilias> list = q.getResultList();

      

        return list;
    }

}
