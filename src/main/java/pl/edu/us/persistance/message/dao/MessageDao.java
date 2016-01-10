package pl.edu.us.persistance.message.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public interface MessageDao extends PagingAndSortingRepository<Message, Long>, JpaSpecificationExecutor<Message> {
}
