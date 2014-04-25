/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.beans.staless;

import com.server.entity.beans.TblPrestamo;
import com.util.PresDTO;
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
public class TblPrestamoFacade extends AbstractFacade<TblPrestamo> {
    
    @EJB
    TblDetalleprestamoFacade detail;
    
    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public TblPrestamoFacade() {
        super(TblPrestamo.class);
    }
    
    public List<PresDTO> getLoanByPresDebts(int idPrestario) {//prestamos adeudados
        Query query = em.createQuery("SELECT c.idPrestamo, c.fechaprestamo, c.horaprestamo, c.idUsuarios.usuario, c.statusprestamo, c.fecharetorno FROM TblPrestamo c  JOIN c.idPrestario p WHERE p.idPrestario = :id AND c.statusprestamo != 3"  );
        query.setParameter("id", idPrestario);
        List results = query.getResultList();
        List<PresDTO> data = new ArrayList<>();
        // 0-4
        for (Iterator it = results.iterator(); it.hasNext();) {
            Object[] res = (Object[]) it.next();
            System.out.println("idPrestamo: " + res[0] + " fechaPres: " + res[1] + " horaPres: " + res[2] + " usuario: " + res[3] + " statusPres: " + res[4]);
            PresDTO add = new PresDTO();
            add.setIdPrestamo((int) res[0]);
            add.setFechaprestamo((String) res[1]);
            add.setHoraprestamo((String) res[2]);
            add.setIdUsuarios((String) res[3]);
            add.setStatusprestamo((int) res[4]);
            add.setFecharetorno((String) res[5]);
            add.setTblDetalleprestamoList(detail.joinMaterialName((int) res[0]));
            
            data.add(add);
        }
        return data;
    }
    
       public List<PresDTO> getLoanByPresReleased(int idPrestario) {//prestamos ya finiquitados "no adeudados"
        Query query = em.createQuery("SELECT c.idPrestamo, c.fechaprestamo, c.horaprestamo, c.idUsuarios.usuario, c.statusprestamo, c.fecharetorno FROM TblPrestamo c  JOIN c.idPrestario p WHERE p.idPrestario = :id AND c.statusprestamo = 3");
        query.setParameter("id", idPrestario);
        List results = query.getResultList();
        List<PresDTO> data = new ArrayList<>();
        // 0-4
        for (Iterator it = results.iterator(); it.hasNext();) {
            Object[] res = (Object[]) it.next();
            System.out.println("idPrestamo: " + res[0] + " fechaPres: " + res[1] + " horaPres: " + res[2] + " usuario: " + res[3] + " statusPres: " + res[4]);
            PresDTO add = new PresDTO();
            add.setIdPrestamo((int) res[0]);
            add.setFechaprestamo((String) res[1]);
            add.setHoraprestamo((String) res[2]);
            add.setIdUsuarios((String) res[3]);
            add.setStatusprestamo((int) res[4]);
            add.setFecharetorno((String) res[5]);
            add.setTblDetalleprestamoList(detail.joinMaterialName((int) res[0]));
            
            data.add(add);
        }
        return data;
    }
    
}
