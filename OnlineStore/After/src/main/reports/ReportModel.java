package reports;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
public class ReportModel<T> {

    // Generic Labels Headers
    private ReportField<BigDecimal> TopBalance;
    private ReportField<BigDecimal> BottomBalance;

    // Generic Attribute
    private String alias;
    private BigDecimal currentBalance;
    private BigDecimal availableBalance;
    private BigDecimal capitalBalance;
    private String maskedNumber;
    private String subTypeDescription;
    private String idStatus;
    private String accountHolders;
    private String statusDescription;
    private Date nextPaymentDate;
    private Date lastSyncDate;
    private BigDecimal retention;
    private BigDecimal draftBalance;
    private BigDecimal averageAmount;
    private BigDecimal lastAverageAmount;
    private BigDecimal earnedInterestBalance;
    private BigDecimal interestBalance;
    private Date openingDate;
    private Date expirationDate;

    public ReportModel(T detail){
        Detail = detail;


    }

    public T Detail;

}
