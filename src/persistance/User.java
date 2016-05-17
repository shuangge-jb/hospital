package persistance;
// default package

import java.util.Date;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
     private String userName;
     private String userPwd;
     private String userRealname;
     private String sex;
     private String address;
     private Long tel;
     private Long identificationId;
     private Date birthday;


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String userName, String userPwd, String userRealname, String sex, String address, Long tel, Long identificationId, Date birthday) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRealname = userRealname;
        this.sex = sex;
        this.address = address;
        this.tel = tel;
        this.identificationId = identificationId;
        this.birthday = birthday;
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

    public Long getTel() {
        return this.tel;
    }
    
    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Long getIdentificationId() {
        return this.identificationId;
    }
    
    public void setIdentificationId(Long identificationId) {
        this.identificationId = identificationId;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
   








}