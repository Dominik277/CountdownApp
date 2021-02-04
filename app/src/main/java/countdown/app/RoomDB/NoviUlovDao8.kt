package countdown.app.RoomDB

import androidx.room.*

@Dao
interface NoviUlovDao8 {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoviUlov3(noviUlov3: NoviUlov3)

    @Update
    fun updateNoviUlov3(noviUlov3: NoviUlov3)

    @Delete
    fun deleteNoviUlov3(noviUlov3: NoviUlov3)

    @Query("SELECT * FROM novi_ulov3 WHERE vrsta3 == :name")
    fun getUlov3ByVrsta(name: String) : List<NoviUlov8>

    @Query("SELECT * FROM novi_ulov3")
    fun getUlov3(): List<NoviUlov8>

}