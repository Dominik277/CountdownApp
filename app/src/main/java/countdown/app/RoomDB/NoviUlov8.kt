package countdown.app.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "novi_ulov8")
data class NoviUlov8(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "vrsta8") val vrsta8: String?,
        @ColumnInfo(name = "kilaza8") val kilaza8: String?,
        @ColumnInfo(name = "vrijeme8") val vrijeme8: String?,
        @ColumnInfo(name = "datum8") val datum8: String?,
        @ColumnInfo(name = "mamac8") val mamac8: String?,
        @ColumnInfo(name = "mjesto8") val mjesto8: String?
)
