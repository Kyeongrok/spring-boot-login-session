package com.bbs.adapter.outgoing.repository;

import com.bbs.adapter.outgoing.entity.Recording;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingRepository extends JpaRepository<Recording, Long> {
}
