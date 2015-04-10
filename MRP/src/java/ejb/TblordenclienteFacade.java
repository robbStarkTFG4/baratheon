/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entitys.Tblclientes;
import entitys.Tblordencliente;
import entitys.Tblproducto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
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
public class TblordenclienteFacade extends AbstractFacade<Tblordencliente> {
    @PersistenceContext(unitName = "MRPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblordenclienteFacade() {
        super(Tblordencliente.class);
    }
   public boolean agregar(String cliente, String producto, int cantidad, String fechaentrega) {
     Date fechacap = new Date();
     boolean existe = false;
      SimpleDateFormat ft = 
      new SimpleDateFormat ("dd/MM/yy");
        try {
            Tblordencliente us = new Tblordencliente();
            Tblclientes cl = new Tblclientes();
            Tblproducto pr = new Tblproducto();
           cl.setIdTblClientes(Integer.parseInt(cliente));
           pr.setIdTblProducto(Integer.parseInt(producto));
            us.setCantidad(cantidad);
            us.setIdTblClientes(cl);
            us.setFechaEntrega(fechaentrega);
            us.setIdTblProducto(pr);
            us.setFechaCaptura(ft.format(fechacap));
            us.setEstatus("1");
            getEntityManager().persist(us);
                existe = false;
            
        } catch (Exception e) {
            
            
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return existe;
    }  
  
   public Tblordencliente tomarorden (int id) {
   Tblordencliente orden=null;
   try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.idTblOrdencliente = :id ");
   consultita.setParameter("id", id);
   orden=(Tblordencliente) consultita.getSingleResult();
   }catch (Exception e){
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
   return orden;
   }
   
  public List<Tblordencliente> listaordenes (String st) {
   List<Tblordencliente> listorder=null;
 
   try{
   Query consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.estatus = :st ");
   consultita.setParameter("st", st);
   listorder=consultita.getResultList();
   }catch (Exception e){
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
   return listorder;
   }   
  public void cambioestatus(Tblordencliente ordc){
  ordc.setEstatus("2");
  getEntityManager().merge(ordc);
  
  }
 public List busqueda(String patron1) {
int patron=Integer.parseInt(patron1);
        List<String> list = null;

        try {

            Query search = em.createQuery("SELECT t.idTblOrdencliente FROM Tblordencliente t WHERE t.idTblOrdencliente LIKE :patron");
          //  search.setParameter("patron", patron.toLowerCase() + "%");
            search.setParameter("patron", patron);
            list = search.getResultList();
            System.out.println("LISTA DE id");
            System.out.println(list);
            HashSet hs = new HashSet();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);

        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }

        return list;
    }
 public List busquedabyPr(String patron) {
        List<String> list = null;
        try {

            Query search = em.createQuery("SELECT t.idTblProducto.modelo FROM Tblordencliente t WHERE t.idTblProducto.modelo LIKE :patron");
          search.setParameter("patron", patron.toLowerCase() + "%");
          
            list = search.getResultList();
            System.out.println("LISTA DE id");
            System.out.println(list);
            HashSet hs = new HashSet();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);

        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }

        return list;
    }
 public List busquedabyCliente(String patron) {
        List<String> list = null;

        try {

            Query search = em.createQuery("SELECT t.idTblClientes.numeroCliente FROM Tblordencliente t WHERE t.idTblClientes.numeroCliente LIKE :patron ");
          search.setParameter("patron", patron.toLowerCase() + "%");
          
            list = search.getResultList();
            System.out.println("LISTA DE id");
            System.out.println(list);
            HashSet hs = new HashSet();
            hs.addAll(list);
        list.clear();
        list.addAll(hs);

        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }

        return list;
    }
 
  public List busquedabyFecha(String patron) {
        List<String> list = null;

        try {

            Query search = em.createQuery("SELECT t.fechaCaptura FROM Tblordencliente t WHERE t.fechaCaptura LIKE :patron ");
          search.setParameter("patron", patron.toLowerCase() + "%");
          
            list = search.getResultList();
            System.out.println("LISTA DE id");
            System.out.println(list);
            HashSet hs = new HashSet();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);

        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }

        return list;
    }
 
 public List<Tblordencliente> listaFiltrada (String variable, String seleccion){
 
 List<Tblordencliente> listF=null;
Query consultita;
 try{
     switch (seleccion){
            case "1":    
              consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.idTblOrdencliente = :variable");
              consultita.setParameter("variable", Integer.parseInt(variable)); 
              break;
            case "2":
              consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.idTblProducto.modelo = :variable");
                consultita.setParameter("variable", variable);
              break;
            case "3":
               consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.idTblClientes.numeroCliente = :variable");
                consultita.setParameter("variable", variable);
               break;
            case "4":
                consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.fechaCaptura = :variable");
                consultita.setParameter("variable", variable);
                break;
            default :
                consultita =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.idTblOrdencliente = :variable");
                consultita.setParameter("variable", variable);
                break;
        
        }
     System.out.println("Seleccion de busk: "+seleccion);
   listF=consultita.getResultList();
   }catch (Exception e){
   System.out.println("ERROR IN Question FACADE:" + e.getMessage());
   
   }
 return listF;
 
 } 
  
  public Tblordencliente verOrdencreada(){
  List<Tblordencliente> lista;
  Tblordencliente ordencl=null;
 Query search = em.createQuery("SELECT t FROM Tblordencliente t order by t.idTblOrdencliente desc");
 
 lista= search.setMaxResults(1).getResultList();
  ordencl=lista.get(0);
      System.out.println("Resultado: "+ordencl);
  return ordencl;
  }
  
  
}
