/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.Subfamilias;
import com.server.entity.beans.TblArea;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblTipomaterial;
import com.util.DetailDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author NORE
 */
@Stateless
public class TblMaterialFacade extends AbstractFacade<TblMaterial> {


    @PersistenceContext(unitName = "webAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMaterialFacade() {
        super(TblMaterial.class);
    }

    public List<TblMaterial> autoQueryName(String patron) {

        TypedQuery<TblMaterial> query = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial(c.idtblMaterial, c.noParte,c.nombre) FROM TblMaterial c WHERE c.nombre LIKE :patron", TblMaterial.class);
        query.setParameter("patron", patron.toLowerCase() + "%");

        List<TblMaterial> res = query.getResultList();
        res.add(new TblMaterial(0, patron, "Buscar: "));

        return res;

    }

    public List<TblMaterial> autoQueryPartNumber(String patron) {
        //
        TypedQuery<TblMaterial> query = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial(c.noParte,c.nombre) FROM TblMaterial c WHERE c.noParte LIKE :patron", TblMaterial.class);
        query.setParameter("patron", patron.toLowerCase() + "%");

        List<TblMaterial> res = query.getResultList();

        return res;
    }

    public List<TblMaterial> find(String search) {// lista normal por numero de parte
        //c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam FROM TblMaterial c WHERE c.noParte = :part");
        res.setParameter("part", search);

        List<TblMaterial> data = new ArrayList<>();

        List list = res.getResultList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Object[] object = (Object[]) it.next();
            TblMaterial temp = new TblMaterial();
            temp.setIdtblMaterial((Integer) object[0]);
            temp.setNoParte((String) (object[1]));
            temp.setNombre((String) (object[2]));
            temp.setDescripcion((String) (object[3]));
            temp.setStock((Integer) (object[4]));
            temp.setCosto((Long) (object[5]));
            temp.setImagen((String) (object[6]));
            temp.setIdArea(new TblArea((Integer) (object[7])));
            temp.setIdTipomaterial(new TblTipomaterial((Integer) (object[8])));
            temp.setSubFamiliasidsubFam(new Subfamilias((Integer) (object[9])));

            data.add(temp);
        }
        return data;
    }

    public List<TblMaterial> find(String patronName, boolean obj) {// lista por patron nombre
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam FROM TblMaterial c WHERE c.nombre LIKE  :part");
        res.setParameter("part", patronName.toLowerCase() + "%");

        List<TblMaterial> data = new ArrayList<>();

        List list = res.getResultList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Object[] object = (Object[]) it.next();
            TblMaterial temp = new TblMaterial();
            temp.setIdtblMaterial((Integer) object[0]);
            temp.setNoParte((String) (object[1]));
            temp.setNombre((String) (object[2]));
            temp.setDescripcion((String) (object[3]));
            temp.setStock((Integer) (object[4]));
            temp.setCosto((Long) (object[5]));
            temp.setImagen((String) (object[6]));
            temp.setIdArea(new TblArea((Integer) (object[7])));
            temp.setIdTipomaterial(new TblTipomaterial((Integer) (object[8])));
            temp.setSubFamiliasidsubFam(new Subfamilias((Integer) (object[9])));

            data.add(temp);
        }

        return data;
    }

    public boolean mergeMtlFromPres(TblMaterial mtl) {
        em.merge(mtl);
        em.flush();
        return false;
    }

    public boolean setStock(List<DetailDTO> dtl) {
        for (DetailDTO detailDTO : dtl) {
            //NEW com.server.entity.beans.TblMaterial(c.idtblMaterial, c.stock ) 
            Query query = em.createQuery("SELECT c.idtblMaterial, c.stock, c.idTipomaterial.idTipomaterial, c.subFamiliasidsubFam.idsubFam, c.idArea.idArea, c.costo, c.noParte, c.descripcion, c.imagen, c.nombre"
                    + "    FROM TblMaterial c WHERE c.idtblMaterial = :id ");
            query.setParameter("id", detailDTO.getIdMaterial());

            Object[] res = (Object[]) query.getSingleResult();
            
            TblMaterial temp = new TblMaterial();
            temp.setIdtblMaterial((Integer) res[0]);
            temp.setStock((Integer) res[1] + detailDTO.getCantidad());
            temp.setIdTipomaterial(new TblTipomaterial((Integer) res[2]));
            temp.setSubFamiliasidsubFam(new Subfamilias((Integer) res[3]));
            temp.setIdArea(new TblArea((Integer) res[4]));
            
            temp.setCosto((Long) res[5]);
            temp.setNoParte((String) res[6]);
            temp.setDescripcion((String) res[7]);
            temp.setImagen((String) res[8]);
            temp.setNombre((String) res[9]);
            
            this.edit(temp);
        }
        em.flush();
        return false;
    }
}
