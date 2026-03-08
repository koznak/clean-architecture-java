package com.profile.clean.api;

import com.profile.clean.application.WorkItemRepository;
import com.profile.clean.application.WorkItemService;
import com.profile.clean.infrastructure.InMemoryWorkItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {
    @Bean
    public WorkItemRepository workItemRepository() {
        return new InMemoryWorkItemRepository();
    }

    @Bean
    public WorkItemService workItemService(WorkItemRepository repository) {
        return new WorkItemService(repository);
    }
}
