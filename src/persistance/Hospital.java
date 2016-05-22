package persistance;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Hospital entity. @author MyEclipse Persistence Tools
 */

public class Hospital  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String address;
     private Set departments = new HashSet(0);
     private Set doctors = new HashSet(0);
     private Set registrations = new HashSet(0);
     private Set doctors_1 = new HashSet(0);
     private Set departments_1 = new HashSet(0);


    // Constructors

    /** default constructor */
    public Hospital() {
    }

	/** minimal constructor */
    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    /** full constructor */
    public Hospital(String name, String address, Set departments, Set doctors, Set registrations, Set doctors_1, Set departments_1) {
        this.name = name;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.registrations = registrations;
        this.doctors_1 = doctors_1;
        this.departments_1 = departments_1;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public Set getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Set departments) {
        this.departments = departments;
    }

    public Set getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set doctors) {
        this.doctors = doctors;
    }

    public Set getRegistrations() {
        return this.registrations;
    }
    
    public void setRegistrations(Set registrations) {
        this.registrations = registrations;
    }

    public Set getDoctors_1() {
        return this.doctors_1;
    }
    
    public void setDoctors_1(Set doctors_1) {
        this.doctors_1 = doctors_1;
    }

    public Set getDepartments_1() {
        return this.departments_1;
    }
    
    public void setDepartments_1(Set departments_1) {
        this.departments_1 = departments_1;
    }
   








}