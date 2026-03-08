package com.profile.clean.domain;

import java.time.Instant;
import java.util.UUID;

public record WorkItem(UUID id, String title, boolean isDone, Instant createdUtc) {
    public static WorkItem create(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required.");
        }
        return new WorkItem(UUID.randomUUID(), title.trim(), false, Instant.now());
    }
}
