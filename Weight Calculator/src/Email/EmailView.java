package Email;

import Weight.WeightModel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;

public class EmailView {
/*
    public void gmailCredentials(EmailModel emailModel) {

        // Subject - Name of workout
        String setSubject = (String) workoutComboBox.getSelectedItem();
        // Body Message - Total weight and type/number of plates
        String setMessage = messageDetails().toString();

        sendMessage(emailModel, setMessage, setSubject);
    }

    public void sendMessage(EmailModel emailModel,
                            String setMessage,
                            String setSubject) {

        // Assuming you are sending email from GMAIL's SMTP
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object and pass username and password
        Session session;
        session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return  new PasswordAuthentication(
                        emailModel.getSenderGmailEmailAddress(),
                        emailModel.getSenderPassword());
            }
        });

        // used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(
                    emailModel.getSenderGmailEmailAddress()));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(emailModel.getReceiverMobileNumber()));

            // Set Subject: Header field
            message.setSubject(setSubject);

            // Now set the actual message
            message.setText(setMessage);

            // Send message
            Transport.send(message);

            JOptionPane.showMessageDialog(frame
                    , "SMS sent successfully...",
                    "SMS Verification",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder messageDetails(WeightModel weightModel) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%n"));
        String workoutWeightString = weightTextField.getText();
        double workoutWeightDouble = Double.parseDouble(workoutWeightString);
        if (workoutWeightDouble > 0) {
            stringBuilder.append(String.format("%.2f", workoutWeightDouble));
            stringBuilder.append(String.format(" lbs%n"));
        }
        if (fortyFiveCounter > 0) {
            stringBuilder.append(fortyFiveCounter);
            stringBuilder.append(String.format(" - 45 lb%n"));
        }
        if (twentyFiveCounter > 0) {
            stringBuilder.append(twentyFiveCounter);
            stringBuilder.append(String.format(" - 25 lbs%n"));
        }
        if (tenCounter > 0) {
            stringBuilder.append(tenCounter);
            stringBuilder.append(String.format(" - 25 lbs%n"));
        }
        if (fiveCounter > 0) {
            stringBuilder.append(fiveCounter);
            stringBuilder.append(String.format(" - 5 lbs%n"));
        }
        if (twoAndAHalfCounter > 0) {
            stringBuilder.append(fiveCounter);
            stringBuilder.append(String.format(" - 2.5s lbs%n"));
        }
        if (oneCounter > 0) {
            stringBuilder.append(oneCounter);
            stringBuilder.append(String.format(" - 1 lbs%n"));
        }
        if (threeQuarterCounter > 0) {
            stringBuilder.append(threeQuarterCounter);
            stringBuilder.append(String.format(" - 0.75 lbs%n"));
        }
        if (halfCounter > 0) {
            stringBuilder.append(halfCounter);
            stringBuilder.append(String.format(" - 0.50 lbs%n"));
        }
        if (quarterCounter > 0) {
            stringBuilder.append(quarterCounter);
            stringBuilder.append(String.format(" - 0.25 lbs%n"));
        }
        return stringBuilder;
    }

 */
}
