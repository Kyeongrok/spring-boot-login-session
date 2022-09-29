package com.bbs.adapter.outgoing.dto;

import com.bbs.adapter.outgoing.entity.RecordingFile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecordingDto {
    private long id;
    private String title;
    private List<RecordingFile> recordingFiles;
}
