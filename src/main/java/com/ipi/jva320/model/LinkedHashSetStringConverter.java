package com.ipi.jva320.model;

import javax.persistence.AttributeConverter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * Extension JPA pour stocker des dates (de congés pris... uniques dans le set, ordonnées) sous forme de String.
 * NB. évite du paramétrage JPA qui n'est pas dans les prérequis du cours.
 */
public class LinkedHashSetStringConverter implements AttributeConverter<LinkedHashSet<LocalDate>, String> {

    public static final String DELIMITER = ";";

    @Override
    public String convertToDatabaseColumn(LinkedHashSet<LocalDate> localDates) {
        return localDates == null ? null
            : localDates.stream().map(d -> d.toString()).collect(Collectors.joining(DELIMITER));
    }

    @Override
    public LinkedHashSet<LocalDate> convertToEntityAttribute(String datesString) {
        return datesString == null ? null
                : new LinkedHashSet(Arrays.stream(datesString.split(DELIMITER))
                .filter(d -> !d.isEmpty()).map(ds -> LocalDate.parse(ds)).collect(Collectors.toList()));
    }
}
