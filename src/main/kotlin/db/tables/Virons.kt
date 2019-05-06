package db.tables

import org.jetbrains.exposed.dao.IntIdTable


object Virons : IntIdTable(){
    val vironUuid  = varchar("viron_uuid",36).uniqueIndex()
    val ownerUuid = varchar("owner_uuid",36)
    val virusUuid = varchar("virus_uuid",36)
    val path = varchar("path",4000)
}