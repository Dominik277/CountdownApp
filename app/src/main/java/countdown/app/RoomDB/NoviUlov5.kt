package countdown.app.RoomDB

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class NoviUlov5(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "vrsta5") val vrsta5: String?,
        @ColumnInfo(name = "kilaza5") val kilaza5: String?,
        @ColumnInfo(name = "vrijeme5") val vrijeme5: String?,
        @ColumnInfo(name = "datum5") val datum5: String?,
        @ColumnInfo(name = "mamac5") val mamac5: String?,
        @ColumnInfo(name = "mjesto5") val mjesto5: String?
)
