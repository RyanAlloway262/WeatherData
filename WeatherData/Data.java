import java.io.IOException;

public class Data extends PSVM
{
    String Humidity;
    String Temp;
    reader r = new reader();


    public String getHumidity()
    {
        return Humidity;
    }

    public String getTemp()
    {
        return Temp;
    }


    public void recordData() throws IOException, InterruptedException
    {
        Writer w = new Writer();
        Thread.sleep(3000);
        String[] data = r.read();
        Temp = data[0];
        Humidity = data[1];

        w.writer(Temp, Humidity);

        if(data[0] != null && data[1] != null)
        {
            System.out.println(data[0]);
            System.out.println(data[1]);

        }

    }
}
