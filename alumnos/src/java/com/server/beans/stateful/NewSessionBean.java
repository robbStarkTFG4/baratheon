/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.stateful;

import com.client.named.Prestamos;
import com.server.beans.staless.AbstractFacade;
import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.staless.TblPrestamoFacade;
import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblPrestarios;
import com.util.MtlDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORE
 */
@Stateful
public class NewSessionBean {

    @EJB
    TblPrestamoFacade pres;

    @EJB
    TblMaterialFacade material;

    private final int idPrestario = 0;
    private final int idUsuario = 0;
    private List<TblMaterial> mtl;
    private List<TblDetalleprestamo> dtl;
    private List<MtlDTO> data;

    @PersistenceContext(unitName = "alumnosPU")
    private EntityManager em;

    @PostConstruct
    private void load() {
        mtl = new ArrayList<>();
        dtl = new ArrayList<>();
        data = new ArrayList<>();
    }

    public void init() {// Objeto usuario con cosas basicas principalmente id, igual con el prestario.
    }

    public boolean verify() { //verifica que exista un usuario instanciado "que no sea 0".
        return false;
    }

    public boolean add(TblMaterial tbl, int quantity) { /// al agregar revisar si hay stock REGRESAR BOOLEANO

        if (!(tbl.getStock() >= quantity)) {
            return false;
        }

        if (!mtl.contains(tbl)) {
            mtl.add(tbl);

            MtlDTO mlDTO = new MtlDTO(tbl.getIdtblMaterial(), tbl.getNoParte(), tbl.getNombre(), quantity, tbl.getStock());
            if (tbl.getInventariable() != null) {
                mlDTO.setInventariable(tbl.getInventariable());
            }
            data.add(mlDTO);
            return true;
        } else {
            for (MtlDTO ml : data) {
                if (ml.getNoParte().equals(tbl.getNoParte())) {
                    int add = ml.getCantidad() + quantity;
                    if (ml.getStock() >= add) {
                        ml.setCantidad(add);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;

    }

    @Remove
    public void remove() {

    }

    public List<MtlDTO> getList() {
        return data;
    }

    public void modify() {

    }

    public void removeItem(MtlDTO mt) {
        TblMaterial temp = null;

        for (TblMaterial tblMaterial : mtl) {
            if (tblMaterial.getNoParte().equals(mt.getNoParte())) {
                temp = tblMaterial;
            }
        }
        if (temp != null) {
            mtl.remove(temp);
            data.remove(mt);
        }
    }

    public void clearList() {
        mtl.clear();
        data.clear();
    }

    public boolean persistLoan(TblPrestarios pro) {//cDASDASDASDASDAS AGREGAR EL USUARIO COMO PARAMETRO DEL METODO Y METERLO EN "1"
        TblPrestamo pr = pres.createPres(pro); //1
        Map<String, Integer> quantity = new HashMap<>();
        for (MtlDTO ml : data) {
            TblDetalleprestamo temp = new TblDetalleprestamo();
            temp.setCantidad(ml.getCantidad());

            temp.setIdMaterial(new TblMaterial(ml.getIdMaterial()));

            temp.setIdPrestamo(pr);
            temp.setInvi(ml.isInventariable());

            dtl.add(temp);

            quantity.put(ml.getNoParte(), ml.getCantidad());
        }
        pr.setTblDetalleprestamoList(dtl);

        if (pres.updatePres(pr)) {
            clearList();

            return true;
        } else {
            return false;
        }
    }

}
