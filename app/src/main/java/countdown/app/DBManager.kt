package countdown.app

import androidx.room.*

@Entity
data class Notes (

    @PrimaryKey(autoGenerate = true) val ID: Int,
    @ColumnInfo(name = "Title") val Title: String?,
    @ColumnInfo(name = "Description") val Description: String?

)

@Dao
interface NotesDao{

    @Query("SELECT * FROM Notes WHERE Title like :Title")
    fun loadByTitle(Title: String): List<Notes>

    @Insert
    fun insert(vararg notes:Notes)

    @Delete
    fun delete(note: Notes)

    @Update
    fun update(note: Notes)
}