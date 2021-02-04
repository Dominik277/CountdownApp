package countdown.app.Pozicije

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import countdown.app.NoviUlov.NoviUlov8Activity
import countdown.app.R
import countdown.app.RoomDB.AppDatabase
import countdown.app.RoomDB.NoviUlov3
import countdown.app.RoomDB.NoviUlov8
import countdown.app.RoomDB.NoviUlovDao8
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_pozicija3.*
import kotlinx.android.synthetic.main.activity_pozicija3.textViewVrsta3
import kotlinx.android.synthetic.main.activity_pozicija8.*

class Pozicija8Activity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var noviUlov8Dao: NoviUlovDao8? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pozicija8)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Pozicija 8")

        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(context = this)
            noviUlov8Dao = db?.noviUlov8Dao()

            var noviUlov8_1 = NoviUlov8(1, "Šaran", "9,43 kg", "18:32", "21.06.2021", "Boila", "U prolazu")

            with(noviUlov8Dao) {
                this?.insertNoviUlov8(noviUlov8_1)
            }
            db?.noviUlov8Dao()?.getUlov8()
        }.doOnNext { list ->
            var vrsta8 = ""
            var kilaza8 = ""
            var vrijeme8 = ""
            var datum8 = ""
            var mamci8 = ""
            var mjesto8 = ""
            list?.map { vrsta8 += it.vrsta8 + " - " }
            list?.map { kilaza8 += it.kilaza8 + " - " }
            list?.map { vrijeme8 += it.vrijeme8 + " - " }
            list?.map { datum8 += it.datum8 + " - " }
            list?.map { mamci8 += it.mamac8 + " - " }
            list?.map { mjesto8 += it.mjesto8 + " - " }
            textViewVrsta8.text = vrsta8
            textViewKilaza8.text = kilaza8
            textViewVrijeme8.text = vrijeme8
            textViewDatum8.text = datum8
            textViewMamac8.text = mamci8
            textViewMjesto8.text = mjesto8
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_pozicija8,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_pozicija8 ->{
                val intent = Intent(this,NoviUlov8Activity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}