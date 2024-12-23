package com.simune.portfolio.domain.repository

import com.simune.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {
    fun findByIsActive(isActive: Boolean): List<Achievement>

}