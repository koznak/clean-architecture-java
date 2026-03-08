package com.profile.clean.application;

import com.profile.clean.domain.WorkItem;

import java.util.List;

public interface WorkItemRepository {
    List<WorkItem> findAll();
    WorkItem save(WorkItem item);
}
