package countdown.app.NoviUlov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import countdown.app.R
import kotlinx.android.synthetic.main.activity_novi_ulov3.*
import kotlinx.android.synthetic.main.activity_novi_ulov9.*

class NoviUlov9Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novi_ulov9)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Dodaj novi ulov")

        val vrstaUlov9: String = vrsta_ulov9.text.toString()
        val kilazaUlov9: String = kilaza_ulov9.text.toString()
        val vrijemeUlov9: String = vrijeme_ulov9.text.toString()
        val datumUlov9: String = datum_ulov9.text.toString()
        val mamacUlov9: String = mamac_ulov9.text.toString()
        val mjestoUlov9: String = mjesto_ulov9.text.toString()
        val gumbUnesi9: Button = unesi_ulov3.findViewById(R.id.unesi_ulov9)

    }
}