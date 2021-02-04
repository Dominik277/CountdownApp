package countdown.app.NoviUlov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import countdown.app.R
import kotlinx.android.synthetic.main.activity_novi_ulov3.*

class NoviUlov3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novi_ulov3)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Dodaj novi ulov")

        val vrstaUlov3: String = vrsta_ulov3.text.toString()
        val kilazaUlov3: String = kilaza_ulov3.text.toString()
        val vrijemeUlov3: String = vrijeme_ulov3.text.toString()
        val datumUlov3: String = datum_ulov3.text.toString()
        val mamacUlov3: String = mamac_ulov3.text.toString()
        val mjestoUlov3: String = mjesto_ulov3.text.toString()
        val gumbUnes5: Button = unesi_ulov3.findViewById(R.id.unesi_ulov3)



    }
}