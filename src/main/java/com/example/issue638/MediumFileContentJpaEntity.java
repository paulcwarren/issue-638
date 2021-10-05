package com.example.issue638;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.content.commons.annotations.MimeType;

import lombok.Getter;

@Entity
@Getter
public class MediumFileContentJpaEntity  {

    @EmbeddedId
    private MediumFileContentJpaId id = new MediumFileContentJpaId();

    @ContentId
    @Column(name = "content_id")
    private String contentId;

    @ContentLength
    @Column(name = "content_length")
    private long contentLength;

    @MimeType
    @Column(name = "mime_type")
    private String mimeType = "video/mp4";
}
