/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.beans.staless;

import com.server.entity.beans.TblTipousuarios;
import com.server.entity.beans.TblUsuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NORE
 */
@Stateless
public class TblUsuariosFacade extends AbstractFacade<TblUsuarios> {
    @PersistenceContext(unitName = "webAppPU")
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
        //TypedQuery<TblUsuarios> search =em.createQuery("SELECT NEW entity.TblUsuarios(u.idTipousuarios,u.usuario) FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave",TblUsuarios.class);
        Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario and u.contraseña=:clave");
        search.setParameter("usuario", usuario);
        search.setParameter("clave", clave);
            user = (TblUsuarios) search.getSingleResult();
        } catch (Exception e) {
            return user;//System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        } finally {
            return user;
        }
   
        
} 
   public boolean agregar (String nombre,String clave,String apellidop,String apellidom, String tipous, String email, String tel,String usuario){ 
    boolean existe = true;
       TblUsuarios id=null;   
   Query search = em.createQuery("SELECT t FROM TblUsuarios t WHERE t.usuario = :usuario OR t.email = :correo");
        search.setParameter("usuario",usuario);
        search.setParameter("correo", email);
   try{
        id=(TblUsuarios)search.getSingleResult();
   
   
   } catch (Exception e) {
   TblUsuarios us=new TblUsuarios();
   TblTipousuarios tu=new TblTipousuarios();
   us.setNombre(nombre);
   us.setContraseña(clave);
   us.setApellidop(apellidop);
   us.setApellidom(apellidom);
   tu.setIdTipousuarios(tipous);
   us.setIdTipousuarios(tu);
   us.setEmail(email);
   us.setTel(tel);
   us.setUsuario(usuario);
    getEntityManager().persist(us);
    existe=false;
   System.out.println("Usuario creado");  
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return existe;
   }
   
   public boolean eliminar (String usuario){
       
          
          try{
              
           Query search= em.createQuery("SELECT t FROM TblUsuarios t WHERE t.usuario = :usuario");
          search.setParameter("usuario", usuario);  
            TblUsuarios pres =(TblUsuarios)search.getSingleResult();
          em.remove(pres);
          System.out.println("Prestario con matricula: "+usuario+" ELIMINADO");
          return true;
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
             return false;
        }
        
  
   
    }
   
   
 public List usuarios(String patron){
     
  List<String> list = null ;    
     
     try{
              
           Query search= em.createQuery("SELECT t.usuario FROM TblUsuarios t WHERE t.usuario LIKE :patron");
           search.setParameter("patron", patron.toLowerCase()+"%"); 
            list=search.getResultList();
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
        Query search = em.createQuery("SELECT u FROM TblUsuarios u WHERE u.usuario=:usuario" );
        search.setParameter("usuario", usuario);
        
            user = (TblUsuarios) search.getSingleResult();
            System.out.println("usuario encontrado");
        } catch (Exception e) {
            return user;//System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        } finally {
            return user;
        }
   
        
}    
  public List listausuariosSS (){
     List< TblUsuarios> lista=null;
      String usuario="[entity.TblTipousuarios[ idTipousuarios=uss ]]";
   try{
              
           Query search= em.createQuery("SELECT u FROM TblUsuarios u WHERE u.idTipousuarios=:usuario" );
            search.setParameter("usuario", usuario);
        
            lista=search.getResultList();
          System.out.println("usuarios del servicio social");
          System.out.println(lista);

         
        } catch (Exception e) {
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
            
        }
  
  return lista;
  
  
  } 
     public boolean modificar (int id,String nombre,String clave,String apellidop,String apellidom, String tipous, String email, String tel,String usuario){ 
    boolean existe = true;
    
     TblUsuarios busc;  
     Query search = em.createQuery("SELECT t FROM TblUsuarios t WHERE t.email = :correo");
       
        search.setParameter("correo", email);
   try{
        busc=(TblUsuarios)search.getSingleResult();
        if(usuario.equals(busc.getUsuario())){
        TblUsuarios us= em.find(TblUsuarios.class, id);
   TblTipousuarios tu=new TblTipousuarios();
   us.setNombre(nombre);
   us.setContraseña(clave);
   us.setApellidop(apellidop);
   us.setApellidom(apellidom);
   tu.setIdTipousuarios(tipous);
   us.setIdTipousuarios(tu);
   us.setEmail(email);
   us.setTel(tel);
   us.setUsuario(usuario);
    getEntityManager().persist(us);
   
   System.out.println("Usuario creado");  
   existe=false;
  
        }
        else{
        existe=true;
        }
   
   
   } catch (Exception e) {
    TblUsuarios us= em.find(TblUsuarios.class, id);
   TblTipousuarios tu=new TblTipousuarios();
   us.setNombre(nombre);
   us.setContraseña(clave);
   us.setApellidop(apellidop);
   us.setApellidom(apellidom);
   tu.setIdTipousuarios(tipous);
   us.setIdTipousuarios(tu);
   us.setEmail(email);
   us.setTel(tel);
   us.setUsuario(usuario);
    getEntityManager().persist(us);
    existe=false;
   System.out.println("Usuario creado");  
            System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        }
        return existe;
   }
   
}
