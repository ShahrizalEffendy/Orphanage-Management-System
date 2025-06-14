/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author User
 */
public class AdminBean {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String username;
    private String password;
    private String cpassword;

    public AdminBean(int id, String name, String address, String contact, String username, String password, String cpassword) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.cpassword = cpassword;
    }
    
     public AdminBean() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
     
     
}
