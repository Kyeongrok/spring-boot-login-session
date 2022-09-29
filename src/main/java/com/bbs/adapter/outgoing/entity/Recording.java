package com.bbs.adapter.outgoing.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Recording {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "RECORDING_ID")
    private Long id;
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "RECORDING_ID")
    private List<RecordingFile> recordingFiles;

}
