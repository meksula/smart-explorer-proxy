package com.smartexplorer.repository;

import com.smartexplorer.domain.subject.registration.Confirmation;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author
 * Karol Meksuła
 * 11-06-2018
 * */

public interface ConfirmationRepository extends MongoRepository<Confirmation, String> {
}
