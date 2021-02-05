package countdown.app

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FriendDao {

    @Query("SELECT * FROM friend")
    fun getAllFriends(): List<Friend>

    @Insert
    fun insertFriends(friend: Friend)

}