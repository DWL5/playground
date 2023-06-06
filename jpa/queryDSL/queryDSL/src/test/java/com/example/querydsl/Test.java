package com.example.querydsl;

import org.assertj.core.api.Assertions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    @org.junit.jupiter.api.Test
    void testTime() {
        List<LocalDateTime> list = Arrays.asList(
                LocalDateTime.of(2023, 6, 4, 0, 0, 0, 0),
                LocalDateTime.of(2023, 6, 4, 0, 1, 0, 0),
                LocalDateTime.of(2023, 6, 4, 0, 2, 0, 0),
                LocalDateTime.of(2023, 6, 4, 0, 3, 0, 0),
                LocalDateTime.of(2023, 6, 4, 0, 4, 0, 0),
                LocalDateTime.of(2023, 6, 4, 0, 11, 0, 0),
                LocalDateTime.of(2023, 6, 4, 0, 12, 0, 0),
                LocalDateTime.of(2023, 6, 4, 0, 32, 0, 0)

        );

        Duration duration = Duration.ofMinutes(30);
        final long seconds = duration.getSeconds();

        Map<LocalDateTime, List<LocalDateTime>> map = list.stream().collect(
                Collectors.groupingBy(x -> {
                    long minutes = x.toEpochSecond(ZoneOffset.UTC);
                    long minutesOver = minutes % seconds;

                    return LocalDateTime.ofEpochSecond(minutes - minutesOver, 0, ZoneOffset.UTC);
                }));

        System.out.println(map);
        Assertions.assertThat(map.size()).isEqualTo(list.size());
    }
}
