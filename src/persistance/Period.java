package persistance;

// default package

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Period entity. @author MyEclipse Persistence Tools Ê±¼ä¶Î±í
 */

public class Period implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date date;
	private Time beginTime;
	private Time endTime;
	private Set<Schedule> schedules = new HashSet<Schedule>(0);
	private Set<Registration> registrations = new HashSet<Registration>(0);

	// Constructors

	/** default constructor */
	public Period() {
	}

	/** minimal constructor */
	public Period(Date date, Time beginTime, Time endTime) {
		this.date = date;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	/** full constructor */
	public Period(Date date, Time beginTime, Time endTime,
			Set<Schedule> schedules, Set<Registration> registrations) {
		this.date = date;
		this.beginTime = beginTime;
		this.endTime = endTime;
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Time beginTime) {
		this.beginTime = beginTime;
	}

	public Time getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Set<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Set<Registration> getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

}