package com.example.issue638;

import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.rest.StoreRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@StoreRestResource(path = "media-file-contents")
@RestResource(exported = false)
public interface SpringContentMediumFileStore extends ContentStore<MediumFileContentJpaEntity, MediumFileContentJpaId> {
}