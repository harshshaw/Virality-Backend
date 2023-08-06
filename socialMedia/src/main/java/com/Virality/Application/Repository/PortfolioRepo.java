package com.Virality.Application.Repository;

import com.Virality.Application.Entity.Portfolio;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioRepo extends CrudRepository<Portfolio, Long> {
}
