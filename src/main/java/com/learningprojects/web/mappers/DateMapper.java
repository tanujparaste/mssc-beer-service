package com.learningprojects.web.mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

@Component
public class DateMapper {
	public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
		if (offsetDateTime != null) {
			return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
		}
		return null;
	}

	public OffsetDateTime asOffsetDateTime(Timestamp timestamp) {
		if (timestamp != null) {
			LocalDateTime ldt = timestamp.toLocalDateTime();
			return OffsetDateTime.of(ldt, ZoneOffset.UTC);
		}
		return null;
	}
}
