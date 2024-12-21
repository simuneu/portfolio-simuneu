package com.simune.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Skill : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null //?은 null을 허용
}