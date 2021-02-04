package countdown.app.RoomDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(NoviUlov3::class,NoviUlov5::class,NoviUlov8::class,NoviUlov9::class),version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noviUlovDao() : NoviUlovDao

}