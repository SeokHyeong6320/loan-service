package com.project.loanservice.converter;

import com.project.loanservice.domain.Product;
import com.project.loanservice.exception.CustomServiceException;
import com.project.loanservice.exception.ErrorCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProductCodeConverter implements AttributeConverter<Product, String> {

    @Override
    public String convertToDatabaseColumn(Product attribute) {
        if (attribute == null) {
            throw new CustomServiceException(ErrorCode.PRODUCT_NOT_FOUND);
        }
        return attribute.getCode();
    }

    @Override
    public Product convertToEntityAttribute(String dbData) {
        return Product.fromCode(dbData);
    }
}
