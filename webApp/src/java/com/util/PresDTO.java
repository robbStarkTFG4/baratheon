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
import java.util.ArrayList;
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
    private String horaprestamo;//*
    private String idUsuarios;
    private int statusprestamo;//*
    private List<DetailDTO> tblDetalleprestamoList;
    private int detailsSize ;
    private int detailsFreed ;
    private int intUsuarioId ;//*
    private int idPrestario  ;

    public PresDTO() {
    }

    public TblPrestamo convertDTO() {
        TblPrestamo tbl = new TblPrestamo();

        tbl.setIdPrestamo(this.getIdPrestamo());
        tbl.setFechaprestamo(this.getFechaprestamo());
        tbl.setFecharetorno(this.getFecharetorno());
        tbl.setHoraprestamo(this.getHoraprestamo());

        tbl.setIdUsuarios(new TblUsuarios(this.getIntUsuarioId()));

        List<TblDetalleprestamo> list = new ArrayList<>();
     //  int status=0;
        for (DetailDTO detailDTO : this.getTblDetalleprestamoList()) {
            System.out.println("posible nulo: " + detailDTO.getNombre());
         //   status=verifyStatus(detailDTO);
            list.add(detailDTO.convertDTO());
        }
       /* this.detailsFreed=0;
        for (DetailDTO dtls : this.getTblDetalleprestamoList()) {
            if(!dtls.getHoraretorno().isEmpty()){
                status=2;
                this.detailsFreed++;
            }
        }*/
        
     //   if(this.detailsFreed==this.detailsSize)status=3;
     //   this.setStatusprestamo(status);
       // tbl.setStatusprestamo(status);
        tbl.setTblDetalleprestamoList(list);
        tbl.setIdPrestario(new TblPrestarios(this.getIdPrestario()));
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

}
