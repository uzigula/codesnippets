package refactoring;

public enum ProductSubTypeEnum  {
    Ahorros(1),
    Creditos(2),
    TC(3),
    CHRISTMAS_ACCOUNT(4),
    PREPAID_CREDIT_CARD(5);


    private int productValue;

    ProductSubTypeEnum(int value) {
        this.productValue = value;
    }

    public  static ProductSubTypeEnum fromId(int i) {
        return Ahorros;
    }

    public int getProductValue() {
        return this.productValue;
    }

    public String getProducName() {
        return this.name();
    }

}
