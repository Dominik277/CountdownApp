package countdown.app.RoomDB

import androidx.room.*

@Dao
interface NoviUlovDao {

    @Query("SELECT * FROM novi_ulov3")
    fun getAll3(): List<NoviUlov3>

    @Insert
    fun insertAll(vararg noviulov3: NoviUlov3)

    @Delete
    fun deleteAll(noviulov3: NoviUlov3)

    @Update
    fun updateAll(noviulov3: NoviUlov3)

}