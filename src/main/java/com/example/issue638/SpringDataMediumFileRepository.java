package com.example.issue638;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "media-files")
public interface SpringDataMediumFileRepository extends JpaRepository<MediumFileContentJpaEntity, MediumFileContentJpaId>{

}
