package persistance;
// default package

import persistance.Period;


/**
 * Registration entity. @author MyEclipse Persistence Tools
 */

public class Registration  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Doctor doctor;
     private Department department;
     private Period period;


    // Constructors

    /** default constructor */
    public Registration() {
    }

    
    /** full constructor */
    public Registration(Doctor doctor, Department department, Period period) {
        this.doctor = doctor;
        this.department = department;
        this.period = period;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Period getPeriod() {
        return this.period;
    }
    
    public void setPeriod(Period period) {
        this.period = period;
    }
   








}