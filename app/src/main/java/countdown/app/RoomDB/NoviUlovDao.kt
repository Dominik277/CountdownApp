package countdown.app.RoomDB

import androidx.room.*

@Dao
interface NoviUlovDao {

    @Query("SELECT * FROM novi_ulov3")
    fun getAll3(): List<NoviUlov3>
    @Insert
    fun insertAll3(vararg noviulov3: NoviUlov3)
    @Delete
    fun deleteAll3(noviulov3: NoviUlov3)
    @Update
    fun updateAll3(noviulov3: NoviUlov3)


    @Query("SELECT * FROM novi_ulov5")
    fun getAll5(): List<NoviUlov5>
    @Insert
    fun insertAll5(vararg noviulov5: NoviUlov5)
    @Delete
    fun deleteAll5(noviulov5: NoviUlov5)
    @Update
    fun updateAll5(noviulov5: NoviUlov5)


    @Query("SELECT * FROM novi_ulov8")
    fun getAll8(): List<NoviUlov8>
    @Insert
    fun insertAll8(vararg noviulov8: NoviUlov8)
    @Delete
    fun deleteAll8(noviulov8: NoviUlov8)
    @Update
    fun updateAll8(noviulov8: NoviUlov8)


    @Query("SELECT * FROM novi_ulov9")
    fun getAll9(): List<NoviUlov9>
    @Insert
    fun insertAll9(vararg noviulov9: NoviUlov9)
    @Delete
    fun deleteAll9(noviulov9: NoviUlov9)
    @Update
    fun updateAll9(noviulov3: NoviUlov9)


}