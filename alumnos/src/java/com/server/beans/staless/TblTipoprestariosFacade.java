/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblTipoprestarios;
import com.util.TipoPrestarioDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @autor NORE
 */
@Stateless
public class TblTipoprestariosFacade extends AbstractFacade<TblTipoprestarios> {

    @PersistenceContext(unitName = "alumnosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblTipoprestariosFacade() {
        super(TblTipoprestarios.class);
    }

    public List<TipoPrestarioDTO> getTypes() {
        Query query = em.createQuery("SELECT c.idTipoprestarios , c.descripcion  FROM TblTipoprestarios c ");
        List res = query.getResultList();

        if (res != null) {
            List<TipoPrestarioDTO> list = new ArrayList<>();
            for (Iterator it = res.iterator(); it.hasNext();) {
                Object[] obj = (Object[]) it.next();
                TipoPrestarioDTO temp = new TipoPrestarioDTO((int) obj[0], (String) obj[1]);
                list.add(temp);
            }

            return list;
        }
        return null;
    }

}
