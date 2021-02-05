package countdown.app

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_basic.*

class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        setSupportActionBar(findViewById(R.id.toolbar))

        val friends = listOf(
                DataModel("Dominik","Doric","ddoric@gmial.com",R.drawable.person3),
                DataModel("Pero","Peric","pperic@gmial.com",R.drawable.person1),
                DataModel("Ivo","Ivić","iv@gmial.com",R.drawable.person3),
                DataModel("Marko","Maric","marko@gmial.com",R.drawable.person1),
                DataModel("Luka","Lukic","luka@gmial.com",R.drawable.person1),
                DataModel("Tomo","Tomic","tomo@gmial.com",R.drawable.person3),
                DataModel("Matej","Matejic","matej@gmial.com",R.drawable.person3)
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@BasicActivity)
            adapter = MyAdapter(friends)
        }

    }
}