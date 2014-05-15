/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblTipomaterial;
import com.util.TipoDTO;
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
public class TblTipomaterialFacade extends AbstractFacade<TblTipomaterial> {
    
    @EJB
    SubfamiliasFacade subs;

    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblTipomaterialFacade() {
        super(TblTipomaterial.class);
    }

    public List<TipoDTO> getTypes(int id) {
        Query query = em.createQuery("SELECT c.idTipomaterial, c.descripcion FROM TblTipomaterial c WHERE c.tblAreaIdArea.idArea = :id");
        query.setParameter("id", id);

        List<TipoDTO> res = new ArrayList<>();

        List obj = query.getResultList();

        for (Iterator it = obj.iterator(); it.hasNext();) {
            Object[] object = (Object[]) it.next();

            TipoDTO temp = new TipoDTO();
            temp.setId((int) object[0]);
            temp.setNombre((String) object[1]);
            temp.setFams(subs.getSubsFam((int) object[0]));
            res.add(temp);
        }
        return res;
    }

}
