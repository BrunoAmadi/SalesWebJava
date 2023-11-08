package com.example.firstAPI.repositories;

import com.example.firstAPI.models.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesRecordRepository extends JpaRepository<SalesRecord, UUID> {
}
