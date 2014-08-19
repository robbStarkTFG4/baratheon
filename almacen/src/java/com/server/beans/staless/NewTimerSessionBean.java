/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblPrestarios;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author NORE
 */
@Stateless
public class NewTimerSessionBean extends AbstractFacade<TblPrestamo> {

    @EJB
    TblPrestamoFacade presi;

    @EJB
    TblPrestariosFacade prestarioF;

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    public NewTimerSessionBean() {
        super(TblPrestamo.class);
    }

    public NewTimerSessionBean(Class<TblPrestamo> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Schedule(hour = "*", minute = "*", persistent = false)
    public void myTimer() {
        Date date = new Date();
        TypedQuery<TblPrestamo> query = em.createQuery("SELECT c FROM TblPrestamo c WHERE c.statusprestamo != 0 AND c.statusprestamo  != 3 AND c.statusprestamo !=4", TblPrestamo.class);
        List<TblPrestamo> list = query.getResultList();
        if (!list.isEmpty()) {
            for (TblPrestamo obj : list) {
                System.out.println("prestamo #: " + obj.getIdPrestamo() + " fecha aprobacion: " + obj.getFechaprestamo());
                System.out.println("nombre de prestario: " + obj.getIdPrestario().getNombre());

                TblPrestarios prestario = obj.getIdPrestario();

                if (obj.getFechaVencimiento() != null) {
                    if (obj.getFechaVencimiento().before(date)) {

                        if (obj.getStatusprestamo() != 4) {
                            obj.setStatusprestamo(4);
                            presi.edit(obj);
                        }
                        System.out.println("el prestario esta: " + prestario.getActivo());
                        if (prestario.getActivo() != 2) {
                            prestario.setActivo(2);
                            prestarioF.edit(prestario);

                            System.out.println("DEUDOR DETECTADO");
                        }
                        System.out.println("PRESTAMO VENCIDO");
                    } else {
                        System.out.println("PRESTAMO VALIDO");
                    }
                }

            }
        } else {
            System.out.println("BASE DE DATOSS VACIA");
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
