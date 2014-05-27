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

        TypedQuery<TblMaterial> query = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial( c.noParte,c.nombre) FROM TblMaterial c WHERE c.nombre LIKE :patron", TblMaterial.class);
        query.setParameter("patron", patron.toLowerCase() + "%");

        List<TblMaterial> res = query.getResultList();
        res.add(new TblMaterial( patron, "Buscar: "));

        return res;

    }

    public List<TblMaterial> autoQueryPartNumber(String patron) {
        //
        TypedQuery<TblMaterial> query = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial(c.noParte,c.nombre) FROM TblMaterial c WHERE c.noParte LIKE :patron", TblMaterial.class);
        query.setParameter("patron", patron.toLowerCase() + "%");

        List<TblMaterial> res = query.getResultList();

        return res;
    }

    public List<TblMaterial> find(String search) {// lista normal por numero de parte //ESTOS NO
        //c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam,  c.idArea.descripcion, c.idTipomaterial.descripcion, "
                + "c.subFamiliasidsubFam.nombre  FROM TblMaterial c WHERE c.noParte = :part");
        res.setParameter("part", search);

        List<TblMaterial> data = mtlResults(res);
        return data;
    }

    public List<TblMaterial> find(String patronName, boolean obj) {// lista por patron nombre // ESTOS NO
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, "
                + "c.subFamiliasidsubFam.nombre FROM TblMaterial c WHERE c.nombre LIKE  :part");
        res.setParameter("part", patronName.toLowerCase() + "%");

        List<TblMaterial> data = mtlResults(res);

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

    public List<TblMaterial> catalogFindByArea(int id) {
        Query query = em.createQuery("SELECT  c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam, c.idArea.descripcion, c.idTipomaterial.descripcion, "
                + "c.subFamiliasidsubFam.nombre FROM TblMaterial c WHERE c.idArea.idArea = :id");
        query.setParameter("id", id);

        List<TblMaterial> data = mtlResults(query);

        return data;

    }

    public List<TblMaterial> catalogFindByType(int id) {
        Query query = em.createQuery("SELECT  c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam, c.idArea.descripcion, c.idTipomaterial.descripcion, "
                + "c.subFamiliasidsubFam.nombre FROM TblMaterial c WHERE c.idTipomaterial.idTipomaterial = :id");
        query.setParameter("id", id);
        List<TblMaterial> data = mtlResults(query);
        return data;
    }

    public List<TblMaterial> catalogFindBySubFam(int id) {
        Query query = em.createQuery("SELECT  c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea,"
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam, c.idArea.descripcion, c.idTipomaterial.descripcion,"
                + "c.subFamiliasidsubFam.nombre FROM TblMaterial c WHERE c.subFamiliasidsubFam.idsubFam = :id");
        query.setParameter("id", id);
        List<TblMaterial> data = mtlResults(query);
        return data;
    }

    private List<TblMaterial> mtlResults(Query query) {
        List<TblMaterial> data = new ArrayList<>();
        List list = query.getResultList();
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

            TblArea area = new TblArea((Integer) (object[7]));
            area.setDescripcion((String) object[10]);
            temp.setIdArea(area);

            TblTipomaterial tipo = new TblTipomaterial((Integer) (object[8]));
            tipo.setDescripcion((String) object[11]);
            temp.setIdTipomaterial(tipo);

            Subfamilias sub = new Subfamilias((Integer) (object[9]));
            sub.setNombre((String) object[12]);
            temp.setSubFamiliasidsubFam(sub);
            data.add(temp);
        }
        return data;
    }

    public TblMaterial getBasicInfo(String noParte) {
        Query query = em.createQuery("SELECT  c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam, c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre  FROM TblMaterial c WHERE c.noParte = :noParte");
        query.setParameter("noParte", noParte);

        Object[] object = (Object[]) query.getSingleResult();
        TblMaterial temp = new TblMaterial();
        temp.setIdtblMaterial((Integer) object[0]);
        temp.setNoParte((String) (object[1]));
        temp.setNombre((String) (object[2]));
        temp.setDescripcion((String) (object[3]));
        temp.setStock((Integer) (object[4]));
        temp.setCosto((Long) (object[5]));
        temp.setImagen((String) (object[6]));

        TblArea area = new TblArea((Integer) (object[7]));
        area.setDescripcion((String) object[10]);
        temp.setIdArea(area);

        TblTipomaterial tipo = new TblTipomaterial((Integer) (object[8]));
        tipo.setDescripcion((String) object[11]);
        temp.setIdTipomaterial(tipo);

        Subfamilias sub = new Subfamilias((Integer) (object[9]));
        sub.setNombre((String) object[12]);
        temp.setSubFamiliasidsubFam(sub);

        return temp;
    }

    public List<TblMaterial> catalogFindBySubFam(int id, String patronName) {
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre FROM TblMaterial c WHERE c.nombre LIKE  :part AND c.subFamiliasidsubFam.idsubFam = :id");
        res.setParameter("part", patronName.toLowerCase() + "%");
        res.setParameter("id", id);
        List<TblMaterial> data = mtlResults(res);

        return data;

    }

    public List<TblMaterial> catalogFindByType(int id, String patronName) {
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre FROM TblMaterial c WHERE c.nombre LIKE  :part AND c.idTipomaterial.idTipomaterial = :id");
        res.setParameter("part", patronName.toLowerCase() + "%");
        res.setParameter("id", id);
        List<TblMaterial> data = mtlResults(res);

        return data;

    }
    public List<TblMaterial> listafull(){
    List <TblMaterial> lista=null;
  
       
     try {

           TypedQuery<TblMaterial> search = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial(u.noParte, u.nombre, u.descripcion, u.stock) FROM TblMaterial u", TblMaterial.class);    
        
      lista=search.getResultList();
System.out.println(lista);
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }
return lista;
       
    
    }
}
