package persistance;
// default package

import persistance.Period;


/**
 * Schedule entity. @author MyEclipse Persistence Tools
 * ≈≈∞‡±Ì
 */

public class Schedule  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScheduleId id;
     private Doctor doctor;
     private Period period;


    // Constructors

    /** default constructor */
    public Schedule() {
    }

    
    /** full constructor */
    public Schedule(ScheduleId id, Doctor doctor, Period period) {
        this.id = id;
        this.doctor = doctor;
        this.period = period;
    }

   
    // Property accessors

    public ScheduleId getId() {
        return this.id;
    }
    
    public void setId(ScheduleId id) {
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