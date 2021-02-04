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
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_pozicija3.*

class Pozicija8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pozicija8)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Pozicija 8")

        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(context = this)
            noviUlov3Dao = db?.noviUlov3Dao()

            var noviUlov3_1 = NoviUlov3(1, "Šaran", "9,43 kg", "18:32", "21.06.2021", "Boila", "U prolazu")

            with(noviUlov3Dao) {
                this?.insertNoviUlov3(noviUlov3_1)
            }
            db?.noviUlov3Dao()?.getUlov3()
        }.doOnNext { list ->
            var vrsta3 = ""
            var kilaza3 = ""
            var vrijeme3 = ""
            var datum3 = ""
            var mamci3 = ""
            var mjesto3 = ""
            list?.map { vrsta3 += it.vrsta3 + " - " }
            list?.map { kilaza3 += it.kilaza3 + " - " }
            list?.map { vrijeme3 += it.vrijeme3 + " - " }
            list?.map { datum3 += it.datum3 + " - " }
            list?.map { mamci3 += it.mamac3 + " - " }
            list?.map { mjesto3 += it.mjesto3 + " - " }
            textViewVrsta3.text = vrsta3
            textViewKilaza3.text = kilaza3
            textViewVrijeme3.text = vrijeme3
            textViewDatum3.text = datum3
            textViewMamac3.text = mamci3
            textViewMjesto3.text = mjesto3
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