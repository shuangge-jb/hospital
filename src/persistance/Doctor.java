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
     private Long tel;
     private Set schedules = new HashSet(0);
     private Set registrations = new HashSet(0);


    // Constructors

    /** default constructor */
    public Doctor() {
    }

	/** minimal constructor */
    public Doctor(Department department, Hospital hospital, String name, String sex, Integer age, Long tel) {
        this.department = department;
        this.hospital = hospital;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
    }
    
    /** full constructor */
    public Doctor(Department department, Hospital hospital, String name, String sex, Integer age, Long tel, Set schedules, Set registrations) {
        this.department = department;
        this.hospital = hospital;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.schedules = schedules;
        this.registrations = registrations;
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

    public Long getTel() {
        return this.tel;
    }
    
    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Set getSchedules() {
        return this.schedules;
    }
    
    public void setSchedules(Set schedules) {
        this.schedules = schedules;
    }

    public Set getRegistrations() {
        return this.registrations;
    }
    
    public void setRegistrations(Set registrations) {
        this.registrations = registrations;
    }
   








}