package countdown.app.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Par
@Entity(tableName = "user_table")
data class User(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val firstName: String,
        val lastName: String,
        val age: Int
): Parcelable