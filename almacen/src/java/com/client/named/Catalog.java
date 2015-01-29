/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.SubfamiliasFacade;
import com.server.beans.staless.TblAreaFacade;
import com.server.beans.staless.TblMaterialFacade;
import com.server.entity.beans.TblTipomaterial;
import com.util.AreasDTO;
import com.util.SubFamDTO;
import com.util.TipoDTO;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author NORE
 */
@Named("catalog")
@SessionScoped
public class Catalog implements Serializable {

    @EJB
    TblAreaFacade areaFacade;

    @EJB
    TblMaterialFacade mtl;

    private TreeNode root;

    private TreeNode selectedNode;

    private List<AreasDTO> areas;

    private List<TipoDTO> tipos;
    private Map<String, List<SubFamDTO>> dynamicSubs = new HashMap<>();

    private Map<String, List<TipoDTO>> dynamicTypes = new HashMap<>();

    private @Inject
    NewClass nm;

    @Inject
    DataGridSearch dg;

    public Catalog() {
        areas = new ArrayList<>();
        tipos = new ArrayList<>();
    }

    @PostConstruct
    private void init() {
        System.out.println("si se invoca el init de catalog");
        root = new DefaultTreeNode("Root", root);
        updateTree();

    }

    public void updateTree() {

        if (!(root.getChildCount() > 0)) {
            createTree();
        } else {
            //System.out.println("ACTUALIZANDO EL ARBOL");
            root.getChildren().clear();
            areas.clear();
            tipos.clear();
            dynamicTypes.clear();
            dynamicSubs.clear();
            createTree();
        }
    }

    private void createTree() {
        List<AreasDTO> areasLocal = areaFacade.getCategories();
        if (areasLocal != null) {
            areas.addAll(areasLocal);
            dg.setAreas(areas);
            for (AreasDTO areasDTO : areasLocal) {
                TreeNode node = new DefaultTreeNode(areasDTO, root);
                System.out.println("- " + areasDTO.getNombre());
                List<TipoDTO> tiposLocal = areasDTO.getTipo();

                if (tiposLocal != null) {
                    tipos.addAll(tiposLocal);
                    dynamicTypes.put(areasDTO.toString(), tiposLocal);
                    for (TipoDTO type : tiposLocal) {
                        TreeNode node1 = new DefaultTreeNode(type, node);
                        System.out.println("    - " + type.getNombre());
                        List<SubFamDTO> famsLocal = type.getFams();

                        if (famsLocal != null) {
                            dynamicSubs.put(type.toString(), famsLocal);
                            for (SubFamDTO sub : famsLocal) {
                                TreeNode node2 = new DefaultTreeNode(sub, node1);
                                System.out.println("         -" + sub.getNombre());
                            }
                        }
                    }
                }
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void onNodeSelect(NodeSelectEvent event) throws IOException {
        System.out.println("si se invoca el metodo del node selected");
        Object obj = event.getTreeNode().getData();
        nm.setCaja(null);
        nm.setTypeOfSearch(2);

        if (obj instanceof SubFamDTO) {//1

            dg.setPartes(mtl.catalogFindBySubFam(((SubFamDTO) obj).getId()));
            System.out.println("si es instance de subs");
            dg.setTypesList(findArea(null, (SubFamDTO) obj).getTipo());
            for (Map.Entry<String, List<SubFamDTO>> entry : dynamicSubs.entrySet()) {
                String str = entry.getKey();
                List<SubFamDTO> list = entry.getValue();
                for (SubFamDTO sub : list) {
                    if (sub.equals(obj)) {
                        for (TipoDTO type : tipos) {
                            if (type.toString().equals(str)) {
                                dg.setSelectedType(type);
                                dg.setFamsList(this.dynamicSubs.get((type).toString()));

                                dg.setSelectedArea(findArea((TipoDTO) type, null));
                            }
                        }
                    }
                }

                dg.setSelectedFam((SubFamDTO) obj);
            }

        } else if (obj instanceof TipoDTO) {//2

            /*  for (Map.Entry<String, List<TipoDTO>> entry : dynamicTypes.entrySet()) {
             String str = entry.getKey();
             List<TipoDTO> list = entry.getValue();
             for (TipoDTO sub : list) {
             if (sub.equals(obj)) {
             for (AreasDTO type : areas) {
             if (type.toString().equals(str)) {
             dg.setSelectedArea(type);
                            
             }
             }
             }
             }

             }*/
            dg.setSelectedArea(findArea((TipoDTO) obj, null));

            dg.setTypesList(findArea((TipoDTO) obj, null).getTipo());
            dg.setSelectedType((TipoDTO) obj);
            dg.setFamsList(this.dynamicSubs.get((obj).toString()));
            dg.setSelectedFam(null);
            System.out.println("si es instance de tipos");
            dg.setPartes(mtl.catalogFindByType(((TipoDTO) obj).getId()));

        } else if (obj instanceof AreasDTO) {//3
            System.out.println("si es instance de areas");

            dg.setAreas(this.areas);
            dg.setSelectedArea(((AreasDTO) obj));

            dg.setTypesList(((AreasDTO) obj).getTipo());
            dg.setSelectedType(null);
            dg.setFamsList(null);
            dg.setSelectedFam(null);
            dg.setPartes(mtl.catalogFindByArea(((AreasDTO) obj).getId()));
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("productGrid.xhtml");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", obj.toString());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<AreasDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreasDTO> areas) {
        this.areas = areas;
    }

    public List<TipoDTO> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoDTO> tipos) {
        this.tipos = tipos;
    }

    public Map<String, List<SubFamDTO>> getDynamicSubs() {
        return dynamicSubs;
    }

    public void setDynamicSubs(Map<String, List<SubFamDTO>> dynamicSubs) {
        this.dynamicSubs = dynamicSubs;
    }

    public Map<String, List<TipoDTO>> getDynamicTypes() {
        return dynamicTypes;
    }

    public AreasDTO findArea(TipoDTO tipo, SubFamDTO sub) {
        if (tipo != null) {
            for (AreasDTO areasDTO : areas) {
                for (TipoDTO types : areasDTO.getTipo()) {
                    if (types.equals(tipo)) {
                        return areasDTO;
                    }
                }
            }
        }

        if (sub != null) {
            TipoDTO tp = null;
            for (Map.Entry<String, List<SubFamDTO>> entry : dynamicSubs.entrySet()) {
                String str = entry.getKey();
                List<SubFamDTO> list = entry.getValue();
                for (SubFamDTO subs : list) {
                    if (subs.equals(sub)) {
                        for (TipoDTO type : tipos) {
                            if (type.toString().equals(str)) {
                                tp = type;
                            }
                        }
                    }
                }

            }

            for (AreasDTO areasDTO : areas) {
                for (TipoDTO types : areasDTO.getTipo()) {
                    if (types.equals(tp)) {
                        return areasDTO;
                    }
                }
            }
        }

        return null;
    }

}
