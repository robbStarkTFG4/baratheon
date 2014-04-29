/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.stateful;

import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblMaterial;
import com.util.MtlDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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

    private final int idPrestario = 0;
    private final int idUsuario = 0;
    private List<TblMaterial> mtl;
    private List<TblDetalleprestamo> dtl;
    private List<MtlDTO> data;

    @PostConstruct
    private void load() {
        mtl = new ArrayList<>();
        dtl = new ArrayList<>();
        data = new ArrayList<>();
    }

    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;

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
            data.add(new MtlDTO(tbl.getNoParte(), tbl.getNombre(), quantity, tbl.getStock()));
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

    public boolean persistLoan() {//crear el objeto de prestamo y los objetos de detalles y persistirlos  ,  navegar a la pag de instanciar prestario.
        return false;
    }
}
