package persistance;
// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String userName;
     private String userPwd;
     private String userRealname;
     private String sex;
     private String address;
     private String tel;
     private String identificationId;
     private Date birthday;
     private Integer balance;
     private Set registrations = new HashSet(0);


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(String userName, String userPwd, String userRealname, String sex, String address, String tel, String identificationId, Date birthday, Integer balance) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRealname = userRealname;
        this.sex = sex;
        this.address = address;
        this.tel = tel;
        this.identificationId = identificationId;
        this.birthday = birthday;
        this.balance = balance;
    }
    
    /** full constructor */
    public User(String userName, String userPwd, String userRealname, String sex, String address, String tel, String identificationId, Date birthday, Integer balance, Set registrations) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRealname = userRealname;
        this.sex = sex;
        this.address = address;
        this.tel = tel;
        this.identificationId = identificationId;
        this.birthday = birthday;
        this.balance = balance;
        this.registrations = registrations;
    }

   
    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return this.userPwd;
    }
    
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserRealname() {
        return this.userRealname;
    }
    
    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdentificationId() {
        return this.identificationId;
    }
    
    public void setIdentificationId(String identificationId) {
        this.identificationId = identificationId;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getBalance() {
        return this.balance;
    }
    
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Set getRegistrations() {
        return this.registrations;
    }
    
    public void setRegistrations(Set registrations) {
        this.registrations = registrations;
    }

   








}