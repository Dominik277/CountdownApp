package countdown.app.RoomDB

import androidx.room.*

@Dao
interface NoviUlovDao9 {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoviUlov9(noviUlov9: NoviUlov9)

    @Update
    fun updateNoviUlov9(noviUlov9: NoviUlov9)

    @Delete
    fun deleteNoviUlov9(noviUlov9: NoviUlov9)

    @Query("SELECT * FROM novi_ulov9 WHERE vrsta9 == :name")
    fun getUlov9ByVrsta(name: String) : List<NoviUlov9>

    @Query("SELECT * FROM novi_ulov9")
    fun getUlov9(): List<NoviUlov9>

}