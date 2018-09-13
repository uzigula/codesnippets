package reports;

public class ReportManager {
    public <T> ReportModel<T> GenerateReport(T account) {
        return  ReportModelBuilderFactory
                    .create(account)
                    .create(account);
        //return builder.create(account);
    }
}
