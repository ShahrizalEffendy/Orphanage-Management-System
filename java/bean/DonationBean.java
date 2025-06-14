/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Vaio
 */
public class DonationBean implements java.io.Serializable{
    
    String item;
    int quantity;
    int id;

    public DonationBean(String item, int quantity, int id) {
        this.item = item;
        this.quantity = quantity;
        this.id = id;
    }
   

    public DonationBean() {
    }

    

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
