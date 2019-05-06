package db.entities

import db.tables.Virons
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class VironEntity(id: EntityID<Int>) : IntEntity(id) {
        companion object : IntEntityClass<VironEntity>(Virons)

        var vironUuid by Virons.vironUuid
        var ownerUuid by Virons.ownerUuid
        var virusUuid by Virons.virusUuid
        var path by Virons.path
}