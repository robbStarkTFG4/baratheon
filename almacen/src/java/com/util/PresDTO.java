/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblUsuarios;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author NORE
 */
public class PresDTO implements Serializable {

    //SELECT c.idPrestamo, c.fechaprestamo, c.horaprestamo, c.idUsuarios.usuario, c.statusprestamo
    private Integer idPrestamo;//*
    private String fechaprestamo;//*
    private String fecharetorno;//*
    private String fechaSolicitud;
    private String fechaVencimiento;
    private String horaprestamo;//*
    private String idUsuarios;
    private int statusprestamo;//*
    private List<DetailDTO> tblDetalleprestamoList;
    private int detailsSize;
    private int detailsFreed;
    private int intUsuarioId;//*
    private int idPrestario;
    private String horaSolicitud;
    private Date date10;  // due date
    private boolean dateAdded = false;
    
    public static final int FECHA_ENTREGA = 13432;
    public static final int FECHA_APROBACION = 432421;
    
    public PresDTO() {
    }
    
    public TblPrestamo convertDTO(int stage, TblPrestamo tbl) throws ParseException {
        if (tbl == null) {
            tbl = new TblPrestamo();
            tbl.setIdPrestamo(this.getIdPrestamo());
            tbl.setIdUsuarios(new TblUsuarios(this.getIntUsuarioId()));
        }

        //tbl.setIdPrestamo(this.getIdPrestamo());
        String DATE_FORMAT_NOW = "yyyy/MM/dd";
        
        switch (stage) {
            // fecha solicitud prestamo "fecha solicitud"  //ENTREGA
            case FECHA_ENTREGA:
                tbl.setFechaSolicitud(new Date());
                break;
            //fecha apropacion "fecha prestamo" y fecha vencimiento
            case FECHA_APROBACION:
                // Date datePrestamo = new SimpleDateFormat(DATE_FORMAT_NOW).parse(this.getFechaprestamo());
                Date dat = new Date();
                
                Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
                calendar.setTime(dat);   // assigns calendar to given date 
                calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
                calendar.get(Calendar.HOUR);        // gets hour in 12h format
                calendar.get(Calendar.MONTH);
                
                tbl.setFechaprestamo(dat);
                tbl.setFechaVencimiento(date10);
                //tbl.setHoraprestamo(this.getHoraprestamo());
                break;
            
            default:
                System.out.println("CASO DE FECHA NO VALIDO");
                break;
            
        }

        // tbl.setIdUsuarios(new TblUsuarios(this.getIntUsuarioId()));
        List<TblDetalleprestamo> list = new ArrayList<>();
        //  int status=0;
        for (DetailDTO detailDTO : this.getTblDetalleprestamoList()) {
            System.out.println("posible nulo: " + detailDTO.getNombre());
            //   status=verifyStatus(detailDTO);
            list.add(detailDTO.convertDTO());
        }
        
        tbl.setTblDetalleprestamoList(list);
        
        return tbl;
    }
    
    public TblPrestamo convertDTO2(int stage, TblPrestamo tbl) throws ParseException {
        
        List<TblDetalleprestamo> list = tbl.getTblDetalleprestamoList();
        
        for (DetailDTO detailDTO : this.getTblDetalleprestamoList()) {
            System.out.println("posible nulo: " + detailDTO.getNombre());
            String part = detailDTO.getNoParte();
            for (TblDetalleprestamo list1 : list) {
                if (part.equals(list1.getIdMaterial().getNoParte())) {
                    list1.setRegresados(detailDTO.getRegresados());
                    list1.setFecharetorno(detailDTO.getFecharetorno());
                    list1.setHoraretorno(detailDTO.getHoraretorno());
                }
            }
          
        }
        
       // tbl.setTblDetalleprestamoList(list);
        //  tbl.setIdPrestario(new TblPrestarios(this.getIdPrestario()));
        return tbl;
    }
    
    public Integer getIdPrestamo() {
        return idPrestamo;
    }
    
    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    
    public String getFechaprestamo() {
        return fechaprestamo;
    }
    
    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }
    
    public String getFecharetorno() {
        return fecharetorno;
    }
    
    public void setFecharetorno(String fecharetorno) {
        this.fecharetorno = fecharetorno;
    }
    
    public int getStatusprestamo() {
        return statusprestamo;
    }
    
    public void setStatusprestamo(int statusprestamo) {
        this.statusprestamo = statusprestamo;
    }
    
    public String getHoraprestamo() {
        return horaprestamo;
    }
    
    public void setHoraprestamo(String horaprestamo) {
        this.horaprestamo = horaprestamo;
    }
    
    public List<DetailDTO> getTblDetalleprestamoList() {
        return tblDetalleprestamoList;
    }
    
    public void setTblDetalleprestamoList(List<DetailDTO> tblDetalleprestamoList) {
        this.tblDetalleprestamoList = tblDetalleprestamoList;
    }
    
    public String getIdUsuarios() {
        return idUsuarios;
    }
    
    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    
    public int getDetailsSize() {
        return detailsSize;
    }
    
    public void setDetailsSize(int detailsSize) {
        this.detailsSize = detailsSize;
    }
    
    public int getDetailsFreed() {
        return detailsFreed;
    }
    
    public void setDetailsFreed(int detailsFreed) {
        this.detailsFreed = detailsFreed;
    }
    
    public int getIntUsuarioId() {
        return intUsuarioId;
    }
    
    public void setIntUsuarioId(int intUsuarioId) {
        this.intUsuarioId = intUsuarioId;
    }
    
    public int getIdPrestario() {
        return idPrestario;
    }
    
    public void setIdPrestario(int idPrestario) {
        this.idPrestario = idPrestario;
    }

    /* private int verifyStatus(DetailDTO detailDTO) {
     if(detailDTO.getHoraretorno()!=null){
     if (!detailDTO.getHoraretorno().isEmpty()) {
     this.detailsFreed++;
     if (this.detailsFreed == this.detailsSize) {
     System.out.println("**************valor detailsFreed " + this.detailsFreed + " tamaño: " + this.detailsSize);
     return 3;
     }
     return 2;

     }else{
     if(this.detailsFreed!=0)this.detailsFreed--;
     }
     return 1;
     }
     return 1;
     }*/
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public String getHoraSolicitud() {
        return horaSolicitud;
    }
    
    public void setHoraSolicitud(String horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }
    
    public Date getDate10() {
        return date10;
    }
    
    public void setDate10(Date date10) {
        this.date10 = date10;
    }
    
    public boolean isDateAdded() {
        return dateAdded;
    }
    
    public void setDateAdded(boolean dateAdded) {
        this.dateAdded = dateAdded;
    }
    
}
