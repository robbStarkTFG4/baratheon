/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import entitys.Almacen;
import entitys.Subfamilias;
import entitys.TblArea;
import entitys.TblMaterial;
import entitys.TblTipomaterial;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class TblMaterialFacade extends AbstractFacade<TblMaterial> {
    @PersistenceContext(unitName = "AltasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMaterialFacade() {
        super(TblMaterial.class);
    }
public boolean agregar (String nombre, String noParte, String descripcion, String cantidad,String costo, String unidadmedida, String marca, String serie, String estado, String ubicacion, String responsable, String probedor, String noFactura,
String ordenDcompra, String zip, String financiamiento, String tipodecompra, String idUABC, String fecharecepcion, String area, String tipodematerial, String subfamilia, String almacen, String imagen ){
  
 try{ 
  TblMaterial mat =new TblMaterial();
  TblArea ar=new TblArea();
  TblTipomaterial tm= new TblTipomaterial();
  Subfamilias sf=new Subfamilias();
  Almacen al=new Almacen();
  Date date1 = new Date();
  mat.setNombre(nombre);
  mat.setNoParte(noParte);
  mat.setDescripcion(descripcion);
  mat.setStock(Integer.parseInt(cantidad));
  mat.setCosto(Float.valueOf(costo).floatValue());
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
 }
 catch(Exception e){
 return false;
 }
  
  }

public boolean agregar11 (String nombre, String noParte, String descripcion, String cantidad,String costo, String unidadmedida, String marca, String serie, String estado, String ubicacion, String responsable, String probedor, String noFactura,
String ordenDcompra, String zip, String financiamiento, String tipodecompra, String idUABC, String fecharecepcion, String area, String tipodematerial, String subfamilia, String almacen, String imagen ){
 TblMaterial mt2=null;
 Query search1 =em.createQuery("SELECT t FROM TblMaterial t WHERE t.noParte = :nopart or t.idUabc = :iduabc or t.numeroFactura = :nofact or t.codigoSip = :sip or t.ordenCompra = :oco");
 search1.setParameter("nopart", noParte);
 search1.setParameter("iduabc", idUABC);
  search1.setParameter("nofact", noFactura);
 search1.setParameter("sip", zip);
 search1.setParameter("oco", ordenDcompra); 

 try{ 
mt2=(TblMaterial) search1.getSingleResult();
return false;
 }
 catch(Exception e){
 TblMaterial mat =new TblMaterial();
  TblArea ar=new TblArea();
  TblTipomaterial tm= new TblTipomaterial();
  Subfamilias sf=new Subfamilias();
  Almacen al=new Almacen();
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
 }
  
  }
}
