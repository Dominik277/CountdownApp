package countdown.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment))

    }
}