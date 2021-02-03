package countdown.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import countdown.app.Pozicije.Pozicija3Activity
import countdown.app.Pozicije.Pozicija5Activity
import countdown.app.Pozicije.Pozicija8Activity
import countdown.app.Pozicije.Pozicija9Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawer: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer = findViewById(R.id.drawer)

        actionBarToggle = ActionBarDrawerToggle(this,drawer,0,0)
        drawer.addDrawerListener(actionBarToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()

        navView = findViewById(R.id.navigation_view)

        navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.pozicija3 -> {
                    val intent = Intent(this,Pozicija3Activity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Pozicija 3",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.pozicija5 -> {
                    val intent = Intent(this,Pozicija5Activity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Pozicija 5",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.pozicija8 -> {
                    val intent = Intent(this,Pozicija8Activity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Pozicija 8",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.pozicija9 -> {
                    val intent = Intent(this,Pozicija9Activity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Pozicija 9",Toast.LENGTH_LONG).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onBackPressed(){
        if (this.drawer.isDrawerOpen(GravityCompat.START)){
            this.drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(navView)
        return true
    }

}