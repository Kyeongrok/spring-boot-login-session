package com.bbs.adapter.incoming;

import com.bbs.adapter.outgoing.entity.Recording;
import com.bbs.adapter.outgoing.entity.RecordingFile;
import com.bbs.adapter.outgoing.port.RecordingPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class RecordingController {

    @Autowired
    private RecordingPort recordingPersistentAdapter;

    public RecordingController(RecordingPort recordingPersistentAdapter) {
        this.recordingPersistentAdapter = recordingPersistentAdapter;
    }

    private Optional<Recording> getRecording(long id) {
        return recordingPersistentAdapter.findById(id);
    }

    private Recording saveRecording(String title, int fileCnt) {

        Recording recording = new Recording();
        recording.setTitle(title);

        List<RecordingFile> recordingFiles = new ArrayList<>();
        for (int i = 0; i < fileCnt; i += 1){
            recordingFiles.add(new RecordingFile(String.format("파일 %s", i + 1)));
        }
        recording.setRecordingFiles(recordingFiles);

        return recordingPersistentAdapter.save(recording);
    }

    @PostMapping("/recording")
    public ResponseEntity<String> insert(@RequestParam String title, @RequestParam int fileCnt) {

        Recording recording = saveRecording(title, fileCnt);

        return ResponseEntity.ok(String.format("저장되었습니다. id:%s", recording.getId()));
    }

    @GetMapping("/recording/{id}")
    public ResponseEntity<Recording> select(@PathVariable long id) {

        Optional<Recording> recording = getRecording(id);
        if (recording.isPresent()) {
            return ResponseEntity.ok(recording.get());
        }else{
            log.info(String.format("id %s 를 찾을 수 없습니다.", id));
            throw new RuntimeException();
        }
    }

}
