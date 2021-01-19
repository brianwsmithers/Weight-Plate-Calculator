import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class DisplayWeight {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel bodyPanel;
    private JTextField fortyFiveTextField;
    private JTextField twentyFiveTextField;
    private JTextField tenTextField;
    private JTextField fiveTextField;
    private JTextField twoPointFiveTextfield;
    private JTextField oneTextField;
    private JTextField pointSeventyFiveTextField;
    private JTextField pointFiveTextField;
    private JTextField pointTwoFiveTextField;
    private JTextField weightTextField;
    private JButton sendSMSButton;
    private JLabel fortyFiveLabel;
    private JLabel twentyFiveLabel;
    private JLabel tenLabel;
    private JLabel fiveLabel;
    private JLabel twoPointFiveLabel;
    private JLabel oneLabel;
    private JLabel pointSeventyFiveLabel;
    private JLabel pointFiveLabel;
    private JLabel pointTwoFiveLabel;
    private JLabel weightLabel;
    private JButton calculateButton;
    private JLabel workoutLabel;
    private JComboBox workoutComboBox;
    private JLabel timeLabel;
    private JFrame frame;

    // regular plates
    int fortyFiveCounter = 0;
    int twentyFiveCounter = 0;
    int tenCounter = 0;
    int fiveCounter = 0;
    int twoAndAHalfCounter = 0;

    // fractional plates
    int oneCounter = 0;
    int threeQuarterCounter = 0;
    int halfCounter = 0;
    int quarterCounter = 0;

    // GUI Listeners
    public DisplayWeight() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double value = Double.parseDouble(weightTextField.getText());

                if (value % 0.50 != 0.0) {
                    JOptionPane.showMessageDialog(
                            frame, "Weight must be in increments of 0.50 lbs.",
                            "Invalid weight...", JOptionPane.ERROR_MESSAGE);
                    weightTextField.setText("");
                }
                else {
                    countCalculation(value);
                }
            }
        });
        sendSMSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                emailCredentials();
            }
        });
    }

    public void emailCredentials() {
        String from = "email@gmail.com";  // Your email...
        String password = "password";     // Your password...
        String to = "email@AnyEmail"; // The receiver's email...

        // Subject - Name of workout
        String setSubject = (String) workoutComboBox.getSelectedItem();
        // Body Message - Total weight and type/number of plates
        String setMessage = messageDetails().toString();

        sendMessage(from, password, to, setMessage, setSubject);
    }

    public StringBuilder messageDetails() {
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

    public void sendMessage(String from, String password, String to, String setMessage,
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

        // Get the Session object.// and pass username and password
        Session session;
        session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return  new PasswordAuthentication(from, password);
            }
        });

        // used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

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

            //System.out.println("Sent message successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // Counts weight needed for each weight plate.
    public void countCalculation(double value) {

        double convertValue;

        convertValue = value;

        // Subtract weight of the bar.
        convertValue = convertValue - 45;

        // Divide value by 2 to get each side of the bar.
        convertValue = convertValue / 2;

        // regular plates
        fortyFiveCounter = 0;
        twentyFiveCounter = 0;
        tenCounter = 0;
        fiveCounter = 0;
        twoAndAHalfCounter = 0;

        // fractional plates
        oneCounter = 0;
        threeQuarterCounter = 0;
        halfCounter = 0;
        quarterCounter = 0;

        // This calculation should
        while (convertValue != 0.0) {
            // Subtracts 45 from value until it cannot.
            if (convertValue >= 45) {
                convertValue = convertValue - 45;
                // adds 1 to plate counter
                fortyFiveCounter++;
            }
            // Subtracts 25 from value until it cannot.
            else if (convertValue >= 25) {
                convertValue = convertValue - 25;
                // adds 1 to plate counter
                twentyFiveCounter++;
            }
            // Subtracts 10 from value until it cannot.
            else if (convertValue >= 10) {
                convertValue = convertValue - 10;
                // adds 1 to plate counter
                tenCounter++;
                // I have 1 ten pound plate calculator
                if (tenCounter > 1) { // Cannot be more than 1.
                    tenCounter--; // Will subtract the one added to make 1.
                    fiveCounter++; // Adds 1 to the five counter
                    convertValue = convertValue + 5; // Adds back 5 of the 10 subtracted.
                }
            }
            // Subtracts 5 from value until it cannot.
            // I have 4 five pound weights.
            else if (convertValue >= 5) {
                convertValue = convertValue - 5;
                // adds 1 to plate counter
                fiveCounter++;
            }
            // Subtracts 2.5 from value until it cannot.
            else if (convertValue >= 2.5) {
                convertValue = convertValue - 2.5;
                // adds 1 to plate counter
                twoAndAHalfCounter++;
            }
            // Subtracts 1.0 from value until it cannot.
            else if (convertValue >= 1.0) {
                convertValue = convertValue - 1.0;
                // adds 1 to plate counter
                oneCounter++;
                // I only have 1 pair of one pound plates.
                if (oneCounter > 1 && quarterCounter != 1 && threeQuarterCounter != 1) {
                    oneCounter--;
                    quarterCounter++;
                    threeQuarterCounter++;
                }
            }
            // Subtracts 0.75 from value until it cannot.
            else if (convertValue >= 0.75) {
                convertValue = convertValue - 0.75;
                // adds 1 to plate counter
                threeQuarterCounter++;
            }
            // subtracts 0.50 from value until it cannot.
            else if (convertValue >= 0.50) {
                convertValue = convertValue - 0.50;
                // adds 1 to plate counter
                halfCounter++;
            }
            // Subtracts 0.25 from value until it cannot.
            else if (convertValue >= 0.25) {
                convertValue = convertValue - 0.25;
                // adds 1 to plate counter
                quarterCounter++;
            }
            setPlateTextFields();
        }
    }

    // Sets textfields text to the required plates.
    public void setPlateTextFields() {
        fortyFiveTextField.setText(String.valueOf(fortyFiveCounter));
        twentyFiveTextField.setText(String.valueOf(twentyFiveCounter));
        tenTextField.setText(String.valueOf(tenCounter));
        fiveTextField.setText(String.valueOf(fiveCounter));
        twoPointFiveTextfield.setText(String.valueOf(twoAndAHalfCounter));
        oneTextField.setText(String.valueOf(oneCounter));
        pointSeventyFiveTextField.setText(String.valueOf(threeQuarterCounter));
        pointFiveTextField.setText(String.valueOf(halfCounter));
        pointTwoFiveTextField.setText(String.valueOf(quarterCounter));
    }

    public void launchGUI() {
        String title = "Workout Plate Calculator";
        frame = new JFrame(title);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
