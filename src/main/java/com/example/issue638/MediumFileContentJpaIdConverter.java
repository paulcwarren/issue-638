package com.example.issue638;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

@Component
public class MediumFileContentJpaIdConverter implements BackendIdConverter {

//    @Autowired
//    private SpringDataMediumFileRepository repo;

//    @Override
//    public MediumFileContentJpaId convert(String source) {
//
//        MediumFileContentJpaId result = null;
//
//        List<MediumFileContentJpaEntity> entities = repo.findAll();
//        for (MediumFileContentJpaEntity entity : entities) {
//            if (entity.getId().toString().equals(source)) {
//                result = entity.getId();
//                break;
//            }
//        }
//
//        return result;
//    }

    @Override
    public boolean supports(Class<?> delimiter) {
        return delimiter.equals(MediumFileContentJpaEntity.class);
    }

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        if (id != null) {
            MediumFileContentJpaId ptid = new MediumFileContentJpaId();
            String[] idParts = id.split("_");
            ptid.setMediumId(idParts[0]);
            ptid.setFileId(idParts[1]);
            return ptid;
        }
//        return BackendIdConverter.DefaultIdConverter.INSTANCE.fromRequestId(id, entityType);
        return new MediumFileContentJpaId();
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        if (id instanceof MediumFileContentJpaId) {
            MediumFileContentJpaId ptid = (MediumFileContentJpaId) id;
            return String.format("%s_%s", ptid.getMediumId(), ptid.getFileId());
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.toRequestId(id, entityType);
    }
}
