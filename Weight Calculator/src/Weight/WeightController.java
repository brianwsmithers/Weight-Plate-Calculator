package Weight;

import Main.Main;

public class WeightController {

    private WeightModel weightModel;
    private WeightView weightView;
    private Main guiModel;

    public WeightController(WeightModel weightModel, WeightView weightView,
                            Main guiModel) {
        this.weightModel = weightModel;
        this.weightView = weightView;
        this.guiModel = guiModel;
    }

    public void updateView() {
        weightView.doBarbellCalculation(weightModel, guiModel.getBarbellWeight());
        weightView.setPlateTextFields(guiModel, weightModel);
        weightView.resetCounters(weightModel);
    }
}
