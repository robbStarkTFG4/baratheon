/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.Almacen;
import com.server.entity.beans.Subfamilias;
import com.server.entity.beans.TblArea;
import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblTipomaterial;
import com.util.DetailDTO;
import java.util.ArrayList;
import java.util.Date;
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

    @PersistenceContext(unitName = "almacenPU")
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
        res.add(new TblMaterial(patron, "Buscar: "));

        return res;

    }

    public List<TblMaterial> autoQueryPartNumber(String patron) {
        //
        TypedQuery<TblMaterial> query = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial(c.noParte,c.nombre) FROM TblMaterial c WHERE c.noParte LIKE :patron", TblMaterial.class);
        query.setParameter("patron", patron.toLowerCase() + "%");

        List<TblMaterial> res = query.getResultList();
        res.add(new TblMaterial(patron, "noParte"));
        return res;
    }

    public List<TblMaterial> find(String search) {// lista normal por numero de parte //ESTOS NO              wwwwwwwwwwwwwwwwwwwwwwwwwww
        //c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam,  c.idArea.descripcion, c.idTipomaterial.descripcion, "
                + "c.subFamiliasidsubFam.nombre , c.inventariable  FROM TblMaterial c WHERE c.noParte = :part");
        res.setParameter("part", search);

        List<TblMaterial> data = mtlResults(res);
        return data;
    }

    public List<TblMaterial> find(String patronName, boolean obj) {// lista por patron nombre // ESTOS NO         wwwwwwwwwwwwwwwwwwwwwwwwwww
       /* Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
         + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, "
         + "c.subFamiliasidsubFam.nombre FROM TblMaterial c WHERE c.nombre LIKE  :part");
         res.setParameter("part", patronName.toLowerCase() + "%");

         List<TblMaterial> data = mtlResults(res);

         return data;*/
        TypedQuery<TblMaterial> query = em.createQuery("SELECT c FROM TblMaterial c WHERE  c.nombre LIKE  :part", TblMaterial.class);
        query.setParameter("part", patronName.toLowerCase() + "%");

        return query.getResultList();
    }

    public List<TblMaterial> find(String patronPartNumber, boolean obj, int x) {// llista patron # parte  wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, "
                + "c.subFamiliasidsubFam.nombre, c.inventariable   FROM TblMaterial c WHERE c.noParte LIKE  :part");
        res.setParameter("part", patronPartNumber.toLowerCase() + "%");

        List<TblMaterial> data = mtlResults(res);

        return data;
    }

    public boolean mergeMtlFromPres(TblMaterial mtl) {
        em.merge(mtl);
        em.flush();
        return false;
    }

    public boolean aplyChange(TblDetalleprestamo dl) {

        TypedQuery<TblMaterial> query = em.createQuery("SELECT c FROM TblMaterial c WHERE c.idtblMaterial = :ml", TblMaterial.class);
        query.setParameter("ml", dl.getIdMaterial().getIdtblMaterial());
        TblMaterial temp = query.getSingleResult();

        if (temp != null) {
            temp.getStock();
            System.out.println(dl);
            if (dl != null) {

                int newStock = temp.getStock() - dl.getCantidad();
                temp.setStock(newStock);
            }
            //System.out.println("CAMACHO OBESO NELVA");
            //System.out.println("stock asignado: " + newStock);
            //this.edit(temp);
        }

        // em.flush();
        return false;

    }

    public boolean setStock(List<DetailDTO> dtl) {
        for (DetailDTO detailDTO : dtl) {
            //NEW com.server.entity.beans.TblMaterial(c.idtblMaterial, c.stock ) 
            //     Query query = em.createQuery("SELECT c.idtblMaterial, c.stock, c.idTipomaterial.idTipomaterial, c.subFamiliasidsubFam.idsubFam, c.idArea.idArea, c.costo, c.noParte, c.descripcion, c.imagen, c.nombre"
            //            + "    FROM TblMaterial c WHERE c.idtblMaterial = :id ");
            //   query.setParameter("id", detailDTO.getIdMaterial());

            // Object[] res = (Object[]) query.getSingleResult();
            TypedQuery<TblMaterial> query = em.createNamedQuery("TblMaterial.findByIdtblMaterial", TblMaterial.class);
            query.setParameter("idtblMaterial", detailDTO.getIdMaterial());
            TblMaterial temp = query.getSingleResult();
            //   temp.setIdtblMaterial((Integer) res[0]);
            int oldStock = temp.getStock();
            temp.setStock(oldStock + detailDTO.getRegresados());
          //  temp.setStock((Integer) res[1] + detailDTO.getCantidad());
            //   temp.setIdTipomaterial(new TblTipomaterial((Integer) res[2]));
            //  temp.setSubFamiliasidsubFam(new Subfamilias((Integer) res[3]));
            // temp.setIdArea(new TblArea((Integer) res[4]));

            //  temp.setCosto((Long) res[5]);
            // temp.setNoParte((String) res[6]);
            //temp.setDescripcion((String) res[7]);
            //temp.setImagen((String) res[8]);
            //temp.setNombre((String) res[9]);
            this.edit(temp);
        }
        em.flush();
        return false;
    }

    public List<TblMaterial> catalogFindByArea(int id) {                //wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        Query query = em.createQuery("SELECT  c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam, c.idArea.descripcion, c.idTipomaterial.descripcion, "
                + "c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.idArea.idArea = :id");
        query.setParameter("id", id);

        List<TblMaterial> data = mtlResults(query);

        return data;

    }

    public List<TblMaterial> catalogFindByArea(Integer id, String patronName) {
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.nombre LIKE  :part AND c.idTipomaterial.tblAreaIdArea.idArea = :id");
        res.setParameter("part", patronName.toLowerCase() + "%");
        res.setParameter("id", id);
        List<TblMaterial> data = mtlResults(res);
        return data;

    }

    public List<TblMaterial> catalogFindByArea(Integer id, String patronNoParte, int x) {
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.noParte LIKE  :part AND c.idTipomaterial.tblAreaIdArea.idArea = :id");
        res.setParameter("part", patronNoParte.toLowerCase() + "%");
        res.setParameter("id", id);
        List<TblMaterial> data = mtlResults(res);
        return data;
    }

    public List<TblMaterial> catalogFindByType(int id) {    //wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        Query query = em.createQuery("SELECT  c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, "
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam, c.idArea.descripcion, c.idTipomaterial.descripcion, "
                + "c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.idTipomaterial.idTipomaterial = :id");
        query.setParameter("id", id);
        List<TblMaterial> data = mtlResults(query);
        return data;
    }

    public List<TblMaterial> catalogFindBySubFam(int id) {   //wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        Query query = em.createQuery("SELECT  c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea,"
                + "c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam, c.idArea.descripcion, c.idTipomaterial.descripcion,"
                + "c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.subFamiliasidsubFam.idsubFam = :id");
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
            temp.setInventariable((Boolean) object[13]);
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

    public List<TblMaterial> catalogFindBySubFam(int id, String patronName) {  //wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.nombre LIKE  :part AND c.subFamiliasidsubFam.idsubFam = :id");
        res.setParameter("part", patronName.toLowerCase() + "%");
        res.setParameter("id", id);
        List<TblMaterial> data = mtlResults(res);

        return data;

    }

    public List<TblMaterial> catalogFindBySubFam(int id, String patronPartNumber, int x) {   //wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.noParte LIKE  :part AND c.subFamiliasidsubFam.idsubFam = :id");
        res.setParameter("part", patronPartNumber.toLowerCase() + "%");
        res.setParameter("id", id);
        List<TblMaterial> data = mtlResults(res);

        return data;

    }

    public List<TblMaterial> catalogFindByType(int id, String patronName) {    //wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.nombre LIKE  :part AND c.idTipomaterial.idTipomaterial = :id");
        res.setParameter("part", patronName.toLowerCase() + "%");
        res.setParameter("id", id);
        List<TblMaterial> data = mtlResults(res);

        return data;

    }

    public List<TblMaterial> catalogFindByType(int id, String patronPartNumber, int x) {   //wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        Query res = em.createQuery("SELECT c.idtblMaterial,c.noParte,c.nombre,c.descripcion,c.stock,c.costo,c.imagen, c.idArea.idArea, c.idTipomaterial.idTipomaterial,c.subFamiliasidsubFam.idsubFam , c.idArea.descripcion, c.idTipomaterial.descripcion, c.subFamiliasidsubFam.nombre, c.inventariable  FROM TblMaterial c WHERE c.noParte   LIKE  :part AND c.idTipomaterial.idTipomaterial = :id");
        res.setParameter("part", patronPartNumber.toLowerCase() + "%");
        res.setParameter("id", id);
        List<TblMaterial> data = mtlResults(res);

        return data;

    }

    public boolean checkStock(String noParte, int quantity) {
        Query query = em.createQuery("SELECT c.stock FROM TblMaterial c WHERE c.noParte = :parte");
        query.setParameter("parte", noParte);

        int stock = (int) query.getSingleResult();
        System.out.println("el stock es: " + stock);
        return stock >= quantity;
    }

    public List<TblMaterial> listafull() {
        List<TblMaterial> lista = null;

        try {

            TypedQuery<TblMaterial> search = em.createQuery("SELECT NEW com.server.entity.beans.TblMaterial(u.noParte, u.nombre, u.descripcion, u.stock) FROM TblMaterial u", TblMaterial.class);

            lista = search.getResultList();
            System.out.println(lista);
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }
        return lista;

    }

    public boolean agregar(String nombre, String noParte, String descripcion, String cantidad, String costo, String unidadmedida, String marca, String serie, String estado, String ubicacion, String responsable, String probedor, String noFactura,
            String ordenDcompra, String zip, String financiamiento, String tipodecompra, String idUABC, String fecharecepcion, String area, String tipodematerial, String subfamilia, String almacen, String imagen) {

        try {
            TblMaterial mat = new TblMaterial();
            TblArea ar = new TblArea();
            TblTipomaterial tm = new TblTipomaterial();
            Subfamilias sf = new Subfamilias();
            Almacen al = new Almacen();
            Date date1 = new Date();
            mat.setNombre(nombre);
            mat.setNoParte(noParte);
            mat.setDescripcion(descripcion);
            mat.setStock(Integer.parseInt(cantidad));
            mat.setCosto(Long.valueOf(costo));
            mat.setUnidadMedida(unidadmedida);
            mat.setMarca(marca);
            mat.setSerie(serie);
            mat.setEstado(estado);
            mat.setUbicacionActual(ubicacion);
            mat.setResponsable(responsable);
            mat.setProveedor(probedor);
            mat.setNumeroFactura(noFactura);
            mat.setOrdenCompra(ordenDcompra);
            mat.setCodigoSip(zip);
            mat.setFinanciamiento(financiamiento);
            mat.setTipoCompra(tipodecompra);
            mat.setIdUabc(idUABC);
            mat.setFechaRecepcion(date1);
            mat.setImagen(imagen);
            ar.setIdArea(Integer.parseInt(area));
            al.setIdalmacen(Integer.parseInt(almacen));
            tm.setIdTipomaterial(Integer.parseInt(tipodematerial));
            sf.setIdsubFam(Integer.parseInt(subfamilia));

            mat.setAlmacenIdalmacen(al);
            mat.setIdTipomaterial(tm);
            mat.setSubFamiliasidsubFam(sf);
            mat.setIdArea(ar);

            em.persist(mat);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean agregar11(String nombre, String noParte, String descripcion, String cantidad, String costo, String unidadmedida, String marca, String serie, String estado, String ubicacion, String responsable, String probedor, String noFactura,
            String ordenDcompra, String zip, String financiamiento, String tipodecompra, String idUABC, String fecharecepcion, String area, String tipodematerial, String subfamilia, String almacen, String imagen, TblArea area2, TblTipomaterial tipo, Subfamilias sub, boolean showinquery, boolean invent) {

        // TblMaterial mt2 = null;
        // Query search1 = em.createQuery("SELECT t FROM TblMaterial t WHERE t.noParte = :nopart ");
        //search1.setParameter("nopart", noParte);

        /*   try {
         mt2 = (TblMaterial) search1.getSingleResult();
         return false;
         } catch (Exception e) {*/
        TblMaterial mat = new TblMaterial();
        Almacen al = new Almacen();
        Date date1 = new Date();
        mat.setNombre(nombre);
        mat.setNoParte(noParte);
        mat.setDescripcion(descripcion);
        mat.setStock(Integer.parseInt(cantidad));
        mat.setCosto(Long.parseLong(costo));
        mat.setUnidadMedida(unidadmedida);
        mat.setMarca(marca);
        mat.setSerie(serie);
        mat.setEstado(estado);
        mat.setUbicacionActual(ubicacion);
        mat.setResponsable(responsable);
        mat.setProveedor(probedor);
        mat.setNumeroFactura(noFactura);
        mat.setOrdenCompra(ordenDcompra);
        mat.setCodigoSip(zip);
        mat.setFinanciamiento(financiamiento);
        mat.setTipoCompra(tipodecompra);
        mat.setIdUabc(idUABC);
        mat.setFechaRecepcion(date1);
        mat.setImagen(imagen);
        mat.setShowInQuery(showinquery);
        mat.setInventariable(invent);
        mat.setTotal(Integer.parseInt(cantidad));
        //ar.setIdArea(Integer.parseInt(area));

        if (!(almacen == null || almacen.trim().equals(""))) {
            al.setIdalmacen(Integer.parseInt(almacen));
            mat.setAlmacenIdalmacen(al);
        }

        //tm.setIdTipomaterial(tipo);
        // sf.setIdsubFam(Integer.parseInt(subfamilia));
        mat.setIdTipomaterial(tipo);
        mat.setSubFamiliasidsubFam(sub);
        mat.setIdArea(area2);

        em.persist(mat);

        return true;
        // }

    }

    public boolean isAvailable(String noParte) {
        System.out.println("Holaaa uno doss tres: " + noParte);
        Query query = em.createQuery("SELECT c.idtblMaterial FROM TblMaterial c WHERE c.noParte = :number");
        query.setParameter("number", noParte);

        return !query.getResultList().isEmpty();
    }

    public TblMaterial bpormat(String noparte) {
        System.out.println(noparte);
        TblMaterial mt2 = null;

        Query query = em.createQuery("SELECT c FROM TblMaterial c WHERE c.noParte = :nopart");

        query.setParameter("nopart", noparte);
        try {
            mt2 = (TblMaterial) query.getSingleResult();
            System.out.println("encontrado: " + mt2);
        } catch (Exception e) {
            System.out.println("error");
            return mt2;

        } finally {
            return mt2;
        }

    }

    public boolean modificar(int id, String nombre, String noParte, String descripcion, String cantidad, String costo, String unidadmedida, String marca, String serie, String estado, String ubicacion, String responsable, String probedor, String noFactura,
            String ordenDcompra, String zip, String financiamiento, String tipodecompra, String idUABC, String fecharecepcion, String area, String tipodematerial, String subfamilia, String almacen, String imagen, TblArea area2, TblTipomaterial tipo, Subfamilias sub, boolean showinquery, boolean inventariable) {
        boolean existe = true;

        TblMaterial busc;
        //Query search = em.createQuery("SELECT t FROM TblMaterial t WHERE t.noParte = :noparte OR t.codigoSip = :sip OR t.idUabc = :uabc");
        Query search = em.createQuery("SELECT t FROM TblMaterial t WHERE t.noParte = :noparte");
        search.setParameter("noparte", noParte);
        //  search.setParameter("sip", zip);
        //  search.setParameter("uabc", idUABC);
        try {
            busc = (TblMaterial) search.getSingleResult();
            //  if (noFactura.equals(busc.getNoParte())||zip.equals(busc.getCodigoSip())||idUABC.equals(busc.getIdUabc())) {
            if (noParte.equals(busc.getNoParte())) {
                TblMaterial mat = em.find(TblMaterial.class, id);
                TblArea ar = new TblArea();
                TblTipomaterial tm = new TblTipomaterial();
                Subfamilias sf = new Subfamilias();
                Almacen al = new Almacen();
                Date date1 = new Date();
                mat.setNombre(nombre);
                mat.setNoParte(noParte);
                mat.setDescripcion(descripcion);
                int ajuste = mat.getTotal() - mat.getStock();
                // calculando y ajustando diferencia
                mat.setTotal(Integer.parseInt(cantidad));
                int diff = mat.getTotal() - mat.getStock();

                mat.setStock(mat.getStock() + diff - ajuste);

                //End ajuste total y stock
                mat.setCosto(Long.valueOf(costo));
                mat.setUnidadMedida(unidadmedida);
                mat.setMarca(marca);
                mat.setSerie(serie);
                mat.setEstado(estado);
                mat.setUbicacionActual(ubicacion);
                mat.setResponsable(responsable);
                mat.setProveedor(probedor);
                mat.setNumeroFactura(noFactura);
                mat.setOrdenCompra(ordenDcompra);
                mat.setCodigoSip(zip);
                mat.setFinanciamiento(financiamiento);
                mat.setTipoCompra(tipodecompra);
                mat.setIdUabc(idUABC);
                mat.setFechaRecepcion(date1);
                mat.setImagen(imagen);
                mat.setShowInQuery(showinquery);
                mat.setInventariable(inventariable);

                if (!(almacen == null || almacen.trim().equals(""))) {
                    al.setIdalmacen(Integer.parseInt(almacen));
                    mat.setAlmacenIdalmacen(al);
                }

                //tm.setIdTipomaterial(tipo);
                // sf.setIdsubFam(Integer.parseInt(subfamilia));
                mat.setIdTipomaterial(tipo);
                mat.setSubFamiliasidsubFam(sub);
                mat.setIdArea(area2);

                getEntityManager().merge(mat);
                System.out.println("MATERIAL MODIFICADO");
                existe = false;

            } else {
                existe = true;
            }

        } catch (Exception e) {
            TblMaterial mat = em.find(TblMaterial.class, id);
            TblArea ar = new TblArea();
            TblTipomaterial tm = new TblTipomaterial();
            Subfamilias sf = new Subfamilias();
            Almacen al = new Almacen();
            Date date1 = new Date();
            mat.setNombre(nombre);
            mat.setNoParte(noParte);
            mat.setDescripcion(descripcion);
            mat.setStock(Integer.parseInt(cantidad));
            mat.setCosto(Long.valueOf(costo));
            mat.setUnidadMedida(unidadmedida);
            mat.setMarca(marca);
            mat.setSerie(serie);
            mat.setEstado(estado);
            mat.setUbicacionActual(ubicacion);
            mat.setResponsable(responsable);
            mat.setProveedor(probedor);
            mat.setNumeroFactura(noFactura);
            mat.setOrdenCompra(ordenDcompra);
            mat.setCodigoSip(zip);
            mat.setFinanciamiento(financiamiento);
            mat.setTipoCompra(tipodecompra);
            mat.setIdUabc(idUABC);
            mat.setFechaRecepcion(date1);
            mat.setImagen(imagen);
            mat.setShowInQuery(showinquery);
            if (!(almacen == null || almacen.trim().equals(""))) {
                al.setIdalmacen(Integer.parseInt(almacen));
                mat.setAlmacenIdalmacen(al);
            }

            //tm.setIdTipomaterial(tipo);
            // sf.setIdsubFam(Integer.parseInt(subfamilia));
            mat.setIdTipomaterial(tipo);
            mat.setSubFamiliasidsubFam(sub);
            mat.setIdArea(area2);
            getEntityManager().merge(mat);
            existe = false;
            System.out.println("MATERIAL MODIFICADO");
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return existe;
    }

}
