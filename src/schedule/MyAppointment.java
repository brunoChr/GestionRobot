/**
 * 
 */
package schedule;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalTime;

import com.thirdnf.ResourceScheduler.Appointment;
import com.thirdnf.ResourceScheduler.Resource;

/**
 * @author b.christol
 *
 */
class MyAppointment implements Appointment
{
    private String _title;
    private Resource _resource;
    private DateTime _dateTime;

    public MyAppointment(String title, Resource resource, LocalTime time)
    {
        _title = title;
        _resource = resource;
        _dateTime = time.toDateTimeToday();
    }

    public DateTime getDateTime()
    {
        return _dateTime;
    }

    public String getTitle()
    {
        return _title;
    }

    public Resource getResource()
    {
        return _resource;
    }

    public Duration getDuration()
    {
        return Duration.standardMinutes(45);
    }
}