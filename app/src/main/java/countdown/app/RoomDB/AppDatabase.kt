package countdown.app.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database
(entities = arrayOf(
        NoviUlov3::class,
        NoviUlov5::class,
        NoviUlov8::class,
        NoviUlov9::class)
        ,version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun noviUlov3Dao() : NoviUlovDao3
    abstract fun noviUlov5Dao() : NoviUlovDao5
    abstract fun noviUlov8Dao() : NoviUlovDao8
    abstract fun noviUlov9Dao() : NoviUlovDao9

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase =
                Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java, "app-database"
                )
                        .addMigrations(MIGRATION_1_TO_2)
                        .build()

        private val MIGRATION_1_TO_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Task ADD notes TEXT NOT NULL default ''")
            }
        }
    }

}