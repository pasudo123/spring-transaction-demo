package com.example.springtransactiondemo.model

import org.hibernate.annotations.Comment
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import kotlin.random.Random

@Entity
@Table(name = "coffee")
class Coffee(

    @Comment("이름")
    @Column(name = "name", length = 50, columnDefinition = "VARCHAR(64)")
    var name: String,

    @Comment("가격")
    @Column(name = "price", columnDefinition = "bigint")
    var price: Long
) {

    companion object {
        fun random(): Coffee {
            return Coffee(
                name = "아메리카노-${UUID.randomUUID().toString().substring(0, 10)}",
                price = Random.nextLong(1000000) % 100 * 100
            )
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set
}
