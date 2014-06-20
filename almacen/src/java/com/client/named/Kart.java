/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.entity.beans.TblMaterial;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("ka")
@SessionScoped
public class Kart implements Serializable {

    private int quantity = 0;
    
    private TblMaterial current;

    public void spinnerListener() {

    }
    
    public void addToCart(){
        
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TblMaterial getCurrent() {
        return current;
    }

    public void setCurrent(TblMaterial current) {
        this.current = current;
    }

}
