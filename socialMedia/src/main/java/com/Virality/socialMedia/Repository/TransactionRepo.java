package com.Virality.socialMedia.Repository;

import com.Virality.socialMedia.Entity.Trading.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction,Long> {

    @Query("select t.purchasedUserId from Transaction t where (t.transactionStatus=1) and (t.userId=?1)")
    public Integer purchasedUserIdQuery(Integer id);

}
