package com.Virality.socialMedia.Services.Trading;

import com.Virality.socialMedia.Entity.Trading.Portfolio;
import com.Virality.socialMedia.Entity.Trading.StatusTransaction;
import com.Virality.socialMedia.Entity.Trading.Transaction;
import com.Virality.socialMedia.Entity.Trading.TypeofTransaction;
import com.Virality.socialMedia.Repository.PortfolioRepo;
import com.Virality.socialMedia.Repository.TransactionRepo;
import com.Virality.socialMedia.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class tradingService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    PortfolioRepo portfolioRepo;

    @Autowired
    UserRepo userRepo;
    public void Purchase(Transaction transactionRecord){
            Portfolio portfolio=new Portfolio();
            List<UUID> purchaseIds=new ArrayList<>();
            UUID userId=transactionRecord.getUserId();
            Double currentValue=userRepo.currentPopularityCardValue(userId);
            UUID purchaseId=transactionRepo.purchasedUserIdQuery(userId);
            purchaseIds.add(purchaseId);

            //We store PurchaseUserId to UserId only if transaction is success
            if((transactionRecord.getTransactionStatus().toString()).equals("Success")){
                portfolio.setUserId(userId);
                portfolio.setPurchasedPrice(transactionRecord.getTransactionAmount());
                portfolio.setUnitsPurchased(transactionRecord.getUnitsPurchased());
                portfolio.setPurchasedUserIds(purchaseIds);
                portfolio.setCurrentPrice(currentValue);
                portfolioRepo.save(portfolio);
            }

            transactionRepo.save(transactionRecord);

    }
}
