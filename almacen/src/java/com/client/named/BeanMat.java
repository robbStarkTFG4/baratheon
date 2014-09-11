/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.AlmacenFacade;
import com.server.beans.staless.SubfamiliasFacade;
import com.server.beans.staless.TblAreaFacade;
import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.staless.TblTipomaterialFacade;
import com.server.entity.beans.Almacen;
import com.server.entity.beans.Subfamilias;
import com.server.entity.beans.TblArea;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblTipomaterial;
import com.util.materialBusqueda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author cristian
 */
@Named("material")
@SessionScoped
public class BeanMat implements Serializable {
@Inject BeanMateriales beanmat;
    @EJB
    TblMaterialFacade mf;
    @EJB
    AlmacenFacade af;
    @EJB
    SubfamiliasFacade sff;
    @EJB
    TblAreaFacade arf;
    @EJB
    TblTipomaterialFacade tmf;
    @EJB
    TblMaterialFacade mat;
    TblMaterial matencontrado;
    List<TblMaterial> listamat;
    @Inject
    BeanUsuarios beanuser;
    String noparte;
    List<materialBusqueda> listaEtiquetas;
    List<String> lista = new ArrayList<>();
    private String nombre;
    private String noParte;
    private String descripcion;
    private String cantidad;
    private String costo;
    private String unidadmedida;
    private String marca;
    private String serie;
    private String estado;
    private String ubicacion;
    private boolean showinquery;
    private String responsable;
    private String probedor;
    private String noFactura;
    private String ordenDcompra;
    private String zip;
    private String financiamiento;
    private String tipodecompra;
    private String idUABC;
    private String fecharecepcion;

    private String area;
    private String tipodematerial;
    private String subfamilia;
    private String almacen;
    private String imagen;
    private List<TblArea> listArea;
    private List<Almacen> lalm;
    private List<TblTipomaterial> listTM;
    private List<Subfamilias> listSF;
    private boolean habilitarTab = true;
    private TblArea selectedArea = null;
    private TblTipomaterial selectedTipo = null;
    private Subfamilias selectedSubFamilia = null;
    private TblMaterial material;
    private TblMaterial material2;

    public List<TblArea> getListArea() {
        return listArea;
    }

    public void setListArea(List<TblArea> listArea) {
        this.listArea = listArea;
    }

    public List<Almacen> getLalm() {

        return lalm;
    }

    public boolean isShowinquery() {
        return showinquery;
    }

    public void setShowinquery(boolean showinquery) {
        this.showinquery = showinquery;
    }

    public void setLalm(List<Almacen> lalm) {
        this.lalm = lalm;
    }

    public List<TblTipomaterial> getListTM() {
        //  this.listTM = tmf.listAtm(selectedArea.getIdArea());
        return listTM;
    }

    public void setListTM(List<TblTipomaterial> listTM) {
        this.listTM = listTM;
    }

    public List<Subfamilias> getListSF() {
        // this.listSF = sff.listAL(this.selectedTipo.getIdTipomaterial());
        return listSF;
    }

    public void setListSF(List<Subfamilias> listSF) {
        this.listSF = listSF;
    }

    public boolean isHabilitarTab() {
        return habilitarTab;
    }

    public void setHabilitarTab(boolean habilitarTab) {
        this.habilitarTab = habilitarTab;
    }

    public TblArea getSelectedArea() {
        return selectedArea;
    }

    public TblMaterial getMaterial2() {
        return material2;
    }

    public void setMaterial2(TblMaterial material2) {
        this.material2 = material2;
    }

    public void setSelectedArea(TblArea selectedArea) {
        this.selectedArea = selectedArea;
    }

    public TblTipomaterial getSelectedTipo() {
        return selectedTipo;
    }

    public void setSelectedTipo(TblTipomaterial selectedTipo) {
        this.selectedTipo = selectedTipo;
    }

    public Subfamilias getSelectedSubFamilia() {
        return selectedSubFamilia;
    }

    public void setSelectedSubFamilia(Subfamilias selectedSubFamilia) {
        this.selectedSubFamilia = selectedSubFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNoParte() {
        return noParte;
    }

    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getProbedor() {
        return probedor;
    }

    public void setProbedor(String probedor) {
        this.probedor = probedor;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public String getOrdenDcompra() {
        return ordenDcompra;
    }

    public void setOrdenDcompra(String ordenDcompra) {
        this.ordenDcompra = ordenDcompra;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(String financiamiento) {
        this.financiamiento = financiamiento;
    }

    public String getTipodecompra() {
        return tipodecompra;
    }

    public void setTipodecompra(String tipodecompra) {
        this.tipodecompra = tipodecompra;
    }

    public String getIdUABC() {
        return idUABC;
    }

    public void setIdUABC(String idUABC) {
        this.idUABC = idUABC;
    }

    public String getFecharecepcion() {
        return fecharecepcion;
    }

    public void setFecharecepcion(String fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTipodematerial() {
        return tipodematerial;
    }

    public void setTipodematerial(String tipodematerial) {
        this.tipodematerial = tipodematerial;
    }

    public String getSubfamilia() {
        return subfamilia;
    }

    public void setSubfamilia(String subfamilia) {
        this.subfamilia = subfamilia;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<materialBusqueda> getListaEtiquetas() {

        return listaEtiquetas;
    }

    public void setListaEtiquetas(List<materialBusqueda> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }

    public TblMaterial getMatencontrado() {
        return matencontrado;
    }

    public void setMatencontrado(TblMaterial matencontrado) {
        this.matencontrado = matencontrado;
    }

    public TblMaterial getMaterial() {
        return material;
    }

    public void setMaterial(TblMaterial material) {
        this.material = material;
    }

    public String getNoparte() {
        return noparte;
    }

    public void setNoparte(String noparte) {
        this.noparte = noparte;
    }

    public List<TblMaterial> getListamat() {

        this.listamat = mat.listafull();

        return listamat;
    }

    public void probar() {
        System.out.println(material2.getNoParte());

    }

    public void busqueda() {

        matencontrado = mat.bpormat(material.getNoParte());
        if (matencontrado != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Encontrado!", "Material encontrado!!"));

            listaEtiquetas = getList();
            beanuser.acciones("Reporte de material generado ", matencontrado.getNoParte());
            material = null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Material no existente"));
            listaEtiquetas = null;
            material = null;
        }

    }

    public void busquedaUpdate() {
        nombre = null;
        noParte = null;
        descripcion = null;
        cantidad = null;
        costo = null;
        unidadmedida = null;
        marca = null;
        serie = null;
        estado = null;
        ubicacion = null;
        responsable = null;
        probedor = null;
        noFactura = null;
        ordenDcompra = null;
        zip = null;
        financiamiento = null;
        tipodecompra = null;
        idUABC = null;
        fecharecepcion = null;
        area = null;
        tipodematerial = null;
        subfamilia = null;
        almacen = null;
        imagen = null;
        matencontrado = mat.bpormat(material2.getNoParte());
        if (matencontrado != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Encontrado!", "Material encontrado!!"));
            nombre = matencontrado.getNombre();
            noParte = matencontrado.getNoParte();
            descripcion = matencontrado.getDescripcion();
            cantidad = matencontrado.getStock().toString();
            costo = matencontrado.getCosto().toString();
            unidadmedida = matencontrado.getUnidadMedida();
            marca = matencontrado.getMarca();
            showinquery=matencontrado.getShowInQuery();
            if (matencontrado.getSerie() != null) {
                serie = matencontrado.getSerie();
            }//puede ser nulo
            estado = matencontrado.getEstado();
            ubicacion = matencontrado.getUbicacionActual();
            responsable = matencontrado.getResponsable();
            if (matencontrado.getProveedor() != null) {
                probedor = matencontrado.getProveedor();
            }//puede ser nulo
            if (matencontrado.getNumeroFactura() != null) {
                noFactura = matencontrado.getNumeroFactura();
            }//puede ser nulo
            if (matencontrado.getOrdenCompra() != null) {
                ordenDcompra = matencontrado.getOrdenCompra();
            }//puede ser nulo
            if (matencontrado.getCodigoSip() != null) {
                zip = matencontrado.getCodigoSip();
            }//puede ser nulo
            if (matencontrado.getFinanciamiento() != null) {
                financiamiento = matencontrado.getFinanciamiento();
            }//puede ser nulo
            if (matencontrado.getTipoCompra() != null) {
                tipodecompra = matencontrado.getTipoCompra();
            }//puede ser nulo
            if (matencontrado.getIdUabc() != null) {
                idUABC = matencontrado.getIdUabc();
            }//puede ser nulo
            if (matencontrado.getFechaRecepcion() != null) {
                fecharecepcion = matencontrado.getFechaRecepcion().toString();
            }
            // area = matencontrado.getIdArea().toString();
            // tipodematerial = matencontrado.getIdTipomaterial().toString();
            // subfamilia = matencontrado.getSubFamiliasidsubFam().toString();
            this.lalm = af.listAL();
            this.selectedArea = matencontrado.getIdArea();
            listTM = tmf.listAtm(this.selectedArea.getIdArea());
            System.out.println(matencontrado.getIdArea());

            this.selectedTipo = matencontrado.getIdTipomaterial();
            listSF = sff.listAL(this.selectedTipo.getIdTipomaterial());
            //setSelectedSubFamilia(matencontrado.getSubFamiliasidsubFam());
            this.selectedSubFamilia = matencontrado.getSubFamiliasidsubFam();
            almacen = matencontrado.getAlmacenIdalmacen().getIdalmacen().toString();
            imagen = matencontrado.getImagen();

            System.out.println("TIPO DE MAT:" + selectedTipo);
            System.out.println("SUBFAMILIA:" + selectedSubFamilia);

            habilitarTab = false;
            material2 = null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Material no existente"));
            habilitarTab = true;
            listaEtiquetas = null;
            material2 = null;
        }

    }

    public void prueba2() {
        /* lista.add("Numero de parte:");
         lista.add("Nombre:");
         lista.add("Descripcion:");
         lista.add("Stock:");
         lista.add("Ubicacion actual:");
         lista.add("Marca:");
         lista.add("Responsable:");
         lista.add("Almacen:");
         lista.add("Area:");
         lista.add("Tipo de material:");
         lista.add("Subfamilia:");  */
        listaEtiquetas = getList();
        System.out.println(listaEtiquetas);
    }

    @PostConstruct
    private void init() {
        this.listArea = arf.listAr();

    }

    public List<materialBusqueda> getList() {
        List<materialBusqueda> list = new ArrayList<>();

        //public Productos(String numPart, String nombre, String descripcion, String marca)  
        list.add(new materialBusqueda("Numero de parte:", matencontrado.getNoParte()));
        list.add(new materialBusqueda("Nombre:", matencontrado.getNombre()));
        list.add(new materialBusqueda("Descripcion:", matencontrado.getDescripcion()));
        list.add(new materialBusqueda("Stock:", matencontrado.getStock().toString()));
        list.add(new materialBusqueda("Ubicacion actual:", matencontrado.getUbicacionActual()));
        list.add(new materialBusqueda("Marca:", matencontrado.getMarca()));
        list.add(new materialBusqueda("Responsable:", matencontrado.getResponsable()));
        list.add(new materialBusqueda("Almacen:", matencontrado.getAlmacenIdalmacen().getDescripcion()));
        list.add(new materialBusqueda("Area:", matencontrado.getIdArea().getDescripcion()));
        list.add(new materialBusqueda("Tipo de material:", matencontrado.getIdTipomaterial().getDescripcion()));
        list.add(new materialBusqueda("Subfamilia", matencontrado.getSubFamiliasidsubFam().getNombre()));

        return list;
    }

    public void typeListener(ValueChangeEvent e) {
        System.out.println("ENTRO LISTENER DE TIPOS");
        if (e != null) {

            if (e.getNewValue() != null) {

                this.selectedTipo = (TblTipomaterial) e.getNewValue(); // comprobar que nosea nulo antes de seguir
//                System.out.println(this.selectedType);
//                tipos.clear();
                listSF = sff.listAL(this.selectedTipo.getIdTipomaterial());
                this.selectedSubFamilia = null;

            } else {

                listSF = null;
                this.selectedSubFamilia = null;
                this.selectedTipo = null;
            }
            //  RequestContext.getCurrentInstance().update("form:subFam");
        }
    }

    public void areasListener(ValueChangeEvent e) {
        System.out.println("ENTRO EL LISTENER DE AREAS");
        if (e != null) {

            if (e.getNewValue() != null) {
                System.out.println(e.getNewValue().toString());
                this.selectedArea = (TblArea) e.getNewValue(); // comprobar que nosea nulo antes de seguir
//                System.out.println(this.selectedType);
//                tipos.clear();
                listTM = tmf.listAtm(this.selectedArea.getIdArea());
                this.selectedTipo = null;
                this.selectedSubFamilia = null;
                listSF = null;

            } else {
                listTM = null;
                listSF = null;
                this.selectedSubFamilia = null;
                this.selectedTipo = null;
            }
            RequestContext.getCurrentInstance().update("formadatos:tbw1:tipo");
        }
    }

    public void modificarMat() {
        boolean ex;
        System.out.println("TIPO DE MAT:" + this.selectedTipo);
        System.out.println("SUBFAMILIA:" + this.selectedSubFamilia);
        System.out.println("AREA: " + this.selectedArea);
        if (this.selectedArea == null || this.selectedTipo == null || this.selectedSubFamilia == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "debes seleccionar las categorias"));

            //  RequestContext.getCurrentInstance().update("menu:f2:growlcq");
        } else {
            ex = mf.modificar(matencontrado.getIdtblMaterial(), nombre, noParte, descripcion, cantidad, costo, unidadmedida, marca, serie, estado, ubicacion, responsable, probedor, noFactura, ordenDcompra, zip, financiamiento, tipodecompra, idUABC, fecharecepcion, area, tipodematerial, subfamilia, almacen, imagen, this.selectedArea, this.selectedTipo, this.selectedSubFamilia,showinquery);

            if (ex == false) {
             beanuser.acciones("Material Modificado: " + nombre + ", " + "cantidad: " + cantidad, noParte);
                nombre = null;
                noParte = null;
                descripcion = null;
                cantidad = null;
                costo = null;
                unidadmedida = null;
                marca = null;
                serie = null;
                estado = null;
                ubicacion = null;
                responsable = null;
                probedor = null;
                noFactura = null;
                ordenDcompra = null;
                zip = null;
                financiamiento = null;
                tipodecompra = null;
                idUABC = null;
                fecharecepcion = null;
                area = null;
                tipodematerial = null;
                subfamilia = null;
                almacen = null;
                imagen = null;
                selectedArea=null;
                selectedSubFamilia=null;
                selectedTipo=null;
               beanmat.setActiveIndex("0");
               habilitarTab=true;
                System.out.println("creando msj growl");
                //disableTab1 = false;
                //  disableTab2 = true;
                //  disableTab3 = true;
                //  disableGuardar = true;
                //  activeIndex = "0";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado!", "El material se ha agregado con exito!!"));

                // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Existen parametros unicos ya existentes en la base de datos"));
            }
        }
    }

    public void pruebasf() {

        System.out.println("TIPO DE MAT:" + this.selectedTipo);
        System.out.println("SUBFAMILIA:" + this.selectedSubFamilia);
        System.out.println("AREA: " + this.selectedArea);

    }
}
