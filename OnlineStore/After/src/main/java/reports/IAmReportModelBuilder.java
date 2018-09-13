package reports;

public abstract class IAmReportModelBuilder<T> {

    private ReportModel<T> report;


    public ReportModel<T> create(T model) {
        report = new ReportModel<T>(model);

         this.createHeader(model)
              .createBody(model)
              .createFooter(model);
        return report;
    }


    protected abstract IAmReportModelBuilder createHeader(T model);
    protected abstract IAmReportModelBuilder createBody(T model);
    protected abstract IAmReportModelBuilder createFooter(T model);
}

