package com.simune.portfolio.domain.repository

import com.simune.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface projectSkillRepository : JpaRepository<ProjectSkill, Long>