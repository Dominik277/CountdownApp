package countdown.app.Pozicije

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import countdown.app.NoviUlov.NoviUlov9Activity
import countdown.app.R
import countdown.app.RoomDB.AppDatabase
import countdown.app.RoomDB.NoviUlov3
import countdown.app.RoomDB.NoviUlov9
import countdown.app.RoomDB.NoviUlovDao9
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_pozicija3.*
import kotlinx.android.synthetic.main.activity_pozicija9.*

class Pozicija9Activity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var noviUlov9Dao: NoviUlovDao9? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pozicija9)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Pozicija 9")

        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(context = this)
            noviUlov9Dao = db?.noviUlov9Dao()

            var noviUlov9_1 = NoviUlov9(1, "Šaran", "9,43 kg", "18:32", "21.06.2021", "Boila", "U prolazu")

            with(noviUlov9Dao) {
                this?.insertNoviUlov9(noviUlov9_1)
            }
            db?.noviUlov9Dao()?.getUlov9()
        }.doOnNext { list ->
            var vrsta9 = ""
            var kilaza9 = ""
            var vrijeme9 = ""
            var datum9 = ""
            var mamci9 = ""
            var mjesto9 = ""
            list?.map { vrsta9 += it.vrsta9 + " - " }
            list?.map { kilaza9 += it.kilaza9 + " - " }
            list?.map { vrijeme9 += it.vrijeme9 + " - " }
            list?.map { datum9 += it.datum9 + " - " }
            list?.map { mamci9 += it.mamac9 + " - " }
            list?.map { mjesto9 += it.mjesto9 + " - " }
            textViewVrsta9.text = vrsta9
            textViewKilaza9.text = kilaza9
            textViewVrijeme9.text = vrijeme9
            textViewDatum9.text = datum9
            textViewMamac9.text = mamci9
            textViewMjesto9.text = mjesto9
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_pozicija9,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_pozicija9 ->{
                val intent = Intent(this,NoviUlov9Activity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}