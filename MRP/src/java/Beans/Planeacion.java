/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import ejb.TblordentrabajoFacade;
import entitys.Plan;
import entitys.Tblordencliente;
import entitys.Tblordentrabajo;
import java.io.Serializable;
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
@Named("planeacion")
@SessionScoped()
public class Planeacion implements Serializable {
    
   @EJB TblordentrabajoFacade otf;
   List<Tblordencliente> listoc;
@Inject UsuariosB beanusers;
List<Tblordentrabajo> listActiva;
List<Tblordentrabajo> listHecha;
List<Tblordentrabajo> listfempaque;
List<Tblordentrabajo> listfenvio;
List<Tblordentrabajo> listenviados;
List<Plan> listaPlanes;
List<Plan> listaPlaneshechos;

    public List<Tblordentrabajo> getListenviados() {
        listenviados=otf.listaenviados();
        return listenviados;
    }

    public void setListenviados(List<Tblordentrabajo> listenviados) {
        this.listenviados = listenviados;
    }



    public List<Tblordentrabajo> getListfempaque() {
        listfempaque=otf.listafempaque();
        return listfempaque;
    }

    public void setListfempaque(List<Tblordentrabajo> listfempaque) {
        this.listfempaque = listfempaque;
    }

    public List<Tblordentrabajo> getListfenvio() {
        listfenvio=otf.listafenvio();
        return listfenvio;
    }

    public void setListfenvio(List<Tblordentrabajo> listfenvio) {
        this.listfenvio = listfenvio;
    }

   
    public List<Plan> getListaPlaneshechos() {
        return listaPlaneshechos;
    }

    public void setListaPlaneshechos(List<Plan> listaPlaneshechos) {
        this.listaPlaneshechos = listaPlaneshechos;
    }



    public List<Plan> getListaPlanes() {
        return listaPlanes;
    }

    public void setListaPlanes(List<Plan> listaPlanes) {
        this.listaPlanes = listaPlanes;
    }



    public List<Tblordentrabajo> getListActiva() {
        listActiva=otf.listaActivas();
        return listActiva;
    }

    public void setListActiva(List<Tblordentrabajo> listActiva) {
        this.listActiva = listActiva;
    }

    public List<Tblordentrabajo> getListHecha() {
        listHecha=otf.listaHechas();
        return listHecha;
    }

    public void setListHecha(List<Tblordentrabajo> listHecha) {
        this.listHecha = listHecha;
    }


   
    public List<Tblordencliente> getListoc() {
        listoc=otf.listaOCforOT();
        return listoc;
    }

    public void setListoc(List<Tblordencliente> listoc) {
        this.listoc = listoc;
    }
   
    public void agregarOT(Tblordencliente oc){
        System.out.println("Ordencliente: "+oc);
        System.out.println("Usuario: "+beanusers.getUsuarioIN().getNombre());
                //calculando la Cantidad optima de produccion.
        float demanda=oc.getCantidad();
        float costoPuestamarcha=100;
        float CostoAnuaMtoxU=(float) 25;
        float tazaProduccion=200;
        float tazademandaDia=150;
        float duracionCorrida;
        float produccionOptima;
        
        produccionOptima=(float) Math.sqrt((2*demanda*costoPuestamarcha)/(CostoAnuaMtoxU*(1-(tazademandaDia/tazaProduccion))));
        int POP=(int) produccionOptima;
        System.out.println("Produccion: "+POP);
        float prome=(float) oc.getCantidad()/POP;
        int dias=(int) prome;
        int restantes=oc.getCantidad()-(dias*POP);
        
       boolean hecho= otf.crearOT(beanusers.getUsuarioIN(), oc, POP);
        int id=otf.creandoPlan(oc, POP);
        
        
        if(hecho==true){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hecho", "Orden Agregada ID: "+id));

        }else{
        
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Parámetros no coincidentes"));

        }
    }
   
   public void cargarPlan(int id){
   listaPlanes=otf.listaPlanes(id);
   listaPlaneshechos=otf.listaPlanesHechos(id);
   } 
   
   public void trabajoHecho(Tblordentrabajo ot, Plan p){
   
   otf.verificacionTrabajo(ot, p);
   
   
   }
 public void cambiarestatus(Tblordentrabajo ot, String st, String proceso){
 
 otf.cambioestatus(ot, st);
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hecho", "Orden envieada a "+proceso));

 }
    
}
