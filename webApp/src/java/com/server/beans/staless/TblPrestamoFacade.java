/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.client.named.BeanUsuarios;
import com.client.named.Prestamos;
import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblTipoprestarios;
import com.server.entity.beans.TblUsuarios;
import com.util.DetailDTO;
import com.util.PresDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author NORE
 */
@Stateless
public class TblPrestamoFacade extends AbstractFacade<TblPrestamo> {

    @EJB
    TblDetalleprestamoFacade dtl;

    @EJB
    TblMaterialFacade ml;
    @Inject
    Prestamos pres;
    @Inject
    BeanUsuarios user;
    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblPrestamoFacade() {
        super(TblPrestamo.class);
    }

    /*  private Integer idPrestamo;***
     private String fechaprestamo;****
     private String fecharetorno; ****
     private String horaprestamo;****
     private String idUsuarios;****
     private int statusprestamo;****
     private List<DetailDTO> tblDetalleprestamoList;*/
    public List<PresDTO> getLoansByDebts(int idPrestario) {
        Query query = em.createQuery("SELECT c.idPrestamo,  c.fechaprestamo, c.fecharetorno, c.horaprestamo, c.idUsuarios.usuario, c.statusprestamo , c.idUsuarios.idUsuarios, c.idPrestario.idPrestario FROM TblPrestamo c "
                + "WHERE c.idPrestario.idPrestario = :id AND c.statusprestamo != 3");
        query.setParameter("id", idPrestario);

        List<PresDTO> list = new ArrayList<>();

        List obj = query.getResultList();

        if (obj != null) {
            for (Iterator it = obj.iterator(); it.hasNext();) {
                Object[] object = (Object[]) it.next();
                PresDTO temp = new PresDTO();
                temp.setIdPrestamo((Integer) object[0]);
                temp.setFechaprestamo((String) object[1]);
                temp.setFecharetorno((String) object[2]);
                temp.setHoraprestamo((String) object[3]);
                temp.setIdUsuarios((String) object[4]);
                temp.setStatusprestamo((int) object[5]);
                temp.setTblDetalleprestamoList(dtl.getDtls((int) object[0]));
                temp.setIntUsuarioId((int) object[6]);
                temp.setIdPrestario((int) object[7]);
                temp.setDetailsSize(temp.getTblDetalleprestamoList().size());
                list.add(temp);
            }
            return list;
        }

        return null;
    }

    public List<PresDTO> getLoansByFreeds(int idPrestario) {
        Query query = em.createQuery("SELECT c.idPrestamo,  c.fechaprestamo, c.fecharetorno, c.horaprestamo, c.idUsuarios.usuario, c.statusprestamo , c.idUsuarios.idUsuarios, c.idPrestario.idPrestario FROM TblPrestamo c "
                + "WHERE c.idPrestario.idPrestario = :id AND c.statusprestamo = 3");
        query.setParameter("id", idPrestario);

        List<PresDTO> list = new ArrayList<>();

        List obj = query.getResultList();

        if (obj != null) {
            for (Iterator it = obj.iterator(); it.hasNext();) {
                Object[] object = (Object[]) it.next();
                PresDTO temp = new PresDTO();
                temp.setIdPrestamo((Integer) object[0]);
                temp.setFechaprestamo((String) object[1]);
                temp.setFecharetorno((String) object[2]);
                temp.setHoraprestamo((String) object[3]);
                temp.setIdUsuarios((String) object[4]);
                temp.setStatusprestamo((int) object[5]);
                temp.setTblDetalleprestamoList(dtl.getDtls((int) object[0]));
                temp.setIntUsuarioId((int) object[6]);
                temp.setIdPrestario((int) object[7]);
                temp.setDetailsSize(temp.getTblDetalleprestamoList().size());
                list.add(temp);
            }
            return list;
        }

        return null;
    }

    public boolean updatePres(PresDTO pres) {
        TblPrestamo pr = pres.convertDTO();
        try {
            int count = 0;
            int size = pr.getTblDetalleprestamoList().size();
            for (TblDetalleprestamo dl : pr.getTblDetalleprestamoList()) {
                System.out.println("la fecha es: " + dl.getFecharetorno());
                if (!(dl.getFecharetorno() == null || dl.getFecharetorno().trim().equals(""))) {
                    count++;
                }
            }

            if (count > 0) {
                if (count >= size) {
                    System.out.println("VAMOS A PONERLO EN 3");
                    pres.setStatusprestamo(3);
                    pr.setStatusprestamo(3);
                    pr.setFecharetorno(((String[]) currentDate())[0]);
             

                } else {
                    System.out.println("VAMOS A PONERLO EN 2");
                    pres.setStatusprestamo(2);
                    pr.setStatusprestamo(2);
                }
            } else {
                System.out.println("VAMOS A PONERLO EN 1");
                pres.setStatusprestamo(1);
                pr.setStatusprestamo(1);
            }
        } catch (NullPointerException e) {

        }

        ml.setStock(pres.getTblDetalleprestamoList()); //mejorar
        System.out.println("el estatus que se va a poner es: " + pr.getStatusprestamo());
        try {
            em.merge(pr);
            return true;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return false;
        }
    }

    public String[] currentDate() {
        String[] datos = new String[2];

        String DATE_FORMAT_NOW = "yyyy/MM/dd";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        String stringDate = sdf.format(date);
        datos[0] = stringDate;
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date 
        calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        //calendar.get(Calendar.HOUR);        // gets hour in 12h format
        calendar.get(Calendar.MONTH);

        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        String currentTime = hora.format(date.getTime());
        datos[1] = currentTime;
        System.out.println("HORA: " + currentTime);
        System.out.println("hora: " + System.currentTimeMillis());
        System.out.println("Current Date: " + stringDate);
        //Date date2 = sdf.parse(stringDate);
        return datos;
    }

    public TblPrestamo createPres() {
        TblPrestamo pr = new TblPrestamo();
        pr.setFechaprestamo(((String[]) currentDate())[0]);
        pr.setHoraprestamo(((String[]) currentDate())[1]);
        pr.setIdPrestario(pres.getUs());
        pr.setIdUsuarios(user.getUsuario());// cambiar
        pr.setStatusprestamo(1);// cambiaar
        em.persist(pr);
        em.flush();
        return pr;
    }

    public boolean updatePres(TblPrestamo pr) {
        try {
            em.merge(pr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List morosos() {

        List<TblPrestarios> list = null;

        String nombre;
        TblPrestamo objp = null;
        int id;
        try {

            Query search1 = em.createQuery("SELECT t.idPrestario FROM TblPrestamo t WHERE t.statusprestamo = :status OR t.statusprestamo = :status1");
            search1.setParameter("status", 1);
            search1.setParameter("status1", 2);
            list = search1.getResultList();
            //Iterator li=list.iterator();
            HashSet hs = new HashSet();
            // while(li.hasNext()){
            hs.addAll(list);
            list.clear();
            list.addAll(hs);

            for (int i = 0; i < list.size(); i++) {

                /// System.out.println(list.get(i));
            }
            //  }

// results = query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }

        return list;

    }
}
