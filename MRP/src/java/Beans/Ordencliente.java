/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import ejb.TblclientesFacade;
import ejb.TblordenclienteFacade;
import ejb.TblproductoFacade;
import entitys.Tblclientes;
import entitys.Tblordencliente;
import entitys.Tblproducto;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named("ordenCliente")
@SessionScoped()


public class Ordencliente implements Serializable {
private int cantidad;
private Date fechaPedido;
private String cliente;
private String producto;
private String fechaCaptura;
private List<Tblclientes> listc;
private List<Tblproducto> listp;
private List<Tblordencliente> listorc;
private Tblordencliente selectedorden;
private String busqueda;
private String radiobutton;
private String radiobutton2;
private String cantidadStr;
@EJB TblproductoFacade pf;
@EJB TblclientesFacade cf;
@EJB TblordenclienteFacade orf;

    public String getCantidadStr() {
        return cantidadStr;
    }

    public void setCantidadStr(String cantidadStr) {
        this.cantidadStr = cantidadStr;
    }


    public String getRadiobutton2() {
        return radiobutton2;
    }

    public void setRadiobutton2(String radiobutton2) {
        this.radiobutton2 = radiobutton2;
    }

    public String getRadiobutton() {
        return radiobutton;
    }

    public void setRadiobutton(String radiobutton) {
        this.radiobutton = radiobutton;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public Tblordencliente getSelectedorden() {
        return selectedorden;
    }

    public void setSelectedorden(Tblordencliente selectedorden) {
        this.selectedorden = selectedorden;
    }

    public List<Tblordencliente> getListorc() {

        return listorc;
    }

    public void setListorc(List<Tblordencliente> listorc) {
        this.listorc = listorc;
    }

    public String getFechaCaptura() {
        Date nd=new Date();
        SimpleDateFormat ft = 
      new SimpleDateFormat ("dd/MM/yy");
        fechaCaptura=ft.format(nd);
        return fechaCaptura;
    }

    public void setFechaCaptura(String fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }


    public List<Tblclientes> getListc() {
        listc=cf.findAll();
       
        return listc;
    }

    public void setListc(List<Tblclientes> listc) {
        this.listc = listc;
    }

    public List<Tblproducto> getListp() {
        listp=pf.findAll();
        return listp;
    }

    public void setListp(List<Tblproducto> listp) {
        this.listp = listp;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaPedido() {
        
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
public void agregar(){
    cantidad=Integer.parseInt(cantidadStr);
    boolean existe;
SimpleDateFormat ft = 
      new SimpleDateFormat ("dd/MM/yy");
      existe=orf.agregar(cliente, producto, cantidad, ft.format(fechaPedido));
   if(existe==false){
   cliente=null;
   producto=null;
   cantidad=0;
   cantidadStr=null;
   fechaPedido=null;
   Tblordencliente ordencreada=orf.verOrdencreada();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hecho", "Orden Agregada: ID: "+ordencreada.getIdTblOrdencliente()+" de producto: "+ordencreada.getIdTblProducto().getModelo()));
   
       System.out.println("AGREGADO");
   }else{
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Parámetros no coincidentes"));
   
   }
}

public void  pruebadialogo(int valor){
    System.out.println("Valores es: "+valor);

}
        
    public List<String> completeBuscar(String query) {
    List<String> listaUse;
        System.out.println("ELIMINARR CONS");
      //  UIInput compBusqueda = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("contenido:fm:busqorden");
        System.out.println("carcater: "+query);
       System.out.println("Radio: "+radiobutton);
        switch (radiobutton){
            case "1":
              listaUse = orf.busqueda(query);
                break;
            case "2":
              listaUse = orf.busquedabyPr(query);
                break;
            case "3":
                listaUse = orf.busquedabyCliente(query);
                break;
            case "4":
                listaUse = orf.busquedabyFecha(query);
                break;
            default :
                listaUse = orf.busqueda(query);
                break;
        
        }
       

        return listaUse;
    }     
public void radiobuton(){

    System.out.println("Seleccion: "+radiobutton);

}
public void radiobuton2(){

    System.out.println("Seleccion: "+radiobutton2);
    switch(radiobutton2){
           case "1":listorc=orf.findAll();
            break;
          case "2":listorc=orf.listaordenes("1");
            break;
          case "3":listorc=orf.listaordenes("2");
            break;  
          default:listorc=orf.findAll();
              
            break;
    
    }

}
public void filtrarLista(){

listorc=orf.listaFiltrada(busqueda,radiobutton);
busqueda=null;


}
public String irairdenes(){

listorc=orf.findAll();
return"listaOrdenesCliente.xhtml?faces-redirect=true";
}

public void verordenc(){
orf.verOrdencreada();

}
}
