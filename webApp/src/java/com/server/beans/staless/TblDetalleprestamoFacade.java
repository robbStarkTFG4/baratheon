/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblDetalleprestamo;
import com.util.DetailDTO;
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

    /*private Integer idDetalleprestamo;
     private int cantidad;
   
     private String fecharetorno;
  
     private String horaretorno;
    
     private String noParte;
   
     private String nombre;*/
    public List<DetailDTO> getDtls(int idLoan) {
        Query query = em.createQuery("SELECT c.idDetalleprestamo, c.cantidad, c.fecharetorno, c.horaretorno, c.idMaterial.noParte , c.idMaterial.nombre , c.idMaterial.idtblMaterial, c.idPrestamo.idPrestamo  FROM  TblDetalleprestamo c WHERE c.idPrestamo.idPrestamo = :id");
        query.setParameter("id", idLoan);

        List<DetailDTO> data = new ArrayList<>();

        List res = query.getResultList();

        if (res != null) {

            for (Iterator it = res.iterator(); it.hasNext();) {
                Object[] object = (Object[]) it.next();

                DetailDTO temp = new DetailDTO();
                temp.setIdDetalleprestamo((Integer) object[0]);
                temp.setCantidad((int) object[1]);
                temp.setFecharetorno((String) object[2]);
                temp.setHoraretorno((String) object[3]);
                temp.setNoParte((String) object[4]);
                temp.setNombre((String) object[5]);
                temp.setIdMaterial((int) object[6]);
                temp.setIdPres((int) object[7]);
                
                data.add(temp);
            }
            return data;
        }
        return null;
    }

}
