/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.stateless;

import com.server.entity.Subfamilias;
import com.server.entity.TblArea;
import com.server.entity.TblMaterial;
import com.server.entity.TblTipomaterial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NORE
 */
@Stateless
public class TblMaterialFacade extends AbstractFacade<TblMaterial> {

    @PersistenceContext(unitName = "MtlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMaterialFacade() {
        super(TblMaterial.class);
    }

    public boolean create(String nombre, String noParte, String descripcion, String stock, String costo, String imagen, Subfamilias sub, TblTipomaterial fam, TblArea area) {
        //stock a int  ----- costo a decimal
        boolean estado = false;
        int cantidad = Integer.parseInt(stock);
        Long cash = Long.parseLong(costo);

        TblMaterial tbl = new TblMaterial();
        tbl.setCosto(cash);
        tbl.setDescripcion(descripcion);
        tbl.setIdArea(area);
        tbl.setIdTipomaterial(fam);
        tbl.setImagen(imagen);
        tbl.setNoParte(noParte);
        tbl.setNombre(nombre);
        tbl.setStock(cantidad);
        tbl.setSubFamiliasidsubFam(sub);
        
        try {
            this.create(tbl);
            estado = true;
        } catch (Exception e) {

        }

        return estado;
    }
    
    public boolean isAvailable(String noParte){
        System.out.println("Holaaa uno doss tres: "+noParte);
        Query query= em.createQuery("SELECT NEW com.server.entity.TblMaterial(c.idtblMaterial) FROM TblMaterial c WHERE c.noParte = :number");
        query.setParameter("number", noParte);
        
        return !query.getResultList().isEmpty();
    }
}
