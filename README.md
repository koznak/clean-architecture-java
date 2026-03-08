# clean-architecture-java

Clean Architecture sample in Java 21 + Spring Boot.

## Layers

- `domain`
- Business entity (`WorkItem`) and business rules.
- `application`
- Use case and port (`WorkItemService`, `WorkItemRepository`).
- `infrastructure`
- In-memory adapter (`InMemoryWorkItemRepository`).
- `api`
- Delivery layer and dependency wiring (Spring Boot REST API).

## Run

```powershell
mvn clean test
mvn -pl api spring-boot:run
```

## Endpoints

- `GET /health`
- `GET /api/work-items`
- `POST /api/work-items`

Sample request body:

```json
{
  "title": "Review clean architecture candidate sample"
}
```
"# clean-architecture-java" 
