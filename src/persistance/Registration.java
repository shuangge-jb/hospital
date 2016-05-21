package persistance;
// default package

import java.sql.Timestamp;


/**
 * Registration entity. @author MyEclipse Persistence Tools
 */

public class Registration  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User user;
     private Doctor doctor;
     private Department department;
     private Period period;
     private Hospital hospital;
     private Timestamp submitTime;
     private String state;


    // Constructors

    /** default constructor */
    public Registration() {
    }

    
    /** full constructor */
    public Registration(User user, Doctor doctor, Department department, Period period, Hospital hospital, Timestamp submitTime, String state) {
        this.user = user;
        this.doctor = doctor;
        this.department = department;
        this.period = period;
        this.hospital = hospital;
        this.submitTime = submitTime;
        this.state = state;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
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

    public Hospital getHospital() {
        return this.hospital;
    }
    
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Timestamp getSubmitTime() {
        return this.submitTime;
    }
    
    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
   








}