package countdown.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)

        actionBarToggle = ActionBarDrawerToggle(this,drawerLayout,0,0)
        drawerLayout.addDrawerListener(actionBarToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()

        navView = findViewById(R.id.navView)

        navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.pozicija3 -> {
                    Toast.makeText(this,"Pozicija 3",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.pozicija5 -> {
                    Toast.makeText(this,"Pozicija 5",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.pozicija8 -> {
                    Toast.makeText(this,"Pozicija 8",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.pozicija9 -> {
                    Toast.makeText(this,"Pozicija 9",Toast.LENGTH_LONG).show()
                    true
                }
                else -> {
                    false
                }
            }
        }

        fun onSupportNavigateUp(): Boolean {
            drawerLayout.openDrawer(navView)
            return true
        }

        fun onBackPressed(){
            if (this.drawerLayout.isDrawerOpen(GravityCompat.START)){
                this.drawerLayout.closeDrawer(GravityCompat.START)
            }else{
                super.onBackPressed()
            }
        }

    }
}