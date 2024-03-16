import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;


public class CreditCardService {

    private List<CreditCard> creditCards = new ArrayList<>();

    public CreditCard createCreditCard(BigDecimal fee, List<Campaign> campaignList) {
        return new CreditCard(fee, campaignList);
        creditCards.add(creditCard);
    }


    public List<CreditCard> sortCreditCardsByCampaignCount() {

        Collections.sort(creditCards, new Comparator<CreditCard>() {
            @Override
            public int compare(CreditCard card1, CreditCard card2) {
            
                return Integer.compare(card2.getCampaignList().size(), card1.getCampaignList().size());
            }
        });
        return new ArrayList<>(creditCards); 
    
}
