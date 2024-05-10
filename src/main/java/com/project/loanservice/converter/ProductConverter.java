package com.project.loanservice.converter;

import com.project.loanservice.domain.Product;
import com.project.loanservice.exception.CustomServiceException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public class ProductConverter {

    @Converter
    public static class NameConverter
            implements AttributeConverter<Product, String> {

        @Override
        public String convertToDatabaseColumn(Product attribute) {
            if (attribute == null) {
                throw new CustomServiceException("Product is null");
            }
            return attribute.getName();
        }

        @Override
        public Product convertToEntityAttribute(String dbData) {
            return Product.fromName(dbData);
        }
    }


    @Converter
    public static class CodeConverter
            implements AttributeConverter<Product, String> {

        @Override
        public String convertToDatabaseColumn(Product attribute) {
            if (attribute == null) {
                throw new CustomServiceException("Product is Null");
            }
            return attribute.getCode();
        }

        @Override
        public Product convertToEntityAttribute(String dbData) {
            return Product.fromCode(dbData);
        }
    }


}