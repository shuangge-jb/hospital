package persistance;
// default package

import java.util.HashSet;
import java.util.Set;
import persistance.Hospital;


/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Hospital hospital;
     private String type;
     private String name;
     private Set registrations = new HashSet(0);
     private Set doctors = new HashSet(0);


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(Hospital hospital, String type, String name) {
        this.hospital = hospital;
        this.type = type;
        this.name = name;
    }
    
    /** full constructor */
    public Department(Hospital hospital, String type, String name, Set registrations, Set doctors) {
        this.hospital = hospital;
        this.type = type;
        this.name = name;
        this.registrations = registrations;
        this.doctors = doctors;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return this.hospital;
    }
    
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getRegistrations() {
        return this.registrations;
    }
    
    public void setRegistrations(Set registrations) {
        this.registrations = registrations;
    }

    public Set getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set doctors) {
        this.doctors = doctors;
    }
   








}