package com.bbs.adapter.outgoing.repository;

import com.bbs.adapter.outgoing.entity.Recording;
import com.bbs.adapter.outgoing.entity.RecordingFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RecordingRepositoryTest {

    @Autowired
    RecordingRepository repository;

    @Test
    void insertAndSelect() {
        Recording recording = new Recording();
        recording.setTitle("첫번째 레코딩");

        List<RecordingFile> recordingFiles = Arrays.asList(
                new RecordingFile("파일명1"),
                new RecordingFile("파일명2"),
                new RecordingFile("파일명3")
                );
        recording.setRecordingFiles(recordingFiles);

        Recording selectedRecording = repository.save(recording);
        Assertions.assertEquals(1, selectedRecording.getId());

    }
}