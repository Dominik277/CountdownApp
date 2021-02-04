package countdown.app.RoomDB

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database
(entities = arrayOf(
        NoviUlov3::class,
        NoviUlov5::class,
        NoviUlov8::class,
        NoviUlov9::class)
        ,version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noviUlov3Dao() : NoviUlovDao3
    abstract fun noviUlov5Dao() : NoviUlovDao5
    abstract fun noviUlov8Dao() : NoviUlovDao8
    abstract fun noviUlov9Dao() : NoviUlovDao9

    companion object {
        @Volatile
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java,
                            "myDB")
                            .build()
                }
            }
            return INSTANCE
        }
        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}