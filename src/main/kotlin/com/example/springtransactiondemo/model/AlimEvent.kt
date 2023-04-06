package com.example.springtransactiondemo.model

import org.hibernate.annotations.Comment
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "alim_event")
class AlimEvent(
    @Comment("알림타입")
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 50, columnDefinition = "VARCHAR(64)")
    var type: Type
) {

    companion object {
        fun fromWithFailed(): AlimEvent {
            return AlimEvent(Type.FAILED)
        }

        fun fromWithSuccess(): AlimEvent {
            return AlimEvent(Type.SUCCESS)
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    enum class Type {
        FAILED,
        SUCCESS
    }
}
