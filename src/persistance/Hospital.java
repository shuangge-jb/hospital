package persistance;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Hospital entity. @author MyEclipse Persistence Tools
 */

public class Hospital  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private String name;
     private String address;
     private Set<Doctor> doctors = new HashSet<Doctor>(0);
     private Set<Department> departments = new HashSet<Department>(0);


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
    public Hospital(String name, String address, Set<Doctor> doctors, Set<Department> departments) {
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

    public Set<Doctor> getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Department> getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
   








}