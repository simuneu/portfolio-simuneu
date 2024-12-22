package com.simune.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createDatetime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false)
    var updateDatetime: LocalDateTime = LocalDateTime.now()
}