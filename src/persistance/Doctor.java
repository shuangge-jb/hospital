package persistance;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Doctor entity. @author MyEclipse Persistence Tools
 */

public class Doctor  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Department department;
     private Hospital hospital;
     private String name;
     private String sex;
     private Integer age;
     private String tel;
     private Set workTimes = new HashSet(0);
     private Set schedules = new HashSet(0);
     private Set schedules_1 = new HashSet(0);
     private Set registrations = new HashSet(0);
     private Set registrations_1 = new HashSet(0);


    // Constructors

    /** default constructor */
    public Doctor() {
    }

	/** minimal constructor */
    public Doctor(Department department, Hospital hospital, String name, String sex, Integer age, String tel) {
        this.department = department;
        this.hospital = hospital;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
    }
    
    /** full constructor */
    public Doctor(Department department, Hospital hospital, String name, String sex, Integer age, String tel, Set workTimes, Set schedules, Set schedules_1, Set registrations, Set registrations_1) {
        this.department = department;
        this.hospital = hospital;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.workTimes = workTimes;
        this.schedules = schedules;
        this.schedules_1 = schedules_1;
        this.registrations = registrations;
        this.registrations_1 = registrations_1;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Hospital getHospital() {
        return this.hospital;
    }
    
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set getWorkTimes() {
        return this.workTimes;
    }
    
    public void setWorkTimes(Set workTimes) {
        this.workTimes = workTimes;
    }

    public Set getSchedules() {
        return this.schedules;
    }
    
    public void setSchedules(Set schedules) {
        this.schedules = schedules;
    }

    public Set getSchedules_1() {
        return this.schedules_1;
    }
    
    public void setSchedules_1(Set schedules_1) {
        this.schedules_1 = schedules_1;
    }

    public Set getRegistrations() {
        return this.registrations;
    }
    
    public void setRegistrations(Set registrations) {
        this.registrations = registrations;
    }

    public Set getRegistrations_1() {
        return this.registrations_1;
    }
    
    public void setRegistrations_1(Set registrations_1) {
        this.registrations_1 = registrations_1;
    }
   








}