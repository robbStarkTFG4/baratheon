/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entitys.Tblactividadalmacen;
import entitys.Tblalmacen;
import entitys.Tbllocacion;
import entitys.Tblmateria;
import entitys.Tblordencliente;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cristian
 */
@Stateless
public class TblalmacenFacade extends AbstractFacade<Tblalmacen> {
    @PersistenceContext(unitName = "MRPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblalmacenFacade() {
        super(Tblalmacen.class);
    }
  
    
    public void agregarAlmacen(Tblmateria mat,Tblordencliente orcl, String cantidad, String locacion){
 int locacionreal;
        
        switch(locacion)  {
            case "A1":locacionreal=1;
                break;
                case "B1":locacionreal=2;
                break;
                    case "C1":locacionreal=3;
                break;
                        case "A2":locacionreal=5;
                break;
                            case "B2":locacionreal=6;
                break;
                                case "C2":locacionreal=7;
                break;
                                    default:locacionreal=4;
                break;
  
  }    
        
        
    Date fechacap = new Date();
    
      SimpleDateFormat ft = 
      new SimpleDateFormat ("dd/MM/yy");
  try{
/* String sumaCant=Integer.toString(Integer.parseInt(mat.getStock())+Integer.parseInt(cantidad));
      System.out.println("SUMA A STOCK");
*/
   int p=mat.getStock();
   int cc=(int) Float.parseFloat(cantidad);
   int suma=p+cc;
   mat.setStock(suma);
   getEntityManager().merge(mat);
      System.out.println(suma);
   Tblalmacen objalma =new Tblalmacen();
  Tblactividadalmacen aa=new Tblactividadalmacen();
  objalma.setCanridad(cantidad);
  objalma.setFechaMovimiento(ft.format(fechacap));
  objalma.setDescripcion("LLegada a almacen");
  aa.setIdTblActividadalmacen(1);
  objalma.setTblActividadalmacenidTblActividadalmacen(aa);
  Tbllocacion loc =new Tbllocacion();
  loc.setIdTblLocacion(locacionreal);
  objalma.setTblLocacionidTblLocacion(loc);
  objalma.setTblMateriaidTblMateria(mat);
  objalma.setTblOrdenclienteidTblOrdencliente(orcl);
  getEntityManager().persist(objalma);

  }catch(Exception e)    {
      System.out.println(e);
  } 
   
   
   
   
   } 
}
