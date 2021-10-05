//package com.example.issue638;
//
//import java.io.Serializable;
//
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//
//public class MediumFileContentJpaIdGenerator implements IdentifierGenerator {
//
//    private String prefix;
//
//    @Override
//    public Serializable generate(
//      SharedSessionContractImplementor session, Object obj)
//      throws HibernateException {
//
//        return ((MediumFileContentJpaEntity)obj).getMediumId() + "_" +
//                ((MediumFileContentJpaEntity)obj).getFileId();
//    }
//}
