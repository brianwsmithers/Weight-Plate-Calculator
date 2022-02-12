package Weight;

import Main.Main;

public class WeightView {

    // Counts weight needed for each weight plate.
    public void doBarbellCalculation(WeightModel weightModel, double barbellWeight) {

        double convertValue;

        convertValue = barbellWeight;

        // Subtract weight of the bar.
        convertValue = convertValue - 45;

        // Divide value by 2 to get each side of the bar.
        convertValue = convertValue / 2;

        // This calculation should
        while (convertValue != 0.0) {
            // Subtracts 45 from value until it cannot.
            if (convertValue >= 45) {
                convertValue = convertValue - 45;

                // adds 1 to plate counter
                weightModel.setFortyFiveCounter(
                        weightModel.getFortyFiveCounter() + 1);
            }
            // Subtracts 25 from value until it cannot.
            else if (convertValue >= 25) {
                convertValue = convertValue - 25;
                // adds 1 to plate counter
                weightModel.setTwentyFiveCounter(
                        weightModel.getTwentyFiveCounter() + 1);
            }
            // Subtracts 10 from value until it cannot.
            else if (convertValue >= 10) {
                convertValue = convertValue - 10;
                // adds 1 to plate counter
                weightModel.setTenCounter(weightModel.getTenCounter() + 1);
                // I have 1 ten pound plate calculator
                if (weightModel.getTenCounter() > 1) { // Cannot be more than 1.
                    weightModel.setTenCounter(weightModel.getTenCounter() - 1);
                    weightModel.setFiveCounter(weightModel.getFiveCounter() + 1);
                    convertValue = convertValue + 5; // Adds back 5 of the 10 subtracted.
                }
            }
            // Subtracts 5 from value until it cannot.
            // I have 4 five pound weights.
            else if (convertValue >= 5) {
                convertValue = convertValue - 5;
                // adds 1 to plate counter
                weightModel.setFiveCounter(weightModel.getFiveCounter() + 1);
            }
            // Subtracts 2.5 from value until it cannot.
            else if (convertValue >= 2.5) {
                convertValue = convertValue - 2.5;
                // adds 1 to plate counter
                weightModel.setTwoAndAHalfCounter(
                        weightModel.getTwoAndAHalfCounter() + 1);
            }
            // Subtracts 1.0 from value until it cannot.
            else if (convertValue >= 1.0) {
                convertValue = convertValue - 1.0;
                // adds 1 to plate counter
                weightModel.setOneCounter(weightModel.getOneCounter() + 1);
                // I only have 1 pair of one pound plates.
                if (weightModel.getOneCounter() > 1 &&
                        weightModel.getQuarterCounter() != 1 &&
                        weightModel.getThreeQuarterCounter() != 1) {
                    weightModel.setOneCounter(weightModel.getOneCounter() - 1);
                    weightModel.setQuarterCounter(
                            weightModel.getQuarterCounter() + 1);
                    weightModel.setThreeQuarterCounter(
                            weightModel.getThreeQuarterCounter() + 1);
                }
            }
            // Subtracts 0.75 from value until it cannot.
            else if (convertValue >= 0.75) {
                convertValue = convertValue - 0.75;
                // adds 1 to plate counter
                weightModel.setThreeQuarterCounter(
                        weightModel.getThreeQuarterCounter() + 1);
            }
            // subtracts 0.50 from value until it cannot.
            else if (convertValue >= 0.50) {
                convertValue = convertValue - 0.50;
                // adds 1 to plate counter
                weightModel.setHalfCounter(weightModel.getHalfCounter() + 1);
            }
            // Subtracts 0.25 from value until it cannot.
            else if (convertValue >= 0.25) {
                convertValue = convertValue - 0.25;
                // adds 1 to plate counter
                weightModel.setQuarterCounter(
                        weightModel.getQuarterCounter() + 1);
            }
        }
    }

    // Sets TextFields text to the required plates.
    public void setPlateTextFields(Main guiModel, WeightModel weightModel) {
        guiModel.getFortyFiveTextField().setText(
                String.valueOf(weightModel.getFortyFiveCounter()));

        guiModel.getTwentyFiveTextField().setText(
                String.valueOf(weightModel.getTwentyFiveCounter()));

        guiModel.getTenTextField().setText(
                String.valueOf(weightModel.getTenCounter()));

        guiModel.getFiveTextField().setText(
                String.valueOf(weightModel.getFiveCounter()));

        guiModel.getTwoPointFiveTextField().setText(
                String.valueOf(weightModel.getTwoAndAHalfCounter()));

        guiModel.getOneTextField().setText(
                String.valueOf(weightModel.getOneCounter()));

        guiModel.getPointSeventyFiveTextField().setText(
                String.valueOf(weightModel.getThreeQuarterCounter()));

        guiModel.getPointFiveTextField().setText(
                String.valueOf(weightModel.getHalfCounter()));

        guiModel.getPointTwoFiveTextField().setText(
                String.valueOf(weightModel.getQuarterCounter()));
    }

    // Reset weight counter for next calculation
    public void resetCounters(WeightModel weightModel) {
        weightModel.setFortyFiveCounter(0);
        weightModel.setTwentyFiveCounter(0);
        weightModel.setTenCounter(0);
        weightModel.setFiveCounter(0);
        weightModel.setTwoAndAHalfCounter(0);
        weightModel.setOneCounter(0);
        weightModel.setThreeQuarterCounter(0);
        weightModel.setHalfCounter(0);
        weightModel.setQuarterCounter(0);
    }
}
