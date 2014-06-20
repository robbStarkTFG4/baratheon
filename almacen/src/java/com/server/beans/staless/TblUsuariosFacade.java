/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblTipousuarios;
import com.server.entity.beans.TblUsuarios;
import com.util.UsuarioDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class TblUsuariosFacade extends AbstractFacade<TblUsuarios> {

    @PersistenceContext(unitName = "almacenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblUsuariosFacade() {
        super(TblUsuarios.class);
    }

    public TblUsuarios logIn(String usuario, String clave) {

        TblUsuarios user = null;

        try {
            TypedQuery<TblUsuarios> search = em.createQuery("SELECT NEW com.server.entity.beans.TblUsuarios(u.idUsuarios,u.usuario,u.idTipousuarios) FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave", TblUsuarios.class);
            //Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
            search.setParameter("usuario", usuario);
            search.setParameter("clave", clave);
            user = (TblUsuarios) search.getSingleResult();
        } catch (Exception e) {
            System.out.println("");
            return user;//System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        } finally {
            return user;
        }

    }

    public boolean agregar(String nombre, String clave, String apellidop, String apellidom, String tipous, String email, String tel, String usuario) {
        boolean existe = true;
        int id ;
        Query search = em.createQuery("SELECT t.idUsuarios FROM TblUsuarios t WHERE t.usuario = :usuario OR t.email = :correo");
        search.setParameter("usuario", usuario);
        search.setParameter("correo", email);
        try {
            id = (int) search.getSingleResult();

        } catch (Exception e) {
            TblUsuarios us = new TblUsuarios();
            TblTipousuarios tu = new TblTipousuarios();
            us.setNombre(nombre);
            us.setContraseña(clave);
            us.setApellidop(apellidop);
            us.setApellidom(apellidom);
            tu.setIdTipousuarios(Integer.parseInt(tipous));
            us.setIdTipousuarios(tu);
            us.setEmail(email);
            us.setTel(tel);
            us.setUsuario(usuario);
            getEntityManager().persist(us);
            existe = false;
            System.out.println("Usuario creado");
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return existe;
    }

    public boolean eliminar(String usuario) {

        try {

            Query search = em.createQuery("SELECT t FROM TblUsuarios t WHERE t.usuario = :usuario");
            search.setParameter("usuario", usuario);
            TblUsuarios pres = (TblUsuarios) search.getSingleResult();
            em.remove(pres);
            System.out.println("Prestario con matricula: " + usuario + " ELIMINADO");
            return true;
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
            return false;
        }

    }

    public List usuarios(String patron) {

        List<String> list = null;

        try {

            Query search = em.createQuery("SELECT t.usuario FROM TblUsuarios t WHERE t.usuario LIKE :patron");
            search.setParameter("patron", patron.toLowerCase() + "%");
            list = search.getResultList();
            System.out.println("LISTA DE USUARIOS");
            System.out.println(list);

        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }

        return list;
    }

    public TblUsuarios consultamodif(String usuario) {

        TblUsuarios user = null;

        try {
            //TypedQuery<TblUsuarios> search =em.createQuery("SELECT NEW entity.TblUsuarios(u.idTipousuarios,u.usuario) FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave",TblUsuarios.class);
            Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario");
            search.setParameter("usuario", usuario);

            user = (TblUsuarios) search.getSingleResult();
            System.out.println("usuario encontrado");
        } catch (Exception e) {
            return user;//System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        } finally {
            return user;
        }

    }

    public List<UsuarioDTO> listausuariosSS() {
       List< UsuarioDTO> lista = new ArrayList<>();

        try {

            Query search = em.createQuery("SELECT u.nombre, u.apellidop, u.apellidom, u.email, u.tel, u.usuario FROM TblUsuarios u WHERE u.idTipousuarios.idTipousuarios = :tipo");
            search.setParameter("tipo", "uss");
            List obj = search.getResultList();
           
if (obj != null) {
            for (Iterator it = obj.iterator(); it.hasNext();) {
                Object[] object = (Object[]) it.next();
                UsuarioDTO temp = new UsuarioDTO();
                temp.setNombre((String) object[0]);
                temp.setApellidop((String) object[1]);
                temp.setApellidom((String) object[2]);
                temp.setEmail((String) object[3]);
                temp.setTel((String) object[4]);
                temp.setUsuario((String) object[5]);
              
                lista.add(temp);
            }    }
        
            
            
            
            
          //  for (int i = 0; i < lista.size(); i++) {

           //     if (lista.get(i).getIdTipousuarios().getIdTipousuarios().equals("admin")) {
                 //   lista.remove(i);
           //     }
                /*if(lista.get(lista.size()-1).getIdTipousuarios().getIdTipousuarios().equals("admin")){
                 lista.remove(lista.size()-1);
                 }*/
       //     }

            System.out.println(lista);
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }

        return lista;
    }

    public boolean modificar(int id, String nombre, String clave, String apellidop, String apellidom, String tipous, String email, String tel, String usuario) {
        boolean existe = true;

        String busc;
        Query search = em.createQuery("SELECT t.usuario FROM TblUsuarios t WHERE t.email = :correo");

        search.setParameter("correo", email);
        try {
            busc =  (String) search.getSingleResult();
            if (usuario.equals(busc)) {
                TblUsuarios us = em.find(TblUsuarios.class, id);
                TblTipousuarios tu = new TblTipousuarios();
                us.setNombre(nombre);
                us.setContraseña(clave);
                us.setApellidop(apellidop);
                us.setApellidom(apellidom);
                tu.setIdTipousuarios(Integer.parseInt(tipous));
                us.setIdTipousuarios(tu);
                us.setEmail(email);
                us.setTel(tel);
                us.setUsuario(usuario);
                getEntityManager().persist(us);

                System.out.println("Usuario creado");
                existe = false;

            } else {
                existe = true;
            }

        } catch (Exception e) {
            TblUsuarios us = em.find(TblUsuarios.class, id);
            TblTipousuarios tu = new TblTipousuarios();
            us.setNombre(nombre);
            us.setContraseña(clave);
            us.setApellidop(apellidop);
            us.setApellidom(apellidom);
            tu.setIdTipousuarios(Integer.parseInt(tipous));
            us.setIdTipousuarios(tu);
            us.setEmail(email);
            us.setTel(tel);
            us.setUsuario(usuario);
            getEntityManager().persist(us);
            existe = false;
            System.out.println("Usuario creado");
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return existe;
    }

    public TblUsuarios findBasicInfo(String user) {
        Query query = em.createQuery("SELECT c.nombre, c.apellidop, c.apellidom, c.email, c.tel,  c.usuario FROM TblUsuarios c WHERE c.usuario = :usuario  ");
        query.setParameter("usuario", user);

        TblUsuarios res = new TblUsuarios();

        Object[] object = (Object[]) query.getSingleResult();
        res.setNombre((String) object[0]);
        res.setApellidop((String) object[1]);
        res.setApellidom((String) object[2]);
        res.setEmail((String) object[3]);
        res.setTel((String) object[4]);
        res.setUsuario((String) object[5]);
        return res;
    }
}
