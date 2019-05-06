package setup

import db.Database
import db.entities.VironEntity
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    Database.connect()
    transaction {
        addLogger(StdOutSqlLogger)
        VironEntity.new {
            ownerUuid = "123"
            vironUuid = "456"
            virusUuid = "789"
            path = "fancy path"
        }
        println("Virons: ${VironEntity.all().joinToString {it.vironUuid}}")
    }
}