/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entitys.Tblmateria;
import entitys.Tblordencliente;
import entitys.Tblordencompra;
import entitys.Tblprovedores;
import entitys.Tblusuarios;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class TblordencompraFacade extends AbstractFacade<Tblordencompra> {
    @PersistenceContext(unitName = "MRPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblordencompraFacade() {
        super(Tblordencompra.class);
    }
    public boolean agregar(Tblusuarios usuario, Tblmateria material, Tblordencliente cliente ,String proveedor, String cantidadeoq, String ABC, String total, String iva, String fecha) {
     boolean existe = false;
       /* Date fechacap = new Date();
     boolean existe = false;
      SimpleDateFormat ft = 
      new SimpleDateFormat ("dd/MM/yy");*/
        try {
           Tblordencompra ordencompra = new Tblordencompra();
           ordencompra.setTblUsuariosidTblUsuarios(usuario);
           ordencompra.setTblMateriaidTblMateria(material);
           ordencompra.setTblOrdenclienteidTblOrdencliente(cliente);
           Tblprovedores pr =new Tblprovedores();
           pr.setIdTblProvedores(Integer.parseInt(proveedor));
           ordencompra.setTblProvedoresidTblProvedores(pr);
           ordencompra.setCantidad(cantidadeoq);
           ordencompra.setTotal(total);
           ordencompra.setIva(iva);
           ordencompra.setAbc(ABC);
           ordencompra.setFechallegada(fecha);
           ordencompra.setEstatus("1");
    
            getEntityManager().persist(ordencompra);
                existe = false;
            
        } catch (Exception e) {
            
            System.out.println("Usuario No creado");
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return existe;
    }  
 public List<Tblordencompra> listapendientes (int id) {
   List<Tblordencompra> orden=null;
   try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencompra t WHERE t.tblOrdenclienteidTblOrdencliente.idTblOrdencliente = :id ");
   consultita.setParameter("id", id);
   orden=consultita.getResultList();
   System.out.println(orden.get(0).getIdTblOrdencompra());
       System.out.println(orden);
   }catch (Exception e){
       orden=null;
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
 return orden;
   }    
   public List<Tblordencompra> listaComprasbyoc () {
       String st="1";
   List<Tblordencompra> list=null;
   try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencompra t WHERE  t.estatus = :st");
   consultita.setParameter("st", st);
   list=consultita.getResultList();
   System.out.println(list.get(0).getIdTblOrdencompra());
       System.out.println(list);
   }catch (Exception e){
       list=null;
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
 return list;
   }    
 public List<Tblordencompra> listaComprasbyocS2 () {
       String st="2";
   List<Tblordencompra> list=null;
   try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencompra t WHERE  t.estatus = :st");
   consultita.setParameter("st", st);
   list=consultita.getResultList();
   System.out.println(list.get(0).getIdTblOrdencompra());
       System.out.println(list);
   }catch (Exception e){
       list=null;
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
 return list;
   } 
 public List<Tblordencompra> listaComprasbyocS3 () {
       String st="3";
   List<Tblordencompra> list=null;
   try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencompra t WHERE  t.estatus = :st");
   consultita.setParameter("st", st);
   list=consultita.getResultList();
   System.out.println(list.get(0).getIdTblOrdencompra());
       System.out.println(list);
   }catch (Exception e){
       list=null;
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
 return list;
   } 
   
  public List<Tblordencliente> listaOcliente () {
  List<Tblordencliente> list=null;
   try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.estatus = :st");
   consultita.setParameter("st", "2");
   list=consultita.getResultList();
   //System.out.println(list.get(0).getIdTblOrdencompra());
       System.out.println(list);
   }catch (Exception e){
       list=null;
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
 return list;

  }
   public List<Tblordencliente> listaOcliente2 () {
  List<Tblordencliente> list=null;
   try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.estatus = :st ");
   consultita.setParameter("st", "2");
   list=consultita.getResultList();
   //System.out.println(list.get(0).getIdTblOrdencompra());
       System.out.println(list);
   }catch (Exception e){
       list=null;
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
 return list;

  }
   
   public void cambioestatus(int i,String status,Tblordencliente oc){
       Tblordencompra oco=null;
  try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencompra t WHERE t.idTblOrdencompra= :id ");
   consultita.setParameter("id", i);
   oco=(Tblordencompra) consultita.getSingleResult();
   //System.out.println(list.get(0).getIdTblOrdencompra());
   
      oco.setEstatus(status);
      getEntityManager().merge(oco);
   }catch (Exception e){
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   } 

   }
   
  public Tblordencompra verOrdencreada(){
  List<Tblordencompra> lista;
  Tblordencompra ordencl=null;
 Query search = em.createQuery("SELECT t FROM Tblordencompra t order by t.idTblOrdencompra desc");
 
 lista= search.setMaxResults(1).getResultList();
  ordencl=lista.get(0);
      System.out.println("Resultado: "+ordencl);
  return ordencl;
  }

    
    
    
    
}
