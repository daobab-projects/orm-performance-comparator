package io.daobab.performance.hibernate.model;

public record CustomerAddress(
        String firstName,
        String lastName,
        String adress,
        String city
) {
}
