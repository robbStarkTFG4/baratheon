/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entitys.Tblclientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cristian
 */
@Stateless
public class TblclientesFacade extends AbstractFacade<Tblclientes> {
    @PersistenceContext(unitName = "MRPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblclientesFacade() {
        super(Tblclientes.class);
    }
    
}
