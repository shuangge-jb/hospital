package persistance;
// default package

import java.sql.Timestamp;


/**
 * Registration entity. @author MyEclipse Persistence Tools
 */

public class Registration  implements java.io.Serializable {


    // Fields    

     private Integer registrationId;
     private User user;
     private Period period;
     private Hospital hospital;
     private Department department;
     private Doctor doctor;
     private Timestamp submitTime;
     private String state;


    // Constructors

    /** default constructor */
    public Registration() {
    }

    
    /** full constructor */
    public Registration(User user, Period period, Hospital hospital, Department department, Doctor doctor, Timestamp submitTime, String state) {
        this.user = user;
        this.period = period;
        this.hospital = hospital;
        this.department = department;
        this.doctor = doctor;
        this.submitTime = submitTime;
        this.state = state;
    }

   
    // Property accessors

    public Integer getRegistrationId() {
        return this.registrationId;
    }
    
    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
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

    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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