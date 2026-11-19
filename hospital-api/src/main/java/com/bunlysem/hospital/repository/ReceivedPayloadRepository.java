package com.bunlysem.hospital.repository;

import com.bunlysem.hospital.entity.ReceivedPayload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivedPayloadRepository
        extends JpaRepository<ReceivedPayload, Long> {
}
