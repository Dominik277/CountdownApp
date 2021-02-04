package countdown.app.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "novi_ulov3")
data class NoviUlov3(
     @PrimaryKey(autoGenerate = true) val id: Int,
     @ColumnInfo(name = "vrsta3") val vrsta3: String?,
     @ColumnInfo(name = "kilaza3") val kilaza3: String?,
     @ColumnInfo(name = "vrijeme3") val vrijeme3: String?,
     @ColumnInfo(name = "datum3") val datum3: String?,
     @ColumnInfo(name = "mamac3") val mamac3: String?,
     @ColumnInfo(name = "mjesto3") val mjesto3: String?
)
