package setup

import db.Database
import db.entities.VironEntity
import db.tables.Virons
import org.jetbrains.exposed.sql.SchemaUtils.drop
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    Database.connect()
    transaction {
        addLogger(StdOutSqlLogger)
        drop(Virons)
        println("Virons: ${VironEntity.all().joinToString {it.vironUuid}}")
    }
}