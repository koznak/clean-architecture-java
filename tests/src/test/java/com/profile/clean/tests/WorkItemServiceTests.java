package com.profile.clean.tests;

import com.profile.clean.application.WorkItemRepository;
import com.profile.clean.application.WorkItemService;
import com.profile.clean.domain.WorkItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WorkItemServiceTests {
    @Test
    void createAddsItemToRepository() {
        FakeRepository repository = new FakeRepository();
        WorkItemService service = new WorkItemService(repository);

        WorkItem item = service.create("First clean architecture task");

        assertEquals("First clean architecture task", item.title());
        assertEquals(1, repository.items.size());
    }

    @Test
    void createThrowsWhenTitleMissing() {
        WorkItemService service = new WorkItemService(new FakeRepository());
        assertThrows(IllegalArgumentException.class, () -> service.create("   "));
    }

    private static final class FakeRepository implements WorkItemRepository {
        private final List<WorkItem> items = new ArrayList<>();

        @Override
        public List<WorkItem> findAll() {
            return items;
        }

        @Override
        public WorkItem save(WorkItem item) {
            items.add(item);
            return item;
        }
    }
}
