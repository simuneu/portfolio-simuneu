package com.simune.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introduction : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introduction_id")
    var id: Long? = null //?은 null을 허용
}