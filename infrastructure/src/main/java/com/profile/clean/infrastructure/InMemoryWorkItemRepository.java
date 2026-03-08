package com.profile.clean.infrastructure;

import com.profile.clean.application.WorkItemRepository;
import com.profile.clean.domain.WorkItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InMemoryWorkItemRepository implements WorkItemRepository {
    private final List<WorkItem> items = new ArrayList<>(List.of(
            WorkItem.create("Prepare architecture notes"),
            WorkItem.create("Write API walkthrough")
    ));

    @Override
    public List<WorkItem> findAll() {
        return items.stream()
                .sorted(Comparator.comparing(WorkItem::createdUtc).reversed())
                .toList();
    }

    @Override
    public WorkItem save(WorkItem item) {
        items.add(item);
        return item;
    }
}
