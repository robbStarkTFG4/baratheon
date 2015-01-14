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
import com.server.entity.beans.TblUsuarios;
import com.util.DetailDTO;
import com.util.PresDTO;
import java.text.ParseException;
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
import javax.persistence.TypedQuery;

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

    @EJB
    TblPrestariosFacade deud;

    @Inject
    BeanUsuarios beanUs;

    private final String inquerys = "c.idPrestamo,  c.fechaprestamo, c.fecharetorno, c.horaprestamo, c.idUsuarios.usuario, c.statusprestamo , c.idUsuarios.idUsuarios, c.idPrestario.idPrestario, c.fechaSolicitud, c.fechaVencimiento ";

    // private final String inquerys2 = "c.idPrestamo, c.fecharetorno, c.statusprestamo , c.idPrestario.idPrestario, c.fechaSolicitud, c.fechaVencimiento ";
    @PersistenceContext(unitName = "almacenPU")
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
        Query query = em.createQuery("SELECT " + inquerys + " FROM TblPrestamo c "
                + "WHERE c.idPrestario.idPrestario = :id AND c.statusprestamo != 3 AND c.statusprestamo !=0");
        query.setParameter("id", idPrestario);

        return finTheInquerys(query);
    }

    public List<PresDTO> getLoansByFreeds(int idPrestario) {
        Query query = em.createQuery("SELECT " + inquerys + " FROM TblPrestamo c "
                + "WHERE c.idPrestario.idPrestario = :id AND c.statusprestamo = 3");
        query.setParameter("id", idPrestario);

        return finTheInquerys(query);
    }

    public boolean updatePres(PresDTO pres, List<PresDTO> list, TblPrestarios prestario) throws ParseException {
        //  TblPrestamo pr = pres.convertDTO(99);
        TypedQuery<TblPrestamo> query = em.createQuery("SELECT c FROM TblPrestamo c WHERE c.idPrestamo = :idPrestamo", TblPrestamo.class);
        query.setParameter("idPrestamo", pres.getIdPrestamo());
        TblPrestamo pr = query.getSingleResult();
        pr.getTblDetalleprestamoList().size();
        //pr.getTblDetalleprestamoList().clear();
        pres.convertDTO2(0, pr);
        try {
            int count = 0;
            int size = pr.getTblDetalleprestamoList().size();
            for (TblDetalleprestamo dl : pr.getTblDetalleprestamoList()) {
                System.out.println("la fecha es: " + dl.getFecharetorno());
                //   if (!(dl.getFecharetorno() == null || dl.getFecharetorno().trim().equals(""))) {
                if (dl.getCantidad() == dl.getRegresados()) {
                    count++;
                }
            }

            if (count > 0) {
                if (count >= size) {

                    if (pr.getStatusprestamo() == 4) {
                        System.out.println("PARTE BUG");
                        deud.enable(prestario.getIdPrestario());
                    }

                    System.out.println("VAMOS A PONERLO EN 3");
                    pres.setStatusprestamo(3);
                    pr.setStatusprestamo(3);

                    Date dat = new Date();

                    Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
                    calendar.setTime(dat);   // assigns calendar to given date 
                    calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
                    //calendar.get(Calendar.HOUR);        // gets hour in 12h format
                    calendar.get(Calendar.MONTH);

                    pr.setFecharetorno(dat);

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
            this.edit(pr);
            return true;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return false;
        }

    }

    public void updatInquery(PresDTO pres, TblUsuarios us) throws ParseException {
        TblPrestamo pr = pres.convertDTO(PresDTO.FECHA_APROBACION, null);
        //pr.setIdUsuarios(us);
        ml.aplyChange(pr.getTblDetalleprestamoList());
        //  pr.setHoraprestamo((String) currentDate()[1]);

        TblPrestamo res = getPresi(pr.getIdPrestamo());
        res.setFechaprestamo(pr.getFechaprestamo());
        res.setFechaVencimiento(pr.getFechaVencimiento());
        res.setHoraprestamo((String) currentDate()[1]);
        res.setIdUsuarios(us);
        res.setStatusprestamo(1);
        res.getTblDetalleprestamoList().clear();
        res.setTblDetalleprestamoList(pr.getTblDetalleprestamoList());
        pr.setStatusprestamo(1);
        this.edit(res);
    }

    private TblPrestamo getPresi(Integer id) {
        TypedQuery<TblPrestamo> query = em.createQuery("SELECT c FROM TblPrestamo c WHERE c.idPrestamo = :ids", TblPrestamo.class);
        query.setParameter("ids", id);
        return query.getSingleResult();
    }

    public String processDate(Date date) {
        String DATE_FORMAT_NOW = "yyyy/MM/dd";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        String stringDate = sdf.format(date);
        return stringDate;
    }

    public Object[] currentDate() {//fsdfs
        Object[] datos = new Object[2];

        String DATE_FORMAT_NOW = "yyyy/MM/dd";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        String stringDate = sdf.format(date);
        datos[0] = stringDate;
        String currentTime = setHour(date); // creates a new calendar instance
        datos[1] = currentTime;
        System.out.println("HORA: " + currentTime);
        System.out.println("hora: " + System.currentTimeMillis());
        System.out.println("Current Date: " + stringDate);
        //Date date2 = sdf.parse(stringDate);
        return datos;
    }

    public TblPrestamo createPres(TblPrestarios pres) {
        TblPrestamo pr = new TblPrestamo();

        Date dat = new Date();

        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(dat);   // assigns calendar to given date 
        calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        //calendar.get(Calendar.HOUR);        // gets hour in 12h format
        calendar.get(Calendar.MONTH);

        pr.setFechaSolicitud(dat);
        // pr.setHoraprestamo((String) currentDate()[1]);
        pr.setIdPrestario(pres);
        pr.setIdUsuarios(beanUs.getUsuario());// cambiar////////////////////////////////////////dASDSADASDASDASDS AQUI ARASTRA EL USUARIO
        pr.setStatusprestamo(0);// cambiaar
        em.persist(pr);
        em.flush();
        return pr;
    }

    public boolean updatePres(TblPrestamo pr) {
        try {
            pr.setStatusprestamo(0);
            this.edit(pr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<PresDTO> getInquerys(Integer idPrestario) {
        TypedQuery<TblPrestamo> query = em.createQuery("SELECT c FROM TblPrestamo c "
                + "WHERE c.idPrestario.idPrestario = :id AND c.statusprestamo = 0", TblPrestamo.class);
        query.setParameter("id", idPrestario);

        return finTheInquerys2(query);
    }

    private List<PresDTO> finTheInquerys(Query query) {
        List<PresDTO> list = new ArrayList<>();

        List obj = query.getResultList();

        if (obj != null) {
            for (Iterator it = obj.iterator(); it.hasNext();) {
                Object[] object = (Object[]) it.next();
                PresDTO temp = new PresDTO();
                temp.setIdPrestamo((Integer) object[0]);

                if (object[1] != null) {

                    temp.setFechaprestamo(processDate((Date) object[1]));
                    //  temp.setFechaprestamo((((Date) object[1])).toString());
                }

                Date date = (Date) object[2];
                if (date != null) {
                    temp.setFecharetorno(processDate(date));
                }

                temp.setHoraprestamo((String) object[3]);
                temp.setIdUsuarios((String) object[4]);
                temp.setStatusprestamo((int) object[5]);
                temp.setTblDetalleprestamoList(dtl.getDtls((int) object[0]));
                temp.setIntUsuarioId((int) object[6]);
                temp.setIdPrestario((int) object[7]);
                temp.setDetailsSize(temp.getTblDetalleprestamoList().size());

                if (object[8] != null) {

                    Date dat = ((Date) object[8]);

                    temp.setFechaSolicitud(processDate(dat));

                    String currentTime = setHour(dat);
                    temp.setHoraSolicitud(currentTime);
                }

                if (object[9] != null) {
                    temp.setFechaVencimiento(processDate((Date) object[9]));
                }
                list.add(temp);
            }
            return list;
        }

        return null;
    }

    private String setHour(Date dat) {
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(dat);   // assigns calendar to given date 
        calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        //calendar.get(Calendar.HOUR);        // gets hour in 12h format
        calendar.get(Calendar.MONTH);
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        String currentTime = hora.format(dat.getTime());
        return currentTime;
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

    private List<PresDTO> finTheInquerys2(Query query) {
        List<PresDTO> list = new ArrayList<>();

        List<TblPrestamo> obj = query.getResultList();

        if (obj.size() != 0) {
            //borrar fecha retorno
            //hora prestamo
            //0                      1            2
            //"c.idPrestamo,  c.fechaprestamo, c.statusprestamo ,
            //                               3                            4            
            //           c.idPrestario.idPrestario, c.fechaSolicitud";           
            for (TblPrestamo tblPrestamo : obj) {

                PresDTO temp = new PresDTO();
                temp.setIdPrestamo(tblPrestamo.getIdPrestamo());

                if (tblPrestamo.getFechaprestamo() != null) {

                    temp.setFechaprestamo(processDate((Date) tblPrestamo.getFechaprestamo()));
                    //  temp.setFechaprestamo((((Date) object[1])).toString());
                }

                temp.setStatusprestamo(tblPrestamo.getStatusprestamo());
                temp.setTblDetalleprestamoList(dtl.getDtls(tblPrestamo.getIdPrestamo()));

                temp.setIdPrestario(tblPrestamo.getIdPrestario().getIdPrestario());
                temp.setDetailsSize(temp.getTblDetalleprestamoList().size());

                if (tblPrestamo.getFechaSolicitud() != null) {

                    Date dat = (tblPrestamo.getFechaSolicitud());

                    temp.setFechaSolicitud(processDate(dat));

                    String currentTime = setHour(dat);
                    temp.setHoraSolicitud(currentTime);
                }

                list.add(temp);
            }
            return list;
        }

        return null;
    }
}
