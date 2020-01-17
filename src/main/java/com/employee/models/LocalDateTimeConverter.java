package com.employee.models;

import javax.persistence.AttributeConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements AttributeConverter<LocalDate, String> {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public String convertToDatabaseColumn(LocalDate localDate) {
        return (localDate == null ? null : formatter.format(localDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(String value) {
        return (value == null ? null : LocalDate.parse(value, formatter));
    }
}
