package com.simune.portfolio.domain.repository

import com.simune.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {
    fun countAllByCreateTimeBeetwen(start: LocalDateTime, end: LocalDateTime): Long
}