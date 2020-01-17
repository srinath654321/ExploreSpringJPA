package com.employee.util;

import com.employee.models.LocalDateTimeConverter;

import java.time.LocalDate;

public class EmployeeUtil {

    public static LocalDate parseLocalDateString(String localDate){
        return LocalDate.parse(localDate, LocalDateTimeConverter.formatter);
    }
}
