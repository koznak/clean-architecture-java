package com.profile.clean.application;

import com.profile.clean.domain.WorkItem;

import java.util.List;

public class WorkItemService {
    private final WorkItemRepository repository;

    public WorkItemService(WorkItemRepository repository) {
        this.repository = repository;
    }

    public List<WorkItem> getAll() {
        return repository.findAll();
    }

    public WorkItem create(String title) {
        return repository.save(WorkItem.create(title));
    }
}
