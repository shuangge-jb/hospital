package persistance;
// default package



/**
 * WorkTime entity. @author MyEclipse Persistence Tools
 */

public class WorkTime  implements java.io.Serializable {


    // Fields    

     private WorkTimeId id;
     private Doctor doctor;
     private Period period;


    // Constructors

    /** default constructor */
    public WorkTime() {
    }

    
    /** full constructor */
    public WorkTime(WorkTimeId id, Doctor doctor, Period period) {
        this.id = id;
        this.doctor = doctor;
        this.period = period;
    }

   
    // Property accessors

    public WorkTimeId getId() {
        return this.id;
    }
    
    public void setId(WorkTimeId id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Period getPeriod() {
        return this.period;
    }
    
    public void setPeriod(Period period) {
        this.period = period;
    }
   








}