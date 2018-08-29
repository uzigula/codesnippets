package refactoring;

import java.util.Map;

import static refactoring.ProductType.CHECKING_ACCOUNT;
import static refactoring.ProductType.CREDIT_CARD;
import static refactoring.ProductType.SAVINGS_ACCOUNT;


public class HeaderMapper extends BuilderConstant {


    private static final String TOTAL_AMOUNT_LBL = "A";
    private static final String ACTUAL_BALANCE = "S";
    private static final String AVAILABLE_BALANCE = "A";
    private static final String DETAIL = "DET";

    private <T> ReportModel toSavingAccountHeader(T inputObject, ReportModel reportModel) {

        //log.debug("Ingresando al metodo toSavingAccountHeader");


        ProductType type = ReflectionUtil.getPropertyProductType(inputObject, "type");

        String subTypeId = ReflectionUtil.getPropertyString(inputObject, SUB_TYPE, ID);

        if (subTypeId != null) {
            reportModel.setProductSubtype(ProductSubTypeEnum.fromId(NumberUtils.toInt(subTypeId)));

            reportModel.setSubTypeDescription(
                    ReflectionUtil.getPropertyString(inputObject, SUB_TYPE, DESCRIPTION));
        }

        if (type != null) {
            reportModel.setProductType(type);
        }

        reportModel.setAlias(ReflectionUtil.getPropertyString(inputObject, ALIAS));

        reportModel.setMaskedNumber(ReflectionUtil.getPropertyString(inputObject, MASKED_NUMBER));

        if (type == SAVINGS_ACCOUNT || type == CHECKING_ACCOUNT) {

            if (reportModel.getProductSubtype() == ProductSubTypeEnum.CHRISTMAS_ACCOUNT) {
                reportModel.setLabelHeaderTopBalance(CUOTA_SEMANAL);
                reportModel.setLabelHeaderBottomBalance(SALDO_DISPONIBLE);

                reportModel.setHeaderTopBalance(ReflectionUtil.getPropertyBigDecimal(inputObject,
                        SAVING_PROGRAMED, WEEKLY_AMOUNT));
            } else {

                reportModel.setLabelHeaderTopBalance(SALDO_TOTAL);

                reportModel.setLabelHeaderBottomBalance(SALDO_DISPONIBLE);

                reportModel.setHeaderTopBalance(
                        ReflectionUtil.getPropertyBigDecimal(inputObject, BALANCE, CAPITAL_BALANCE));
            }
            reportModel.setHeaderBottomBalance(
                    ReflectionUtil.getPropertyBigDecimal(inputObject, BALANCE, DRAFT_BALANCE));

        }
        //log.debug("Saliendo del metodo toSavingAccountHeader");
        return reportModel;
    }

    /**
     * Set header of Profuture.
     *
     * @param inputObject Type T, generic class or interface that is parameterized over types.
     * @param reportModel Object that contains the list of models what will we use to map the
     *        report. Also see {@link ReportModel}.
     * @return Returns an object model type report with the header set for profuture.
     */
    private <T> ReportModel toProfutureHeader(T inputObject, ReportModel reportModel) {

        //log.debug("Ingresando al metodo toSavingAccountHeader");

        ProductType type = ReflectionUtil.getPropertyProductType(inputObject, "type");

        String subTypeId = ReflectionUtil.getPropertyString(inputObject, SUB_TYPE, ID);

        if (subTypeId != null) {
            reportModel.setProductSubtype(ProductSubTypeEnum.fromId(NumberUtils.toInt(subTypeId)));

            reportModel.setSubTypeDescription(
                    ReflectionUtil.getPropertyString(inputObject, SUB_TYPE, DESCRIPTION));
        }

        if (type != null) {
            reportModel.setProductType(type);
        }

        reportModel.setAlias(ReflectionUtil.getPropertyString(inputObject, ALIAS));

        reportModel.setMaskedNumber(ReflectionUtil.getPropertyString(inputObject, MASKED_NUMBER));

        reportModel.setDateBalance(ReflectionUtil.getPropertyBigDecimal(inputObject, "dateBalance"));

        reportModel.setBalanceDate(ReflectionUtil.getPropertyDate(inputObject, "balanceDate"));

        reportModel.setAdmissionDate(ReflectionUtil.getPropertyDate(inputObject, "afiliationDate"));

        reportModel.setHeaderTopBalance(
                ReflectionUtil.getPropertyBigDecimal(inputObject, "currentBalance"));

        reportModel.setLabelHeaderTopBalance(TOTAL_AMOUNT_LBL);

        //log.debug("Saliendo del metodo toSavingAccountHeader");
        return reportModel;
    }

    /**
     * Build the Report Model.
     *
     * @param inputObject Type T, generic class or interface that is parameterized over types.
     * @param reportModel Object that contains the list of models what will we use to map the
     *        report. Also see {@link ReportModel}.
     * @return Returns Object with the set values of the reportModel.
     */
    private <T> ReportModel toCreditPrepaid(T inputObject, ReportModel reportModel) {

        //log.debug("Ingresando al metodo toCreditPrepaid");

        ProductType type = ReflectionUtil.getPropertyProductType(inputObject, "type");

        String subTypeId = ReflectionUtil.getPropertyString(inputObject, SUB_TYPE, ID);

        if (subTypeId != null) {
            reportModel.setProductSubtype(ProductSubTypeEnum.fromId(NumberUtils.toInt(subTypeId)));

            reportModel.setSubTypeDescription(
                    ReflectionUtil.getPropertyString(inputObject, SUB_TYPE, DESCRIPTION));
        }

        if (type != null) {
            reportModel.setProductType(type);
        }

        reportModel.setAlias(ReflectionUtil.getPropertyString(inputObject, ALIAS));

        reportModel.setMaskedNumber(ReflectionUtil.getPropertyString(inputObject, MASKED_NUMBER));

        reportModel.setLabelHeaderTopBalance(
                ReflectionUtil.getPropertyString(inputObject, "availableBalanceLabel"));

        reportModel.setLabelHeaderBottomBalance(
                ReflectionUtil.getPropertyString(inputObject, "currentBalanceLabel") + " al "
                        + ReflectionUtil.getPropertyString(inputObject, "lastSyncDateLabel"));

        if (reportModel.getProductSubtype() == ProductSubTypeEnum.PREPAID_CREDIT_CARD) {

            reportModel.setHeaderTopBalance(
                    ReflectionUtil.getPropertyBigDecimal(inputObject, "availableAmount"));
            reportModel.setHeaderBottomBalance(
                    ReflectionUtil.getPropertyBigDecimal(inputObject, BALANCE, ACTUAL_BALANCE));
        }

        reportModel.setHeaderTopBalance(
                ReflectionUtil.getPropertyBigDecimal(inputObject, AVAILABLE_BALANCE));
        reportModel.setHeaderBottomBalance(
                ReflectionUtil.getPropertyBigDecimal(inputObject, BALANCE, ACTUAL_BALANCE));

        reportModel.setLastStatementBankDate(
                ReflectionUtil.getPropertyDate(inputObject, DETAIL, "lastStatementBankDate"));

        reportModel.setMinimumPayment(
                ReflectionUtil.getPropertyBigDecimal(inputObject, BALANCE, "minimumPayment"));

        //log.debug("Saliendo al metodo toCreditPrepaid");
        return reportModel;
    }

    /**
     * Generate Header of reports.
     *
     * @param inputObject Type T, generic class or interface that is parameterized over types.
     * @param params Interface {@literal Map<String,Object>}.
     * @return Returns the object of type ReportModel.
     */
    public <T> ReportModel generateHeader(T inputObject, Map<String, Object> params) {

        ReportModel reportModel = new ReportModel();

        return generateHeader(inputObject, params, reportModel);

    }

    /**
     * Create de header for report
     *
     * @param inputObject Type T, generic class or interface that is parameterized over types.
     * @param params Interface {@literal Map<String,Object>}.
     * @param reportModel Object that contains the list of models what will we use to map the
     *        report. Also see {@link ReportModel}.
     * @return Return the header for build the report.
     */
    public <T> ReportModel generateHeader(T inputObject, Map<String, Object> params,
                                          ReportModel reportModel) {

       // log.debug("Ingresando al metodo generateHeader reportes que utilizan movimentos");
        try {

            ProductType type = ReflectionUtil.getPropertyProductType(inputObject, "type");

            switch (type) {
                case CHECKING_ACCOUNT:
                case SAVINGS_ACCOUNT:

                    params.put(ReportUtil.BGP_SUB_HEADER, JRLoader
                            .loadObject(ReportUtil.getResourceAsInputStream(ReportUtil.BGP_H_ACCOUNT)));

                    return toSavingAccountHeader(inputObject, reportModel);

                case CREDIT_CARD:

                    if (reportModel.getProductSubtype() == ProductSubTypeEnum.PREPAID_CREDIT_CARD) {
                        params.put(ReportUtil.BGP_SUB_HEADER, JRLoader
                                .loadObject(
                                        ReportUtil.getResourceAsInputStream(ReportUtil.BGP_H_ACCOUNT)));
                    } else {
                        params.put(ReportUtil.BGP_SUB_HEADER, JRLoader
                                .loadObject(
                                        ReportUtil.getResourceAsInputStream(ReportUtil.BGP_H_CREDIT_C)));
                    }

                    //log.debug("Saliendo  cabeceras de los reportes que utilizan movimentos");
                    return toCreditPrepaid(inputObject, reportModel);

                case BG_PROFUTURE:

                    params.put(ReportUtil.BGP_SUB_HEADER, JRLoader
                            .loadObject(
                                    ReportUtil.getResourceAsInputStream(ReportUtil.BGP_H_ACCOUNT_MIN)));

                    return toProfutureHeader(inputObject, reportModel);

                default:
                    break;
            }
        } catch (JRException e) {

            //log.debug("Error en el metodo generateHeader ", e);
        }
        return null;
    }

    /**
     * Generate the reports that use movimentos
     *
     * @param inputObject Type T, generic class or interface that is parameterized over types.
     * @return Return the report with the movement set.
     */
    public <T> ReportModel generateHeader(T inputObject) {

        //log.debug("Ingresando generateHeader para generar las  reportes que utilizan movimentos");

        ProductType type = ReflectionUtil.getPropertyProductType(inputObject, "type");

        ReportModel reportModel;

        switch (type) {
            case CHECKING_ACCOUNT:
            case SAVINGS_ACCOUNT:
                reportModel = new ReportModel();
                return toSavingAccountHeader(inputObject, reportModel);
            case CREDIT_CARD:
                reportModel = new ReportModel();
                return toCreditPrepaid(inputObject, reportModel);

            default:
                break;
        }

        return null;
    }

}