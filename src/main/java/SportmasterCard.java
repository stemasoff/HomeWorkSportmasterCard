import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportmasterCard {
    private String status = "";
    private long totalAmount;
    private long bonus;
    private long bonusAmount;
    private boolean additionalInformationServices;
    private boolean individualSpecialOffers;
    private boolean stuffReservation;
    private int additionalGuarantee;
    private int stuffExchange;
    private String stuffExchangePeriod = "";
    private boolean privateInfoService;
    private int bonusRefund;
}
