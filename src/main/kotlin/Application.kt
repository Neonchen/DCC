import dao.VironDao
import db.Database
import io.javalin.ApiBuilder.*
import io.javalin.Javalin
import models.Viron

fun main(args: Array<String>) {
    val vironDao = VironDao()

    val app = Javalin.create().apply {
        port(7000)
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start()

    Database.connect()

    app.routes {

        get("/virons/:id") { ctx ->
            ctx.json(vironDao.findByOwner(ctx.param("id")!!))
        }

        post("/virons") { ctx ->
            val virons = ctx.bodyAsClass(Array<Viron>::class.java)
            vironDao.save(virons)
            ctx.status(201)
        }

        delete("/virons/:id") { ctx ->
            vironDao.deleteByOwner(ctx.param("id")!!)
            ctx.status(204)
        }

    }

}