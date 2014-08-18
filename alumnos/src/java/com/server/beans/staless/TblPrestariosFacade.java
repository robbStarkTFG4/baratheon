/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.beans.staless;

import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblTipoprestarios;
import com.util.PrestarioDTO;
import java.util.ArrayList;
import java.util.HashSet;
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
public class TblPrestariosFacade extends AbstractFacade<TblPrestarios> {

    @PersistenceContext(unitName = "alumnosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblPrestariosFacade() {
        super(TblPrestarios.class);
    }

    public TblPrestarios getPresForActivation(String matricula) {
        TypedQuery<TblPrestarios> query = em.createQuery("SELECT c FROM TblPrestarios c WHERE c.usuario = :usuario", TblPrestarios.class);
        query.setParameter("usuario", matricula);
        TblPrestarios res = null;
        try {
            res = (TblPrestarios) query.getSingleResult();
            return res;
        } catch (javax.persistence.NoResultException e) {
            //   e.printStackTrace();
            return null;
        }

    }

    //TblPrestarios(Integer idPrestario, String nombre, String apaterno, String amaterno, String tel, String email, String usuario, String carrera)
    public TblPrestarios getPres(String matricula) {
        Query query = em.createQuery("SELECT NEW com.server.entity.beans.TblPrestarios(c.idPrestario, c.nombre, c.apaterno, c.amaterno, c.tel , c.email, c.usuario, c.carrera, c.activo) FROM TblPrestarios c WHERE c.usuario = :usuario");
        query.setParameter("usuario", matricula);
        TblPrestarios res = null;
        try {
            res = (TblPrestarios) query.getSingleResult();
            return res;
        } catch (javax.persistence.NoResultException e) {
            //   e.printStackTrace();
            return null;
        }

    }

    public int validar(String matricula) {
        try {
            System.out.println("METODO VALIDAR-FACADE");
            Query search = em.createQuery("SELECT t.idPrestario FROM TblPrestarios t WHERE t.usuario = :usuario").setParameter("usuario", matricula);
            //search.setParameter("usuario", matricula);
            int obj = (int) search.getSingleResult();
            System.out.println(obj);
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return 0;
    }

    public boolean registerPrestario(TblPrestarios prestario) {
        try {
            prestario.setActivo(0);
            this.create(prestario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean agregar(String nombre, String apaterno, String amaterno, int tipo, String tel, String email, String usuario, String carrera) {

        boolean existe = true;
        int id;
        Query search = em.createQuery("SELECT t.idPrestario FROM TblPrestarios t WHERE t.usuario = :usuario OR t.email = :correo");
        search.setParameter("usuario", usuario);
        search.setParameter("correo", email);
        try {
            id = (int) search.getSingleResult();

        } catch (Exception e) {
            TblPrestarios pres = new TblPrestarios();
            pres.setNombre(nombre);
            pres.setApaterno(apaterno);
            pres.setAmaterno(amaterno);
            pres.setTel(tel);
            pres.setCarrera(carrera);
            pres.setEmail(email);
            pres.setUsuario(usuario);

            TblTipoprestarios tp = new TblTipoprestarios();
            tp.setIdTipoprestarios(tipo);
            pres.setIdTipoprestarios(tp);

            getEntityManager().persist(pres);
            existe = false;
            System.out.println("Usuario creado");
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return existe;

    }

    public boolean eliminar(String matricula) {
        try {

            Query search = em.createQuery("SELECT t FROM TblPrestarios t WHERE t.usuario = :usuario");
            search.setParameter("usuario", matricula);
            TblPrestarios pres = (TblPrestarios) search.getSingleResult();
            em.remove(pres);
            System.out.println("Prestario con matricula: " + matricula + " ELIMINADO");
            return true;
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
            return false;
        }

    }

    public List usuarios() {

        List<String> list = null;

        try {

            Query search = em.createQuery("SELECT t.usuario FROM TblPrestarios t");
            list = search.getResultList();
            System.out.println("LISTA DE prestarios");
            System.out.println(list);

        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }

        return list;
    }

    public List prestarios(String patron) {

        List<String> list = null;

        try {

            Query search = em.createQuery("SELECT t.usuario FROM TblPrestarios t WHERE t.usuario LIKE :patron");
            search.setParameter("patron", patron.toLowerCase() + "%");
            list = search.getResultList();
            System.out.println("LISTA DE USUARIOS");
            System.out.println(list);

        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());

        }

        return list;
    }

    public TblPrestarios consultamodif(String usuario) {

        TblPrestarios user = null;

        try {
            //TypedQuery<TblUsuarios> search =em.createQuery("SELECT NEW entity.TblUsuarios(u.idTipousuarios,u.usuario) FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave",TblUsuarios.class);
            Query search = em.createQuery("SELECT u FROM TblPrestarios u WHERE u.usuario=:usuario");
            search.setParameter("usuario", usuario);

            user = (TblPrestarios) search.getSingleResult();
            System.out.println("usuario encontrado");
        } catch (Exception e) {
            return user;//System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        } finally {
            return user;
        }

    }

    public boolean modificar(int id, String nombre, String apaterno, String amaterno, int tipo, String tel, String email, String usuario, String carrera) {

        boolean existe = true;
        String bp;
        Query search = em.createQuery("SELECT t.usuario FROM TblPrestarios t WHERE t.email = :correo");

        search.setParameter("correo", email);
        try {
            bp = (String) search.getSingleResult();
            if (usuario.equals(bp)) {
                TblPrestarios pres = em.find(TblPrestarios.class, id);
                pres.setNombre(nombre);
                pres.setApaterno(apaterno);
                pres.setAmaterno(amaterno);
                pres.setTel(tel);
                pres.setCarrera(carrera);
                pres.setEmail(email);
                pres.setUsuario(usuario);
                TblTipoprestarios tp = new TblTipoprestarios();
                tp.setIdTipoprestarios(tipo);
                pres.setIdTipoprestarios(tp);
                getEntityManager().merge(pres);
                existe = false;
                System.out.println("usuario modificado");

            } else {
                existe = true;
            }
        } catch (Exception e) {
            TblPrestarios pres = em.find(TblPrestarios.class, id);
            pres.setNombre(nombre);
            pres.setApaterno(apaterno);
            pres.setAmaterno(amaterno);
            pres.setTel(tel);
            pres.setCarrera(carrera);
            pres.setEmail(email);
            pres.setUsuario(usuario);
            TblTipoprestarios tp = new TblTipoprestarios();
            tp.setIdTipoprestarios(tipo);
            pres.setIdTipoprestarios(tp);
            getEntityManager().merge(pres);
            existe = false;
            System.out.println("Usuario modificado");
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }

        return existe;

    }

    public List<PrestarioDTO> Morosos() {
        List<PrestarioDTO> list = new ArrayList<>();

        try {
            //  t.idPrestario.nombre, t.idPrestario.apaterno, t.idPrestario.amaterno, t.idPrestario.email, t.idPrestario.tel, t.idPrestario.usuario, t.idPrestario.carrera 
            Query search1 = em.createQuery("SELECT  t.idPrestario FROM TblPrestamo t WHERE t.statusprestamo = :status OR t.statusprestamo = :status1");
            search1.setParameter("status", 1);
            search1.setParameter("status1", 2);
            List<TblPrestarios> obj = search1.getResultList();

            if (obj != null) {
                HashSet hs = new HashSet();
                hs.addAll(obj);
                obj.clear();
                obj.addAll(hs);
                System.out.println(obj);
                for (int i = 0; i < obj.size(); i++) {

                    PrestarioDTO temp = new PrestarioDTO();
                    temp.setNombre((String) obj.get(i).getNombre());
                    temp.setApaterno((String) obj.get(i).getApaterno());
                    temp.setAmaterno((String) obj.get(i).getAmaterno());
                    temp.setEmail((String) obj.get(i).getEmail());
                    temp.setTel((String) obj.get(i).getTel());
                    temp.setUsuario((String) obj.get(i).getUsuario());
                    temp.setCarrera((String) obj.get(i).getCarrera());

                    list.add(temp);

                }

            }

//Iterator li=list.iterator();
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }

        return list;

    }

    public void enable(Integer idPrestario) {
        TypedQuery<TblPrestarios> query = em.createQuery("SELECT c FROM TblPrestarios c WHERE c.idPrestario = :id", TblPrestarios.class);
        query.setParameter("id", idPrestario);
        TblPrestarios temp = query.getSingleResult();

        temp.setActivo(1);
        em.merge(temp);
    }

    public boolean isAvailable(Integer mat) {

        TypedQuery<TblPrestarios> query = em.createQuery("SELECT c FROM TblPrestarios c WHERE c.usuario = :mat", TblPrestarios.class);
        query.setParameter("mat", String.valueOf(mat));

        try {
            TblPrestarios res = query.getSingleResult();
            if (res != null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }

    }
}
