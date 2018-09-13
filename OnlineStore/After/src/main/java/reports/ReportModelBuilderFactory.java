package reports;

import java.lang.reflect.Constructor;

public class ReportModelBuilderFactory {

    public static <T> IAmReportModelBuilder<T> create(T account){
        try {
            Class<? extends IAmReportModelBuilder<T>> clz = load(account);
            Constructor<? extends IAmReportModelBuilder<T>> ctor = clz.getConstructor(); // pasar los parametros que necesiten
            IAmReportModelBuilder<T> builder = ctor.newInstance();
            return builder;
        }
        catch(NoSuchMethodException e){
            ClassHasInvalidConstructor ex = new ClassHasInvalidConstructor(account.getClass().getName());
            throw ex;
        }
        catch(Exception e){
            throw new ClassNotImplementedException(account.getClass().getName() + "ReportModelBuilder" + " does not implement IAmReportModelBuilder<" + account.getClass().getName() + ">" , e);
        }

    }

    private static <T> Class<? extends IAmReportModelBuilder<T>> load(T type)
            throws ClassNotFoundException
    {
        Class<?> any = Class.forName(type.getClass().getName() + "ReportModelBuilder");
        if (any.getDeclaredConstructors().length==1)
        {
            Class<? extends IAmReportModelBuilder<T>> creator = (Class<? extends IAmReportModelBuilder<T>>) any;
            return creator;
        }
        throw new ClassNotFoundException("The child class should have only a default constructor");
    }
}
