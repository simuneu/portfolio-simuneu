package com.simune.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectDetail : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_detail_id")
    var id: Long? = null //?은 null을 허용
}