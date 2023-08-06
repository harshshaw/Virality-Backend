package com.Virality.Application.Repository;

import com.Virality.Application.Entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TransactionRepo extends CrudRepository<Transaction,Long> {

    @Query("select t.purchasedUserId from Transaction t where (t.transactionStatus=1) and (t.userId=?1)")
    public UUID purchasedUserIdQuery(UUID id);

}
