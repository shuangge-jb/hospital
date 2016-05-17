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
     private Set doctors = new HashSet(0);
     private Set departments = new HashSet(0);


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
    public Hospital(String name, String address, Set doctors, Set departments) {
        this.name = name;
        this.address = address;
        this.doctors = doctors;
        this.departments = departments;
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

    public Set getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set doctors) {
        this.doctors = doctors;
    }

    public Set getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Set departments) {
        this.departments = departments;
    }
   








}