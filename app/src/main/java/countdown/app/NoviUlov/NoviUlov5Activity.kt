package countdown.app.NoviUlov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import countdown.app.R

class NoviUlov5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novi_ulov5)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Dodaj novi ulov")
    }
}