import java.time.LocalDate;
import java.time.LocalTime;


public class CurrentDateTimeHour
{
    public LocalTime currentTime()
    {
        LocalTime S = java.time.LocalTime.now();

        return S;
    }
    public LocalDate currentDate()
    {
        LocalDate D = java.time.LocalDate.now();
        return D;
    }

}

