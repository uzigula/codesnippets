package refactoring;

public class ReflectionUtil {
    public static <T> ProductType getPropertyProductType(T inputObject, String type) {
        return ProductType.BG_PROFUTURE;
    }

    public static <T> String getPropertyString(T inputObject, String a, String b){
        return "B";
    }
    public static <T> String getPropertyString(T inputObject, String a){
        return "B";
    }

    public static <T> Object getPropertyBigDecimal(T inputObject, String savingProgramed, String weeklyAmount) {
        return null;
    }
    public static <T> Object getPropertyBigDecimal(T inputObject, String savingProgramed) {
        return null;
    }

    public static <T> Object getPropertyDate(T inputObject, String balanceDate) {
        return null;
    }
    public static <T> Object getPropertyDate(T inputObject, String balanceDate,String weekly) {
        return null;
    }
}
