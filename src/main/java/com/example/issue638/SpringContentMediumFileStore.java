package com.example.issue638;

import org.springframework.content.commons.repository.ContentStore;

//@StoreRestResource(path = "media-file-contents")
//@RestResource(exported = false)
public interface SpringContentMediumFileStore extends ContentStore<MediumFileContentJpaEntity, MediumFileContentJpaId> {
}