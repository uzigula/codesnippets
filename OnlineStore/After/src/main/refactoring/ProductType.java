package refactoring;

public enum ProductType {
     SAVINGS_ACCOUNT (1),
     CHECKING_ACCOUNT(2),
    CREDIT_CARD (3),
    BG_PROFUTURE (4);
    private int productTypeValue;

    ProductType(int value) {
        this.productTypeValue = value;
    }
}
