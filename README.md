# spring-r2dbc-samples
Some examples for basic usage for Spirng r2dbc.

# Framework
- Spring Boot 2.3.0.RELEASE
- Spring Boot WebFlux
- Embeded jersey container 
- Spring Boot Data R2DBC
- r2dbc mysql
- lombok

# Requirements
- jdk 8 or above

# Project Structures
- project root
  - config: configuration for Spring Boot and Spring Data
  - controller: controller classes
  - entity: database table mapping
  - repository: derived from ReactiveCrudRepository
  - service: service layer

# Features
- Runnable example for WebFlux and Reactive MySQL
- Controller-based reactive programming paradism 
- support CRUD
- custom naming strategy to keep name conversion to snake_case style (@Column annotation is no need) 
- Basic entity field are no need set manually, like createdAt and updatedAt

# Entity Base
  - Basic Fields
    - id (set by MySQL automatically)
    - remark (optional)
    - active (default 1)
    - createdAt (set by MySQL automatically)
    - createdBy
    - updatedAt (set and update by MySQL automatically)
    - updatedBy


# Issues to solve
- Spring R2DBC is not support Data Audit, so annotations like @CreatedBy is not supported yet

# Sample Database
## Student Table
```sql
CREATE TABLE `spring_r2dbc_samples`.`Student`  (
    `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    `code` varchar(50) NOT NULL,
    `name` varchar(50) NOT NULL,
    `gender` char(1) NOT NULL,
    `birthday` date NOT NULL,
    `address` varchar(300) NULL,
    `remark` varchar(1000) NULL,
    `active` tinyint NOT NULL DEFAULT 1,
    `createdAt` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    `createdBy` varchar(50) NOT NULL,
    `updatedAt` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
    `updatedBy` varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idx_main`(`code`)
);

```

# Key code snippet
## find all entities
```java
    return studentRepository.findByCodeAndActiveTrue(code)
        .switchIfEmpty(Mono.error(new IllegalArgumentException("invalid student code: " + code)));
```

## update entity
 ```java
    student.setAddress(address);
    student.setRemark(remark);

    return studentRepository.save(student);
```


