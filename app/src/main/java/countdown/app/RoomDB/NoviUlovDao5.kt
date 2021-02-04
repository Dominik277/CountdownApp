package countdown.app.RoomDB

import androidx.room.*

@Dao
interface NoviUlovDao5 {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoviUlov5(noviUlov5: NoviUlov5)

    @Update
    fun updateNoviUlov5(noviUlov5: NoviUlov5)

    @Delete
    fun deleteNoviUlov5(noviUlov5: NoviUlov5)

    @Query("SELECT * FROM novi_ulov5 WHERE vrsta5 == :name")
    fun getUlov5ByVrsta(name: String) : List<NoviUlov5>

    @Query("SELECT * FROM novi_ulov5")
    fun getUlov5(): List<NoviUlov5>

}