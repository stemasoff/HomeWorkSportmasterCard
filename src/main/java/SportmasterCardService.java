public class SportmasterCardService {
    private String blueStatus = "Blue";
    private String silverStatus = "Silver";
    private String goldStatus = "Gold";

    private long blueThreshold = 1_00;
    private long silverThreshold = 15_001_00;
    private long goldThreshold = 150_001_00;

    private long blueBonus = 50;
    private long silverBonus = 70;
    private long goldBonus = 100;

    private int blueAdditionalGuarantee = 0;
    private int silverAdditionalGuarantee = 30;
    private int goldAdditionalGuarantee = 60;

    private int blueStuffExchange = 14;
    private int silverStuffExchange = 1;
    private int goldStuffExchange = 2;
    private String dayStuffExchangePeriod = "Day";
    private String monthStuffExchangePeriod = "Month";

    private int blueBonusRefund = 20;
    private int silverBonusRefund = 50;
    private int goldBonusRefund = 100;

    public void calculate(SportmasterCard card, long purchase) {
        card.setTotalAmount(purchase + card.getTotalAmount());
        if (card.getTotalAmount() >= blueThreshold && card.getTotalAmount() < silverThreshold) {
            card.setStatus(blueStatus);
            card.setBonus(blueBonus);
            card.setAdditionalInformationServices(true);
            card.setIndividualSpecialOffers(true);
            card.setStuffReservation(true);
            card.setStuffExchange(blueStuffExchange);
            card.setStuffExchangePeriod(dayStuffExchangePeriod);
            card.setBonusRefund(blueBonusRefund);
            card.setPrivateInfoService(false);
            card.setAdditionalGuarantee(blueAdditionalGuarantee);

            card.setBonusAmount(card.getBonus() * (purchase / 1_000_00) + card.getBonusAmount());
        }

        if (card.getTotalAmount() >= silverThreshold && card.getTotalAmount() < goldThreshold) {
            card.setStatus(silverStatus);
            card.setBonus(silverBonus);
            card.setAdditionalInformationServices(true);
            card.setIndividualSpecialOffers(true);
            card.setStuffReservation(true);
            card.setStuffExchange(silverStuffExchange);
            card.setStuffExchangePeriod(monthStuffExchangePeriod);
            card.setBonusRefund(silverBonusRefund);
            card.setPrivateInfoService(false);
            card.setAdditionalGuarantee(silverAdditionalGuarantee);

            card.setBonusAmount(card.getBonus() * (purchase / 1_000_00) + card.getBonusAmount());
        }

        if (card.getTotalAmount() >= goldThreshold) {
            card.setStatus(goldStatus);
            card.setBonus(goldBonus);
            card.setAdditionalInformationServices(true);
            card.setIndividualSpecialOffers(true);
            card.setStuffReservation(true);
            card.setStuffExchange(goldStuffExchange);
            card.setStuffExchangePeriod(monthStuffExchangePeriod);
            card.setBonusRefund(goldBonusRefund);
            card.setPrivateInfoService(true);
            card.setAdditionalGuarantee(goldAdditionalGuarantee);

            card.setBonusAmount(card.getBonus() * (purchase / 1_000_00) + card.getBonusAmount());
        }

    }






}
