/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import entitys.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cristian
 */
@Stateless
public class MapFacade extends AbstractFacade<Map> {
    @PersistenceContext(unitName = "AltasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MapFacade() {
        super(Map.class);
    }
    
}
