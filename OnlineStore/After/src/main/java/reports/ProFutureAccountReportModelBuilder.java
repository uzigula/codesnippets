package reports;

public class ProFutureAccountReportModelBuilder extends IAmReportModelBuilder<ProFutureAccount> {

    public ProFutureAccountReportModelBuilder(String algo) {}
    protected IAmReportModelBuilder createHeader(ProFutureAccount model) {
        return this;
    }

    protected IAmReportModelBuilder createBody(ProFutureAccount model) {
        return this;
    }

    protected IAmReportModelBuilder createFooter(ProFutureAccount model) {
        return this;
    }
}
