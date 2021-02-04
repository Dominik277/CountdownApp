package countdown.app.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "novi_ulov9")
data class NoviUlov9(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "vrsta9") val vrsta9: String?,
        @ColumnInfo(name = "kilaza9") val kilaza9: String?,
        @ColumnInfo(name = "vrijeme9") val vrijeme9: String?,
        @ColumnInfo(name = "datum9") val datum9: String?,
        @ColumnInfo(name = "mamac9") val mamac9: String?,
        @ColumnInfo(name = "mjesto9") val mjesto9: String?
)
