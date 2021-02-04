package countdown.app.Pozicije

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import countdown.app.NoviUlov.NoviUlov3Activity
import countdown.app.R
import countdown.app.RoomDB.AppDatabase
import countdown.app.RoomDB.NoviUlov3
import countdown.app.RoomDB.NoviUlovDao3
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class Pozicija3Activity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var noviUlov3Dao: NoviUlovDao3? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pozicija3)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Pozicija 3")

        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(context = this)
            noviUlov3Dao = db?.noviUlov3Dao()

            var noviUlov3_1 = NoviUlov3(1, "Šaran", "9,43 kg", "18:32", "21.06.2021", "Boila", "U prolazu")
            var noviUlov3_2 = NoviUlov3(2, "Šaran", "4,43 kg", "12:32", "11.09.2021", "Boila", "Ispre otoka")

            with(noviUlov3Dao) {
                this?.insertNoviUlov3(noviUlov3_1)
                this?.insertNoviUlov3(noviUlov3_2)
            }
            db?.noviUlov3Dao()?.getUlov3()
        }.doOnNext { list ->
            var finalString = ""
            list?.map { finalString += it.name + " - " }
            tv_message.text = finalString
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_pozicija3,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_pozicija3 -> {
                val intent = Intent(this,NoviUlov3Activity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}