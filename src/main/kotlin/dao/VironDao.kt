package dao

import db.entities.VironEntity
import db.tables.Virons
import models.Viron
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory


class VironDao {

    val logger = LoggerFactory.getLogger(VironDao::class.java)

    fun save(virons: Array<Viron>) {
        logger.info("saving: $virons")
        transaction {
            virons.forEach{
                VironEntity.new {
                    vironUuid = it.vironUuid
                    ownerUuid = it.ownerUuid
                    virusUuid = it.virusUuid
                    path = it.path
                }
            }
        }
    }

    fun findByOwner(ownerUuid: String): List<Viron> {
        lateinit var result : List<Viron>
        logger.info("findByOwner: $ownerUuid")
        transaction {
            result = VironEntity.find{ Virons.ownerUuid eq ownerUuid }.map { Viron(ownerUuid=it.ownerUuid, vironUuid = it.vironUuid, virusUuid = it.virusUuid, path = it.path) }
        }
        logger.info("found elements: ${result.size}")
        return result
    }

    fun deleteByOwner(ownerUuid: String) {
        logger.info("deleting: $ownerUuid")
        transaction {
            val virons = VironEntity.find{ Virons.ownerUuid eq ownerUuid }
            virons.forEach {
                it.delete()
            }
        }
    }

}