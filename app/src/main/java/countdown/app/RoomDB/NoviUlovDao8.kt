package countdown.app.RoomDB

import androidx.room.*

@Dao
interface NoviUlovDao8 {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoviUlov8(noviUlov8: NoviUlov8)

    @Update
    fun updateNoviUlov8(noviUlov8: NoviUlov8)

    @Delete
    fun deleteNoviUlov8(noviUlov8: NoviUlov8)

    @Query("SELECT * FROM novi_ulov8 WHERE vrsta8 == :name")
    fun getUlov8ByVrsta(name: String) : List<NoviUlov8>

    @Query("SELECT * FROM novi_ulov8")
    fun getUlov8(): List<NoviUlov8>

}