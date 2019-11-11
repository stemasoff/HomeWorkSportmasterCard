import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportmasterCardServiceTest {

    @Test
    void calculate() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 0;
        service.calculate(card, purchase);
        assertEquals("", card.getStatus());
        assertEquals(0, card.getBonusAmount());
    }

    @Test
    void calculateOne() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 100;
        service.calculate(card, purchase);
        assertEquals("Blue", card.getStatus());
        assertEquals(0, card.getBonusAmount());
    }
   @Test
    void calculateBlue() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 3_000_00;
        service.calculate(card, purchase);
        assertEquals("Blue", card.getStatus());
        assertEquals(150, card.getBonusAmount());
    }
   @Test
    void calculateBellowSilver() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 15_000_00;
        service.calculate(card, purchase);
        assertEquals("Blue", card.getStatus());
        assertEquals(750, card.getBonusAmount());
    }

    @Test
    void calculateBellowGold() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 150_000_00;
        service.calculate(card, purchase);
        assertEquals("Silver", card.getStatus());
        assertEquals(10500, card.getBonusAmount());
    }

    @Test
    void calculateGold() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 150_001_00;
        service.calculate(card, purchase);
        assertEquals("Gold", card.getStatus());
        assertEquals(15000, card.getBonusAmount());
    }

    @Test
    void calculateMultiplePurchasesBlue() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 1_000_00;
        service.calculate(card, purchase);

        purchase = 3_000_00;
        service.calculate(card, purchase);

        purchase = 50_00;
        service.calculate(card, purchase);


        assertEquals("Blue", card.getStatus());
        assertEquals(200, card.getBonusAmount());
    }
    @Test
    void calculateMultiplePurchasesSilver() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 10_000_00;
        service.calculate(card, purchase);

        purchase = 30_000_00;
        service.calculate(card, purchase);

        purchase = 50_00;
        service.calculate(card, purchase);


        assertEquals("Silver", card.getStatus());
        assertEquals(2600, card.getBonusAmount());
    }

    @Test
    void calculateMultiplePurchasesGold() {
        SportmasterCard card = new SportmasterCard();
        SportmasterCardService service = new SportmasterCardService();

        long purchase = 100_000_00;
        service.calculate(card, purchase);

        purchase = 100_000_00;
        service.calculate(card, purchase);


        assertEquals("Gold", card.getStatus());
        assertEquals(17000, card.getBonusAmount());
    }



}