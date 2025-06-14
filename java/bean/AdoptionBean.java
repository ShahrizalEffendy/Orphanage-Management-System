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
public class AdoptionBean {
    private String name;
    private String p_name;
    private int age;
    private int p_age;
    private String address;
    private String contact;
    private String p_contact;
    private String occupation;
    private String child_name;
    private int child_age;
    private String gender;

    public AdoptionBean(String name, String p_name, int age, int p_age, String address, String contact, String p_contact, String occupation, String child_name, int child_age, String gender) {
        this.name = name;
        this.p_name = p_name;
        this.age = age;
        this.p_age = p_age;
        this.address = address;
        this.contact = contact;
        this.p_contact = p_contact;
        this.occupation = occupation;
        this.child_name = child_name;
        this.child_age = child_age;
        this.gender = gender;
    }
    
    public AdoptionBean() {
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getP_age() {
        return p_age;
    }

    public void setP_age(int p_age) {
        this.p_age = p_age;
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

    public String getP_contact() {
        return p_contact;
    }

    public void setP_contact(String p_contact) {
        this.p_contact = p_contact;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public int getChild_age() {
        return child_age;
    }

    public void setChild_age(int child_age) {
        this.child_age = child_age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}
