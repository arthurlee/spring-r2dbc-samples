# spring-r2dbc-samples
Some examples for basic usage for Spirng r2dbc.

# Framework
- Spring Boot 2.3.0.RELEASE
- Spring Boot WebFlux
- Embeded jersey container 
- Spring Boot Data R2DBC
- r2dbc mysql
- lombok

# Project Structures
- config: configuration for Spring Boot and Spring Data
- controller: controller classes
- entity: database table mapping
- repository: derived from ReactiveCrudRepository
- service: service layer

# Features
- Runnable example for WebFlux and Reactive MySQL
- support CRUD
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
 
