/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entitys.Fabricacion;
import entitys.Plan;
import entitys.Tblmateria;
import entitys.Tblordencliente;
import entitys.Tblordentrabajo;
import entitys.Tblproducto;
import entitys.Tblusuarios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class TblordentrabajoFacade extends AbstractFacade<Tblordentrabajo> {
    @PersistenceContext(unitName = "MRPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblordentrabajoFacade() {
        super(Tblordentrabajo.class);
    }
  public boolean crearOT(Tblusuarios us, Tblordencliente orcl,int cantidadPro){
       boolean rest;
  Date fechacapt = new Date();
  SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yy");
   float prome=(float) orcl.getCantidad()/cantidadPro;
   int dias;
   dias= (int) prome;
   
    int restantes;
    restantes=orcl.getCantidad()-(dias*cantidadPro);
  if(restantes==0){
      rest=false;
      System.out.println("NO hay retsantes");
  }else{
      rest=true;
      dias=dias+1;
      System.out.println("RESTANTEES");
  }
  
  try{
  Tblordentrabajo ot =new Tblordentrabajo();
  
  ot.setEstatus("1");
  ot.setFechacaptura(sp.format(fechacapt));
  ot.setFechaentrega(orcl.getFechaEntrega());
  ot.setTblOrdenclienteidTblOrdencliente(orcl);
  ot.setTblProductoidTblProducto(orcl.getIdTblProducto());
  ot.setTblUsuariosidTblUsuarios(us);
  ot.setDuracionDias(dias);
  ot.setCantidadproddia(cantidadPro);
  getEntityManager().persist(ot);
  
  orcl.setEstatus("3");
  getEntityManager().merge(orcl);
   
  //descontando de STOCK.
  List<Fabricacion> listF;
 try{
  Query consultita =em.createQuery("SELECT t FROM Fabricacion t WHERE t.tblProductoidTblProducto.idTblProducto = :id ");
   //Query consultita =em.createQuery("SELECT t FROM Fabricacion t WHERE t.tblProductoidTblProducto.idTblProducto = :id ");
   consultita.setParameter("id", orcl.getIdTblProducto().getIdTblProducto());
   listF=consultita.getResultList();
   Tblmateria mat;
    for(int i = 0; i < listF.size(); i++){
    mat=listF.get(i).getTblMateriaidTblMateria();
    mat.setStock(mat.getStock()- (listF.get(i).getCantidad()*orcl.getCantidad()));
    getEntityManager().merge(mat);
    }
 
 
 }
 catch(Exception er){System.out.println(er);}
return true;
  }catch(Exception e){
return false;
      //System.out.println("Exeption: "+e);
  }
 
  
  } 
  
  public int creandoPlan(Tblordencliente orcl,int cantidadPro){
   float prome=(float) orcl.getCantidad()/cantidadPro;
   int dias;
   boolean rest;
   dias= (int) prome;
    int restantes;
    restantes=orcl.getCantidad()-(dias*cantidadPro);
  if(restantes==0){
      rest=false;
      System.out.println("NO hay retsantes 2");
  }else{
      rest=true;
      dias=dias+1;
  }
  List<Tblordentrabajo> lista;
  Tblordentrabajo ordenT=null;
 Query search2 = em.createQuery("SELECT t FROM Tblordentrabajo t order by t.idTblOrdentrabajo desc");
 
 lista= search2.setMaxResults(1).getResultList();
  ordenT=lista.get(0);
  
  for(int i=0;dias>i;i++){
      Plan p=new Plan();
      p.setTblOrdentrabajoidTblOrdentrabajo(ordenT);
      p.setEstatus(1);
      p.setDia(i+1);
      if(i+1==dias && rest==true){
      p.setCantidad(restantes);    
      }
      else{
      p.setCantidad(cantidadPro);
      }
      getEntityManager().persist(p);
  }
  
  return ordenT.getIdTblOrdentrabajo();
  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
public List<Tblordencliente> listaOCforOT(){
       List<Tblordencliente> lista = null;
       List<Tblordencliente> listabuena =new ArrayList<>();
       List<Fabricacion> listaF = null;
       String st="2";
    try{
        
   Query consultita1 =em.createQuery("SELECT t FROM Tblordencliente t WHERE t.estatus= :st1 or t.estatus =:st2 ");
   consultita1.setParameter("st1", "1");
   consultita1.setParameter("st2", "2");
   // Query consultita =em.createQuery("SELECT t.tblProductoidTblProducto.tblordenclienteList FROM Fabricacion t WHERE  t.cantidad  < t.tblMateriaidTblMateria.stock");
  lista=consultita1.getResultList();
  for(int i = 0; i < lista.size(); i++) {
        int demanda=lista.get(i).getCantidad();
        int producto=lista.get(i).getIdTblProducto().getIdTblProducto();
          Query consultita =em.createQuery("SELECT t FROM Fabricacion t WHERE t.tblProductoidTblProducto.idTblProducto = :id and t.cantidad * :cant > t.tblMateriaidTblMateria.stock");
          consultita.setParameter("id", producto);
          consultita.setParameter("cant", demanda);
          listaF=consultita.getResultList();
          if(listaF.isEmpty()){
              System.out.println("BUENO BUENO: "+lista.get(i));
             listabuena.add(lista.get(i));
              
          }else{
              System.out.println("VALE PINGA");

          }
  
  }

    }catch(Exception e){
    
        System.out.println("ERROR: "+e);
    }
    return listabuena;





}  


public List<Tblordentrabajo> listaActivas(){

List<Tblordentrabajo> list = null;
try{
Query consultita1 =em.createQuery("SELECT t FROM Tblordentrabajo t WHERE t.estatus =:st1");
   consultita1.setParameter("st1", "1");
   list=consultita1.getResultList();
    System.out.println(list);
}
catch(Exception e){System.out.println(e);}



return list;
}
public List<Tblordentrabajo> listaHechas(){

List<Tblordentrabajo> list = null;
try{
Query consultita1 =em.createQuery("SELECT t FROM Tblordentrabajo t WHERE t.estatus =:st1");
   consultita1.setParameter("st1", "2");
 list=consultita1.getResultList();
 System.out.println(list);
}
catch(Exception e){System.out.println(e);}



return list;
}
public List<Tblordentrabajo> listafempaque(){

List<Tblordentrabajo> list = null;
try{
Query consultita1 =em.createQuery("SELECT t FROM Tblordentrabajo t WHERE t.estatus =:st1");
   consultita1.setParameter("st1", "3");
 list=consultita1.getResultList();
 System.out.println(list);
}
catch(Exception e){System.out.println(e);}

return list;
}
public List<Tblordentrabajo> listaenviados(){

List<Tblordentrabajo> list = null;
try{
Query consultita1 =em.createQuery("SELECT t FROM Tblordentrabajo t WHERE t.estatus =:st1");
   consultita1.setParameter("st1", "5");
 list=consultita1.getResultList();
 System.out.println(list);
}
catch(Exception e){System.out.println(e);}

return list;
}
public List<Tblordentrabajo> listafenvio(){

List<Tblordentrabajo> list = null;
try{
Query consultita1 =em.createQuery("SELECT t FROM Tblordentrabajo t WHERE t.estatus =:st1");
   consultita1.setParameter("st1", "4");
 list=consultita1.getResultList();
 System.out.println(list);
}
catch(Exception e){System.out.println(e);}



return list;
}
public void cambioestatus(Tblordentrabajo ot, String st){
    
    ot.setEstatus(st);
    getEntityManager().merge(ot);

}


public List<Plan> listaPlanes(int id){

List<Plan> list = null;
try{
Query consultita1 =em.createQuery("SELECT t FROM Plan t WHERE t.tblOrdentrabajoidTblOrdentrabajo.idTblOrdentrabajo =:id and t.estatus=:st");
   consultita1.setParameter("id", id);
   consultita1.setParameter("st", 1);
 list=consultita1.getResultList();
 System.out.println(list);
}
catch(Exception e){System.out.println(e);}



return list;
}
public List<Plan> listaPlanesHechos(int id){

List<Plan> list = null;
try{
Query consultita1 =em.createQuery("SELECT t FROM Plan t WHERE t.tblOrdentrabajoidTblOrdentrabajo.idTblOrdentrabajo =:id and t.estatus=:st");
   consultita1.setParameter("id", id);
   consultita1.setParameter("st", 2);
 list=consultita1.getResultList();
 System.out.println(list);
}
catch(Exception e){System.out.println(e);}



return list;
}
public void verificacionTrabajo( Tblordentrabajo ot, Plan plan){

List<Plan> list = null;
    System.out.println("ORDENT: "+ot);
    System.out.println("plan: "+plan);
try{
plan.setEstatus(2);
getEntityManager().merge(plan);
    System.out.println("PLAN ACTUALIZADO");

}catch(Exception e){System.out.println(e);}

try{
Query consultita1 =em.createQuery("SELECT t FROM Plan t WHERE t.tblOrdentrabajoidTblOrdentrabajo.idTblOrdentrabajo =:id AND t.estatus =:st");
   consultita1.setParameter("id", ot.getIdTblOrdentrabajo());
   consultita1.setParameter("st", 1);
 list=consultita1.getResultList();
      if(list.isEmpty()){
      //cambiara estatus orden trabajo
          System.out.println("PROUCTO LISTO");
          ot.setEstatus("2");
          getEntityManager().merge(ot);
      
      }else{
          System.out.println("Sigue trabajando");
      }
      
}
catch(Exception e){System.out.println(e);}


}  






}
