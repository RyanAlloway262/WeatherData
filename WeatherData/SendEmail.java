import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {


    public void sendEmail(String to, LocalTime time, LocalDate date, String humidity, String temp)
    {
        final String username = "ADD HERE";
        final String password = "ADD HERE";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            session.setDebug(true);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("emailbotalloway@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            //message.setSubject("Weather Update!\n\n");
            message.setText("Weather Update!\n\n" + date + "\n" + time + "\n" + temp + " F\n" + humidity +" %\n\n We working!");

            Transport.send(message);

            System.out.println("Done");

        }

        catch (MessagingException e)
        {
            // throw new RuntimeException(e);
            System.out.println("Username or Password are incorrect ... exiting !");
        }
    }

}