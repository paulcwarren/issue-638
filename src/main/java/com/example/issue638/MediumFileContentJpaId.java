package com.example.issue638;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class MediumFileContentJpaId implements Serializable {

    private String mediumId;

    private String fileId;

    public MediumFileContentJpaId() {
        this.mediumId = UUID.randomUUID().toString();
        this.fileId = UUID.randomUUID().toString();
    }

    public MediumFileContentJpaId(String mediumId, String fileId) {
        this.mediumId = mediumId;
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return mediumId + "_" + fileId;
    }
}