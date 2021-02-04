package countdown.app.NoviUlov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import countdown.app.R
import kotlinx.android.synthetic.main.activity_novi_ulov3.*
import kotlinx.android.synthetic.main.activity_novi_ulov5.*

class NoviUlov5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novi_ulov5)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Dodaj novi ulov")

        val vrstaUlov5: String = vrsta_ulov5.text.toString()
        val kilazaUlov5: String = kilaza_ulov5.text.toString()
        val vrijemeUlov5: String = vrijeme_ulov5.text.toString()
        val datumUlov5: String = datum_ulov5.text.toString()
        val mamacUlov5: String = mamac_ulov5.text.toString()
        val mjestoUlov5: String = mjesto_ulov5.text.toString()
        val gumbUnesi5: Button = unesi_ulov5.findViewById(R.id.unesi_ulov5)

    }
}