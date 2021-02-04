package countdown.app.NoviUlov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import countdown.app.R
import kotlinx.android.synthetic.main.activity_novi_ulov3.*
import kotlinx.android.synthetic.main.activity_novi_ulov8.*

class NoviUlov8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novi_ulov8)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Dodaj novi ulov")

        val vrstaUlov8: String = vrsta_ulov8.text.toString()
        val kilazaUlov8: String = kilaza_ulov8.text.toString()
        val vrijemeUlov8: String = vrijeme_ulov8.text.toString()
        val datumUlov8: String = datum_ulov8.text.toString()
        val mamacUlov8: String = mamac_ulov8.text.toString()
        val mjestoUlov8: String = mjesto_ulov8.text.toString()
        val gumbUnesi8: Button = unesi_ulov3.findViewById(R.id.unesi_ulov8)

    }
}