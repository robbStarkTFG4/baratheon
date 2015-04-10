/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import ejb.FabricacionFacade;
import ejb.TblalmacenFacade;
import ejb.TblordenclienteFacade;
import ejb.TblordencompraFacade;
import ejb.TblprovedoresFacade;
import entitys.Fabricacion;
import entitys.Tblmateria;
import entitys.Tblordencliente;
import entitys.Tblordencompra;
import entitys.Tblprovedores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cristian
 */
@Named("compras")
@SessionScoped()

public class Compras implements Serializable {
 @EJB TblordenclienteFacade of;
 @EJB FabricacionFacade ff;
 @EJB TblprovedoresFacade pf;
 @EJB TblordencompraFacade orcf;
 @EJB TblprovedoresFacade provef;
 @Inject UsuariosB beanusuarios;
 @EJB TblalmacenFacade almaF;
private boolean pirmero1q2=false;
 private float costoMantener;
 private String mensajeStock;
 private String fechallegada;
 private  float costoOrdenar=120;
 private String provedor;
 private String iva="16";
 private String paginaR;
 private String  nuevoEOQ;
 private Fabricacion selectedFab;
 Tblordencliente orden;
 List<Fabricacion> fab;
  List<Fabricacion> fab2;
 List<Tblprovedores>listprove;
 List<Tblordencompra> listOcompra;
 List<Tblordencompra> listOcompra2;
  List<Tblordencompra> listParaInspec;
 List<Tblordencliente> listorc;
  List<Tblordencliente> listorc2;
 List<String> listEOQ;
 List<String> listABC;
 List<Tblordencompra> listaHechos;
 List<String>listilla;
 private int EOQ;
 private String EQOSleccted;
 private String ABC;
private String precioProvedor;

    public String getMensajeStock() {
        return mensajeStock;
    }

    public void setMensajeStock(String mensajeStock) {
        this.mensajeStock = mensajeStock;
    }

    public List<Tblordencompra> getListParaInspec() {
        listilla=new ArrayList<>();
        listParaInspec=orcf.listaComprasbyocS3();
        if(listParaInspec!=null){
         for(int i = 0; i < listParaInspec.size(); i++) {
       if(listParaInspec.get(i).getTblMateriaidTblMateria().getIdTblMateria()==1){
       listilla.add(i, listParaInspec.get(i).getAbc()+"1");
       }else{
       listilla.add(i, listParaInspec.get(i).getAbc()+"2");
       }
       }}
        return listParaInspec;
    }

    public void setListParaInspec(List<Tblordencompra> listParaInspec) {
        this.listParaInspec = listParaInspec;
    }

   public List<String> getListilla() {
        return listilla;
    }

    public void setListilla(List<String> listilla) {
        this.listilla = listilla;
    }
    public List<Fabricacion> getFab2() {
        return fab2;
    }

    public void setFab2(List<Fabricacion> fab2) {
        this.fab2 = fab2;
    }

    public String getNuevoEOQ() {
        return nuevoEOQ;
    }

    public void setNuevoEOQ(String nuevoEOQ) {
        this.nuevoEOQ = nuevoEOQ;
    }

    public String getPrecioProvedor() {
        return precioProvedor;
    }

    public void setPrecioProvedor(String precioProvedor) {
        this.precioProvedor = precioProvedor;
    }


    public List<Tblordencliente> getListorc2() {
        return listorc2;
    }

    public void setListorc2(List<Tblordencliente> listorc2) {
        this.listorc2 = listorc2;
    }

    public List<Tblordencompra> getListOcompra2() {

       listOcompra2=orcf.listaComprasbyocS2();

        return listOcompra2;
    
    }

    public void setListOcompra2(List<Tblordencompra> listOcompra2) {
        this.listOcompra2 = listOcompra2;
    }

    public String getPaginaR() {
        return paginaR;
    }

    public void setPaginaR(String paginaR) {
        this.paginaR = paginaR;
    }

    public List<Tblordencompra> getListOcompra() {
        listOcompra=orcf.listaComprasbyoc();
        return listOcompra;
    }

    public void setListOcompra(List<Tblordencompra> listOcompra) {
        this.listOcompra = listOcompra;
    }

    public List<Tblordencliente> getListorc() {
        listorc=orcf.listaOcliente();
        return listorc;
    }

    public void setListorc(List<Tblordencliente> listorc) {
        this.listorc = listorc;
    }

    public boolean isPirmero1q2() {
        return pirmero1q2;
    }

    public void setPirmero1q2(boolean pirmero1q2) {
        this.pirmero1q2 = pirmero1q2;
    }


    public String getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(String fechallegada) {
        this.fechallegada = fechallegada;
    }

    public String getEQOSleccted() {
        return EQOSleccted;
    }

    public void setEQOSleccted(String EQOSleccted) {
        this.EQOSleccted = EQOSleccted;
    }

    public Fabricacion getSelectedFab() {
        return selectedFab;
    }

    public void setSelectedFab(Fabricacion selectedFab) {
        this.selectedFab = selectedFab;
    }

    public List<String> getListEOQ() {
        return listEOQ;
    }

    public void setListEOQ(List<String> listEOQ) {
        this.listEOQ = listEOQ;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public List<Tblprovedores> getListprove() {
       // listprove=pf.findAll();
        return listprove;
    }

    public void setListprove(List<Tblprovedores> listprove) {
        this.listprove = listprove;
    }

    public float getEOQ() {
        return EOQ;
    }

    public void setEOQ(int EOQ) {
        this.EOQ = EOQ;
    }

    public String getABC() {
        return ABC;
    }

    public void setABC(String ABC) {
        this.ABC = ABC;
    }
 

    public List<Fabricacion> getFab() {
        
        return fab;
    }

    public void setFab(List<Fabricacion> fab) {
        this.fab = fab;
    }

    public List<Tblordencompra> getListaHechos() {
        return listaHechos;
    }

    public void setListaHechos(List<Tblordencompra> listaHechos) {
        this.listaHechos = listaHechos;
    }

    public Tblordencliente getOrden() {
        return orden;
    }

    public void setOrden(Tblordencliente orden) {
        this.orden = orden;
    }
 
 List<Fabricacion> listMat;
 
 
 public String crear (int id){
     int cEOQ;
 System.out.println("ID:" +id);
 orden=  of.tomarorden(id);

filtrar();
listEOQ=new ArrayList<>();
listABC=new ArrayList<>();
for(int i = 0; i < fab.size(); i++) {
    if(fab.get(i).getTblMateriaidTblMateria().getNombre().equals("SMC")){
    listABC.add(i, "A");
    }else{ listABC.add(i,"B");  }
   float cantidad=orden.getCantidad()*fab.get(i).getCantidad();
   float costoPro=Float.parseFloat(fab.get(i).getTblMateriaidTblMateria().getPrecio());
           cEOQ=calculoEOQ(cantidad,costoPro,2) ;  
           listEOQ.add(i, Float.toString(cEOQ));
            //System.out.println(fab.get(i).getTblmateria().getNombre());
           //System.out.println("EOQ "+i+" "+cEOQ);
        }
     System.out.println(listEOQ);
      return "OrdenCompra.xhtml?faces-redirect=true";
  
 }
 public void guardarorden(int idFab){
     float total;
     boolean hecho;
     total=conversion(nuevoEOQ)*conversion(selectedFab.getTblMateriaidTblMateria().getPrecio())+conversion(iva)/100*conversion(nuevoEOQ)*conversion(selectedFab.getTblMateriaidTblMateria().getPrecio());
     System.out.println("usuario"+beanusuarios.getUsuarioIN().getUsuario());
     System.out.println("Material= "+selectedFab.getTblMateriaidTblMateria().getNombre());
     System.out.println("Proveedor= "+provedor);
     System.out.println("Cantidada-EOQ="+EQOSleccted);
     System.out.println("ABC="+ABC);
     System.out.println("Total= "+total);
     System.out.println("IVA= "+iva);
     System.out.println("Fecha= "+fechallegada);
     System.out.println("ORDEN CLIENTE= "+orden);
  // public boolean agregar(Tblusuarios usuario, Tblmateria material, Tblordencliente cliente ,String proveedor, String cantidadeoq, String ABC, String total, String iva, Date fecha) {  
 hecho=orcf.agregar(beanusuarios.getUsuarioIN(), selectedFab.getTblMateriaidTblMateria(), orden, provedor,nuevoEOQ,"A", Float.toString(total), iva, fechallegada);
 
 if(hecho==false){
   Tblordencompra orcomp=orcf.verOrdencreada();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hecho", "Orden Agregada ID: "+orcomp.getIdTblOrdencompra()+" De material: "+orcomp.getTblMateriaidTblMateria().getNombre()));
   
       System.out.println("AGREGADO");
       fechallegada=null;
       provedor=null;
        filtrar();
       
       
   }else{
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Parámetros no coincidentes"));
   
   }
 
 
 }
 
 
 
 
    public List<String> getListABC() {
        return listABC;
    }

    public void setListABC(List<String> listABC) {
        this.listABC = listABC;
    }
  
public int calculoEOQ(float demanda, float costoP, int mat) {
    System.out.println("DEMANDA: "+demanda);
    //costo

   // System.out.println("Costo mantener:");
EOQ= (int) Math.sqrt((2*demanda*costoOrdenar)/costoMantener);

return EOQ;
} 

    private float EQOSleccted(float parseFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
public Float conversion(String dato)  {

return Float.parseFloat(dato);


}  
 public void probar(){
 
 //orcf.tomarorden(orden.getIdTblOrdencliente());
 
 
 }   
 
 public void filtrar(){
 
 fab=ff.tomarorden(orden.getIdTblProducto().getIdTblProducto(),orden.getCantidad());
listaHechos=orcf.listapendientes(orden.getIdTblOrdencliente());
if(fab.isEmpty()){
mensajeStock="HAY SUFICIENTE MATERIAL EN STOCK";

}else{mensajeStock=null;}
if(listaHechos==null){
    System.out.println("NO HAY NADA");
}else{
         System.out.println("LISTA: "+listaHechos);
    System.out.println("YA HAY ALGO");
   if(listaHechos.size()>=2){
       System.out.println("ENTRE A EL 1");
        fab.remove(0);
        fab.remove(0);
        of.cambioestatus(orden);
   }  else{
              System.out.println("ENTRE A EL 2");
   if(listaHechos.get(0).getTblMateriaidTblMateria().getIdTblMateria()==1){fab.remove(0);pirmero1q2=false;}
   if(listaHechos.get(0).getTblMateriaidTblMateria().getIdTblMateria()==2){fab.remove(1);pirmero1q2=true;}
   
   }

   
}

 }
 
 public void metodoRow(int i){
     System.out.println(i);
     listOcompra=orcf.listaComprasbyoc();
 
 }
 public void metodoRow2(int i){
     System.out.println(i);
     listOcompra2=orcf.listaComprasbyocS2();
 
 }
 
 
 public String paginas (){
 
 if(paginaR.equals("1")){
     System.out.println("PAHINA 1");
     return "ordencompraGeneradas.xhtml?faces-redirect=true";
 }else{
     System.out.println("PAGINA 2");
 return null;
 }
 
 }
 
 public void llegada(int i,Tblmateria mat, Tblordencliente orc,String cant){
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hecho", "MATERIAL: "+mat.getNombre()+" de orden compra: "+i+"HA LLEGADO"));

 orcf.cambioestatus(i,"2",orc);
 //almaF.agregarAlmacen(mat, orc, cant);
 //crear almacen.
 
 
 }
  public void inspeccion(int i,Tblmateria mat, Tblordencliente orc,String cant){
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hecho", "MATERIAL: "+mat.getNombre()+" de orden compra: "+i+"HA PASADO INSPECCION"));

 orcf.cambioestatus( i,"3",orc);
 //almaF.agregarAlmacen(mat, orc, cant);
 //crear almacen.
 
 
 }
public void locacion(int i,Tblmateria mat, Tblordencliente orc,String cant,String locacion){
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hecho", "MATERIAL: "+mat.getNombre()+" de orden compra: "+i+"HA SIDO LOCACIONADO A: "+locacion));

 orcf.cambioestatus( i,"4",orc);
 almaF.agregarAlmacen(mat, orc, cant, locacion);
 //crear almacen.
 
 
 }
  
 
 public void fechaCargada(){
     int diasF=(int) (orden.getCantidad()*0.005);
     if(diasF<1){
     diasF=1;
     }
     String fecha=orden.getFechaEntrega();
     int dia=Integer.parseInt(fecha.substring(0, 2));
     int mes=Integer.parseInt(fecha.substring(3, 5));
     int ano=Integer.parseInt(fecha.substring(6, 8));
     System.out.println("dia: "+dia);
     System.out.println("dia: "+mes);
     System.out.println("dia: "+ano);
     
   if(dia>diasF){
   dia=dia-diasF;
   }else{
   
       for(int f=1;diasF>f;f++){
           dia=dia-1;
           if(dia==0){
           dia=30;
           mes=mes-1;
           }
           if(mes==0){
           mes=12;
           ano=ano-1;
           }
           //System.out.println("Vez: "+f);
       }
   }
   String diaS;
   String mesS;
   String anoS;
   if(dia<10){
   diaS="0"+Integer.toString(dia);
   }else{diaS=Integer.toString(dia);}
   if(mes<10){
   mesS="0"+Integer.toString(mes);
   }else{mesS=Integer.toString(mes);}
   anoS=Integer.toString(ano);
   fechallegada=diaS+"/"+mesS+"/"+anoS;
 }
 public void cargarProvedores(int idmat, int fab0){
   //  fechallegada
     fechaCargada();
     
     selectedFab=ff.fab(fab0);
     nuevoEOQ=null;
      int sumavol = 0;
      float sumaporcentaje;
 //AQUI PUESDES CARLULAR ABC.........
     int volumenanual=selectedFab.getTblMateriaidTblMateria().getVolumenAdll();
     fab2=ff.tomarorden(orden.getIdTblProducto().getIdTblProducto(),orden.getCantidad());
     for(int i = 0; i < fab2.size(); i++) {
      sumavol=sumavol+ fab2.get(i).getTblMateriaidTblMateria().getVolumenAdll();
     
     }
   sumaporcentaje=(float)volumenanual/sumavol;
     System.out.println("PORCENTAJE ANUAL: "+sumaporcentaje);
   if(sumaporcentaje>0.15){
     ABC="A";
   }
   else if(sumaporcentaje<0.15 &&sumaporcentaje>0.015){
     ABC="B";

   System.out.println("ABC: "+ABC);
   }
   else{
       ABC="C";
  
   System.out.println("ABC: "+ABC);
   }
    
     
     
     System.out.println("SUMA DE VOLUMENES: "+sumavol);

     precioProvedor=null;
     System.out.println("ID MAT: "+idmat);
     System.out.println("Select:= "+selectedFab);
 listprove=provef.cargarProvedores(idmat);
 }

public void cambiarEOQbyPorvedor(){
    float calculo;
    System.out.println("Porvedor seleccionaod: "+provedor);
    precioProvedor=provef.precioprovedor(Integer.parseInt(provedor),selectedFab.getTblMateriaidTblMateria().getIdTblMateria());
    calculo=calculoEOQ(orden.getCantidad()*selectedFab.getCantidad(), Float.parseFloat(precioProvedor),selectedFab.getTblMateriaidTblMateria().getIdTblMateria());
    nuevoEOQ=Float.toString(calculo);
} 
 
  }  
    
    

