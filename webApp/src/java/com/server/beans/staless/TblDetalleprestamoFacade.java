/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblDetalleprestamo;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.util.DetailDTO;
import java.util.ArrayList;

/**
 *
 * @author NORE
 */
@Stateless
public class TblDetalleprestamoFacade extends AbstractFacade<TblDetalleprestamo> {

    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDetalleprestamoFacade() {
        super(TblDetalleprestamo.class);
    }

    public List<DetailDTO> joinMaterialName(int presID) {
        Query query = em.createQuery("SELECT k.noParte, k.nombre , c.cantidad,c.fecharetorno, c.horaretorno , c.idDetalleprestamo FROM TblDetalleprestamo c JOIN c.idPrestamo h  JOIN c.idMaterial k WHERE h.idPrestamo = :pres");
        query.setParameter("pres", presID);
        List list = query.getResultList();
        List<DetailDTO> data = new ArrayList<>();
        //0-4
        for (Iterator it = list.iterator(); it.hasNext();) {
            Object[] res = (Object[]) it.next();
            System.out.println("#parte: " + res[0] + " nombre: " + res[1] + " cantidad: " + res[2] + " fechaRetorno: " + res[3] + " horaRetorno: " + res[4]);
            DetailDTO add = new DetailDTO();
            add.setNoParte((String) res[0]);
            add.setNombre((String) res[1]);
            add.setCantidad((int) res[2]);
            add.setFecharetorno((String) res[3]);
            add.setHoraretorno((String) res[4]);
            add.setIdDetalleprestamo((int) res[5]);

            data.add(add);
        }

        return data;
    }
}
