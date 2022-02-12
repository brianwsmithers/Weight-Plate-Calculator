package Main;

import Weight.WeightController;
import Weight.WeightModel;
import Weight.WeightView;

import javax.swing.*;

public class Main {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel bodyPanel;
    private JTextField fortyFiveTextField;
    private JTextField twentyFiveTextField;
    private JTextField tenTextField;
    private JTextField fiveTextField;
    private JTextField twoPointFiveTextField;
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

    private double barbellWeight;

    // GUI Listeners
    public Main() {}

    public static void main(String[] args) {
        // Load models, views and controllers
        Main guiModel = new Main();

        WeightModel weightModel = new WeightModel();
        WeightView weightView = new WeightView();

        WeightController weightController =
                new WeightController(weightModel, weightView, guiModel);

        // Make gui
        String title = "Workout Plate Calculator";
        guiModel.frame = new JFrame(title);
        guiModel.frame.setContentPane(guiModel.mainPanel);
        guiModel.frame.pack();
        guiModel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiModel.frame.setLocationRelativeTo(null);
        guiModel.frame.setResizable(false);
        guiModel.frame.setVisible(true);

        // Event listener
        guiModel.calculateButton.addActionListener(actionEvent -> {
            guiModel.barbellWeight = Double.parseDouble
                    (guiModel.weightTextField.getText());

            if (guiModel.barbellWeight % 0.50 != 0.0) {
                JOptionPane.showMessageDialog(
                        guiModel.frame,
                        "Weight must be in increments of 0.50 lbs.",
                        "Invalid weight...", JOptionPane.ERROR_MESSAGE);
                guiModel.weightTextField.setText("");
            }
            else {
                weightController.updateView();
                guiModel.setBarbellWeight(0);
            }
        });
        //sendSMSButton.addActionListener(actionEvent -> emailCredentials());
    }

    public JTextField getFortyFiveTextField() {
        return fortyFiveTextField;
    }

    public JTextField getTwentyFiveTextField() {
        return twentyFiveTextField;
    }

    public JTextField getTenTextField() {
        return tenTextField;
    }

    public JTextField getFiveTextField() {
        return fiveTextField;
    }

    public JTextField getTwoPointFiveTextField() {
        return twoPointFiveTextField;
    }

    public JTextField getOneTextField() {
        return oneTextField;
    }

    public JTextField getPointSeventyFiveTextField() {
        return pointSeventyFiveTextField;
    }

    public JTextField getPointFiveTextField() {
        return pointFiveTextField;
    }

    public JTextField getPointTwoFiveTextField() {
        return pointTwoFiveTextField;
    }

    public JTextField getWeightTextField() {
        return weightTextField;
    }

    public double getBarbellWeight() {
        return barbellWeight;
    }

    public void setBarbellWeight(double barbellWeight) {
        this.barbellWeight = barbellWeight;
    }
}
