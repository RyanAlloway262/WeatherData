import java.io.*;
import java.util.Scanner;

public class reader
{
    String[] splitter = new String[2];

    public String[] read()
    {

        try {
            Scanner s = new Scanner(new FileReader("python output.txt"));
            // read next line
            String line = "";
            splitter = new String[2];

            while(s.hasNextLine())
            {
                line = s.nextLine();
                splitter = line.split("\\s+");
            }

            clearFile();
            s.close();
            return splitter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clearFile() throws IOException
    {
        FileWriter fwOb = new FileWriter("python output.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
}

