package com.bbs.adapter.outgoing;

import com.bbs.adapter.outgoing.entity.Recording;
import com.bbs.adapter.outgoing.port.RecordingPort;
import com.bbs.adapter.outgoing.repository.RecordingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RecordingPersistentAdapter implements RecordingPort {
    private final RecordingRepository repository;

    public RecordingPersistentAdapter(RecordingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Recording> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Recording save(Recording recording) {
        return repository.save(recording);
    }
}
