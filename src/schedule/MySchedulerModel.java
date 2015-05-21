/**
 * 
 */
package schedule;

/**
 * @author b.christol
 *
 */
import com.thirdnf.ResourceScheduler.*;

import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MySchedulerModel extends AbstractScheduleModel
{
    private Resource Resource1 = new MyResource("Admin");
    //private Resource Resource2 = new MyResource("Dr. Two");

    private Appointment Appointment1 =
            new MyAppointment("Visit 1", Resource1, new LocalTime(10, 0, 0));
    private Appointment Appointment2 =
            new MyAppointment("Visit 1", Resource1, new LocalTime(10, 0, 0));
    
    public void visitAppointments(AppointmentVisitor appointmentVisitor, LocalDate localDate)
    {
        appointmentVisitor.visitAppointment(Appointment1);
        appointmentVisitor.visitAppointment(Appointment2);

    }

    public void visitResources(ResourceVisitor resourceVisitor, LocalDate localDate)
    {
        resourceVisitor.visitResource(Resource1);
        //resourceVisitor.visitResource(Resource2);
    }

    public LocalTime getStartTime(LocalDate localDate)
    {
        return new LocalTime(8,0,0);
    }

    public LocalTime getEndTime(LocalDate localDate)
    {
        return new LocalTime(17,0,0);
    }

	/**
	 * @return the resource1
	 */
	public Resource getResource1() {
		return Resource1;
	}

	/**
	 * @param resource1 the resource1 to set
	 */
	public void setResource1(Resource resource1) {
		Resource1 = resource1;
	}

	/**
	 * @return the appointment1
	 */
	public Appointment getAppointment1() {
		return Appointment1;
	}

	/**
	 * @param appointment1 the appointment1 to set
	 */
	public void setAppointment1(Appointment appointment1) {
		Appointment1 = appointment1;
	}

	/**
	 * @return the appointment2
	 */
	public Appointment getAppointment2() {
		return Appointment2;
	}

	/**
	 * @param appointment2 the appointment2 to set
	 */
	public void setAppointment2(Appointment appointment2) {
		Appointment2 = appointment2;
	}
}

class MyResource implements Resource
{
    private final String _title;

    public MyResource(String title)
    {
        _title = title;
    }

    /*public Iterator<Availability> getAvailability(LocalDate localDate)
    {
        return (new ArrayList<Availability>()).iterator();
    }*/

    public Iterator<Availability> getAvailability(LocalDate localDate)
    {
        List<Availability> availabilities = new ArrayList<Availability>();
        availabilities.add(new Availability(new LocalTime(10,0,0), Duration.standardHours(5)));
        return availabilities.iterator();
    }
    
    public String getTitle()
    {
        return _title;
    }
}
   