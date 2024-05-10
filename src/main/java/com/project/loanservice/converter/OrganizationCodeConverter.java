package com.project.loanservice.converter;

import com.project.loanservice.domain.Organization;
import com.project.loanservice.exception.CustomServiceException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class OrganizationCodeConverter implements AttributeConverter<Organization, String> {

    @Override
    public String convertToDatabaseColumn(Organization attribute) {
        if (attribute == null) {
            throw new CustomServiceException("Organization is Null");
        }
        return attribute.getCode();
    }

    @Override
    public Organization convertToEntityAttribute(String dbData) {
        return Organization.fromCode(dbData);
    }
}
