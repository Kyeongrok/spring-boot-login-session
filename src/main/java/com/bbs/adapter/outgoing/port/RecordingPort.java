package com.bbs.adapter.outgoing.port;

import com.bbs.adapter.outgoing.entity.Recording;

import java.util.Optional;

public interface RecordingPort {
    Optional<Recording> findById(Long id);

    Recording save(Recording recording);
}
