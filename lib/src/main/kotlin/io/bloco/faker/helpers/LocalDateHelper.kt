package io.bloco.faker.helpers

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


fun LocalDate.toDate(): Date {
    return Date.from(this.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
}

fun LocalDateTime.toDate(): Date {
    return Date.from(this.atZone(ZoneId.systemDefault()).toInstant())
}

fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(
        Instant.ofEpochMilli(this),
        TimeZone.getDefault().toZoneId()
    );
}

fun Date.toLocalDateTime(): LocalDateTime {
    return this.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
}

fun Date.toLocalDate() : LocalDate {
    return this.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate();
}