package com.profile.clean.api;

import com.profile.clean.application.WorkItemService;
import com.profile.clean.domain.WorkItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class WorkItemController {
    private final WorkItemService service;

    public WorkItemController(WorkItemService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of("service", "clean-architecture-api", "status", "healthy", "timestampUtc", Instant.now().toString());
    }

    @GetMapping("/api/work-items")
    public List<WorkItem> getAll() {
        return service.getAll();
    }

    @PostMapping("/api/work-items")
    public ResponseEntity<?> create(@RequestBody CreateWorkItemRequest request) {
        try {
            WorkItem created = service.create(request.title());
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("message", ex.getMessage()));
        }
    }

    public record CreateWorkItemRequest(String title) {
    }
}
