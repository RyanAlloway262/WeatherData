import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class PSVM
{

    public static void main(String[] args) throws InterruptedException, IOException
    {
        String to = "8147228414@vtext.com";
        //String to = "8147224799@vtext.com";
        //String to = "814-449-8014@mms.cricketwireless.net";

        CurrentDateTimeHour D = new CurrentDateTimeHour();
        SendEmail S = new SendEmail();
        Data G = new Data();
        Calendar calendar = new GregorianCalendar();
        int hourCounter = 0;
        int minuteCounter = 0;


        while(true)
        {
            Date Date = new Date();
            LocalTime time = D.currentTime();
            LocalDate date = D.currentDate();

            calendar.setTime(Date);

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            float minute = calendar.get(Calendar.MINUTE);
            String humidity;
            String temp;

            if(hour % 3 == 0 && minute == 0 && hourCounter == 0)
            {
                G.recordData();
                humidity = G.getHumidity();
                temp = G.getTemp();
                S.sendEmail(to, time, date, humidity, temp);
                hourCounter++;
            }
            if(minute == 1 && hourCounter == 1) hourCounter = 0;

            if(minute == 1 && minuteCounter == 0)
            {
                G.recordData();
                minuteCounter++;
            }
            if(minute == 1 && minuteCounter == 1) minuteCounter = 0;
            
            
                
        }
    }
}
