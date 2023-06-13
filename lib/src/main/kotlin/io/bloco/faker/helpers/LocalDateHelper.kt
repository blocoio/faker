package io.bloco.faker.helpers

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

internal fun LocalDate.toDate(): Date {
    return Date.from(atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
}

internal fun LocalDateTime.toDate(): Date {
    return Date.from(atZone(ZoneId.systemDefault()).toInstant())
}

internal fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(
        Instant.ofEpochMilli(this),
        TimeZone.getDefault().toZoneId()
    )
}

internal fun Date.toLocalDateTime(): LocalDateTime {
    return toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
}

internal fun Date.toLocalDate(): LocalDate {
    return toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
}
