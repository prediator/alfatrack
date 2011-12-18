package ua.pogodin.productgroup.dto;

/**
 * @author Sergii Pogodin
 */
@SuppressWarnings("UnusedDeclaration")
public class Sort {
    public static final String NAME_ASC_URL_SUFFIX = "name";
    public static final String PRICE_ASC_URL_SUFFIX = "price";
    public static final String NAME_DESC_URL_SUFFIX = "name/false";
    public static final String PRICE_DESC_URL_SUFFIX = "price/false";
    public static final String SIGN_ASC = "v";
    public static final String SIGN_DESC = "^";

    private String nameUrlSuffix = NAME_ASC_URL_SUFFIX;
    private String priceUrlSuffix = PRICE_ASC_URL_SUFFIX;
    private String nameSign = "";
    private String priceSign = "";

    public String getNameUrlSuffix() {
        return nameUrlSuffix;
    }

    public void setNameUrlSuffix(String nameUrlSuffix) {
        this.nameUrlSuffix = nameUrlSuffix;
    }

    public String getPriceUrlSuffix() {
        return priceUrlSuffix;
    }

    public void setPriceUrlSuffix(String priceUrlSuffix) {
        this.priceUrlSuffix = priceUrlSuffix;
    }

    public String getNameSign() {
        return nameSign;
    }

    public void setNameSign(String nameSign) {
        this.nameSign = nameSign;
    }

    public String getPriceSign() {
        return priceSign;
    }

    public void setPriceSign(String priceSign) {
        this.priceSign = priceSign;
    }
}
