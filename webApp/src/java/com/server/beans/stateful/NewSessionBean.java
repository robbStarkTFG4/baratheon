/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.stateful;

import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.staless.TblPrestamoFacade;
import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestamo;
import com.util.MtlDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
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

    private List<TblMaterial> mtl;
    private List<TblDetalleprestamo> dtl;
    private List<MtlDTO> data;

    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;

    @PostConstruct
    private void load() {
        mtl = new ArrayList<>();
        dtl = new ArrayList<>();
        data = new ArrayList<>();
    }

 

    public boolean add(TblMaterial tbl, int quantity) { /// al agregar revisar si hay stock REGRESAR BOOLEANO

        if (!(tbl.getStock() >= quantity)) {
            return false;
        }

        if (!mtl.contains(tbl)) {
            mtl.add(tbl);
            data.add(new MtlDTO(tbl.getIdtblMaterial(), tbl.getNoParte(), tbl.getNombre(), quantity, tbl.getStock()));
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
        dtl.clear();
        mtl.clear();
        data.clear();
    }

    public boolean persistLoan() {//crear el objeto de prestamo y los objetos de detalles y persistirlos  ,  navegar a la pag de instanciar prestario.

        TblPrestamo pr = pres.createPres();
        Map<String, Integer> quantity = new HashMap<>();
        for (MtlDTO ml : data) {
            TblDetalleprestamo temp = new TblDetalleprestamo();
            temp.setCantidad(ml.getCantidad());

            temp.setIdMaterial(new TblMaterial(ml.getIdMaterial()));

            temp.setIdPrestamo(pr);
            dtl.add(temp);

            quantity.put(ml.getNoParte(), ml.getCantidad());
        }
        pr.setTblDetalleprestamoList(dtl);

        for (TblMaterial tblMaterial : mtl) {
            int newStock = tblMaterial.getStock() - quantity.get(tblMaterial.getNoParte());
            tblMaterial.setStock(newStock);
             material.mergeMtlFromPres(tblMaterial);
        }

        if (pres.updatePres(pr)) {
            clearList();
            return true;
        } else {
            return false;
        }

    }
}
