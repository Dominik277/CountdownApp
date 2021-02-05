package countdown.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.room.Room

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(this,
                FriendDatabase::class.java,
                "friend_database"
        )
                .allowMainThreadQueries()
                .build()
        database.friendDao().insertFriends(Friend(firstName = "Dominik",rating = 1000))
        val allFriends = database.friendDao().getAllFriends()
        d("Dominik","allFriends size? ${allFriends.size}")
    }
}