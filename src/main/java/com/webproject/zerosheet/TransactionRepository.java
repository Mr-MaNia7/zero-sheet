package com.webproject.zerosheet;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository <Transaction, Long>  {
}
