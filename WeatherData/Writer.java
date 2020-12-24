import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Writer extends Data
{
    LocalDate date;
    LocalTime time;


    public void writer(String temp, String humidity) throws IOException
    {
        this.date = java.time.LocalDate.now();
        this.time = java.time.LocalTime.now();
        if(temp == null || humidity == null) return;

        BufferedWriter write = new BufferedWriter(new FileWriter("Data.txt", true)  //Set true for append mode
            );
        write.newLine();   //Add new line
        write.write(date     + "    ");
        write.write(time     + "    ");
        write.write(temp     + "F    ");
        write.write(humidity + "%    ");

        write.close();
    }
}
