/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.Tblpiezas;
import com.util.DataObject1;
import java.lang.reflect.Type;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author NORE
 */
@Stateless
public class TblpiezasFacade extends AbstractFacade<Tblpiezas> {

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblpiezasFacade() {
        super(Tblpiezas.class);
    }

    public int check(String cantidad, String noParte) {
        TypedQuery<TblMaterial> query = em.createQuery("SELECT c FROM TblMaterial c WHERE c.noParte = :noPart", TblMaterial.class);
        query.setParameter("noPart", noParte.toLowerCase());
        TblMaterial res = query.getSingleResult();
        int quantity = res.getTotal();
        int request = Integer.parseInt(cantidad);
        int diff = 0;
        System.out.println("#### EL TOTAL: " + quantity);
        System.out.println("#### EL REQUEST: " + request);
        if (quantity == request) {
            System.out.println("es igual");
            return 0;
        } else {
            return quantity - request;
        }

    }

    public void create(String nombre, String noParte, int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            //  System.out.println("Nombre de la pz: " + nombre);
            //  System.out.println("Numero de parte: " + noParte);
            Tblpiezas temp = new Tblpiezas();
            temp.setNombre(nombre);
            temp.setNoPartemodelo(noParte);
            // temp.setTblPiezasid(this.count() + 1);
            em.persist(temp);
        }
        //  em.flush();
    }

    public List<Tblpiezas> findItems(String noParte) {
        //System.out.println("noParte findItems: " + noParte);
        TypedQuery<Tblpiezas> query = em.createQuery("SELECT c FROM Tblpiezas c WHERE c.noPartemodelo = :part", Tblpiezas.class);
        query.setParameter("part", noParte);

        List<Tblpiezas> res = query.getResultList();
        return res;

    }

    public List<Tblpiezas> findItems(String noParte, boolean b) {
        TypedQuery<Tblpiezas> query = em.createQuery("SELECT c FROM Tblpiezas c WHERE c.noPartemodelo = :part AND c.estatus = :fls", Tblpiezas.class);
        query.setParameter("part", noParte);
        query.setParameter("fls", b);
        List<Tblpiezas> res = query.getResultList();
        return res;
    }

    public void setUnAvailable(String infoAdd, boolean bol) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<DataObject1>>() {
        }.getType();
        if (infoAdd != null) {
            List<DataObject1> list = new Gson().fromJson(infoAdd, type);
            if (list.size() > 0) {
                for (DataObject1 list1 : list) {
                    TypedQuery<Tblpiezas> query = em.createQuery("SELECT c FROM Tblpiezas c WHERE c.idtblpiezas = :id", Tblpiezas.class);
                    query.setParameter("id", list1.getId());
                    Tblpiezas res = query.getSingleResult();
                    res.setEstatus(bol);
                    edit(res);
                }
            }
        }
        //query
    }

    public void saveChanges(Tblpiezas pz) {
        if (em.contains(pz)) {
            System.out.println(" I WILL SAVE YOUR CHANGES");
        }
    }

}
