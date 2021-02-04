package countdown.app.Pozicije

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import countdown.app.NoviUlov.NoviUlov5Activity
import countdown.app.R
import countdown.app.RoomDB.AppDatabase
import countdown.app.RoomDB.NoviUlov3
import countdown.app.RoomDB.NoviUlov5
import countdown.app.RoomDB.NoviUlovDao5
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_pozicija3.*
import kotlinx.android.synthetic.main.activity_pozicija5.*

class Pozicija5Activity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var noviUlov5Dao: NoviUlovDao5? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pozicija5)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Pozicija 5")

        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(context = this)
            noviUlov5Dao = db?.noviUlov5Dao()

            var noviUlov5_1 = NoviUlov5(1, "Šaran", "9,43 kg", "18:32", "21.06.2021", "Boila", "U prolazu")

            with(noviUlov5Dao) {
                this?.insertNoviUlov5(noviUlov5_1)
            }
            db?.noviUlov5Dao()?.getUlov5()
        }.doOnNext { list ->
            var vrsta5 = ""
            var kilaza5 = ""
            var vrijeme5 = ""
            var datum5 = ""
            var mamci5 = ""
            var mjesto5 = ""
            list?.map { vrsta5 += it.vrsta5 + " - " }
            list?.map { kilaza5 += it.kilaza5 + " - " }
            list?.map { vrijeme5 += it.vrijeme5 + " - " }
            list?.map { datum5 += it.datum5 + " - " }
            list?.map { mamci5 += it.mamac5 + " - " }
            list?.map { mjesto5 += it.mjesto5 + " - " }
            textViewVrsta5.text = vrsta5
            textViewKilaza5.text = kilaza5
            textViewVrijeme5.text = vrijeme5
            textViewDatum5.text = datum5
            textViewMamac5.text = mamci5
            textViewMjesto5.text = mjesto5
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_pozicija5,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_pozicija5 -> {
                val intent = Intent(this,NoviUlov5Activity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}