package com.Virality.Application.Repository;

import com.Virality.Application.Entity.HashTag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface HashTagRepo extends CrudRepository<HashTag, UUID> {
    public List<HashTag> findAll();
}
