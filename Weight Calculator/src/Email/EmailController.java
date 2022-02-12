package Email;

import Weight.WeightModel;

public class EmailController {

    private EmailModel emailModel;
    private EmailView emailView;
    private WeightModel weightModel;

    public EmailController(EmailModel emailModel, EmailView emailView,
                           WeightModel weightModel) {
        this.emailModel = emailModel;
        this.emailView = emailView;
        this.weightModel = weightModel;
    }

}
