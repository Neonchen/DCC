package db
import org.jetbrains.exposed.sql.Database

object Database{
    fun connect(): Database {
        val connect by lazy {
            Database.connect("jdbc:mysql://localhost:3306/infection",
                    driver = "com.mysql.jdbc.Driver",
                    user = "root", password = "root")
        }
        return connect
    }
}