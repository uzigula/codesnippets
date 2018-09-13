package reports;

import org.junit.*;
import org.junit.rules.ExpectedException;

import reports.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.StringContains.containsString;

public class reportBuilderTests {

    private ReportManager manager;
    @Rule
    public ExpectedException castException = ExpectedException.none();
    @Before
    public  void setup(){
        manager = new ReportManager();
    }

    @Test
    public void shouldCreateReportBuilder(){

        CheckingAccount account= new CheckingAccount();
        IAmReportModelBuilder<CheckingAccount> builder = ReportModelBuilderFactory.create(account);
        Assert.assertNotNull("builder es nulo",builder);
        Assert.assertThat(builder, instanceOf(CheckingAccountReportModelBuilder.class));

    }
    @Test
    public void shouldThrowAnExceptionBecauseProFutureAccountReportBuilderHasInvalidConstructor(){
        castException.expect(ClassHasInvalidConstructor.class);
        castException.expectMessage(containsString("ProFutureAccount"));
        IAmReportModelBuilder<ProFutureAccount> builder = ReportModelBuilderFactory.create(new ProFutureAccount());
        Assert.assertNotNull(builder);
        Assert.assertThat(builder, instanceOf(ProFutureAccountReportModelBuilder.class) );
    }



    @Test
    public void shouldReturnCheckingAccountReportModel(){
        ReportModel<CheckingAccount> report = manager.GenerateReport(new CheckingAccount());
        Assert.assertNotNull(report);
        Assert.assertThat(report.getDetail(), instanceOf(CheckingAccount.class) );

    }

    @Test
    public void shouldThrowAClassCastException (){

        castException.expect(ClassNotImplementedException.class);
        castException.expectMessage(containsString("NotImplementedAccount"));
        Object model = manager.GenerateReport(new NotImplementedAccount());
        Assert.assertNotNull(model);
        Assert.assertThat(model, instanceOf(ReportModel.class) );
        Assert.assertThat(((ReportModel<NotImplementedAccount>)model).getDetail(), instanceOf(NotImplementedAccount.class) );

    }

}
