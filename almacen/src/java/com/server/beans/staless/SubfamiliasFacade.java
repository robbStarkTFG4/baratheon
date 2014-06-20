/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.Subfamilias;
import com.util.SubFamDTO;
import java.util.ArrayList;
import java.util.Iterator;
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
public class SubfamiliasFacade extends AbstractFacade<Subfamilias> {

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubfamiliasFacade() {
        super(Subfamilias.class);
    }

    public List<SubFamDTO> getSubsFam(int id) {
        Query query = em.createQuery("SELECT c.subfamilias.idsubFam, c.subfamilias.nombre  FROM Map c WHERE c.tblTipomaterialIdTipomaterial.idTipomaterial = :id");
        query.setParameter("id", id);

        List<SubFamDTO> res = new ArrayList<>();

        List data = query.getResultList();

        for (Iterator it = data.iterator(); it.hasNext();) {
            Object[] object = (Object[]) it.next();

            SubFamDTO temp = new SubFamDTO();
            temp.setId((Integer) object[0]);
            temp.setNombre((String) object[1]);

            res.add(temp);
        }
        return res;
    }

}
