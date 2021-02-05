package countdown.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

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
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = FriendsAdapter(allFriends)
        }
    }
}