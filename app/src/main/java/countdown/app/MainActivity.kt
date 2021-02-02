package countdown.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var listNotes = ArrayList<Notes>()
    var dbManager:NotesDatabase?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbManager = DBManager().getDatabase(applicationContext)

        listNotes.add(ContactsContract.CommonDataKinds.Note(1, " meet professor", "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))
        listNotes.add(ContactsContract.CommonDataKinds.Note(2, " meet doctor", "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))
        listNotes.add(ContactsContract.CommonDataKinds.Note(3, " meet friend", "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))

        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show()

        //Load from DB


        LoadQuery("%")

    }

    override  fun onResume() {
        super.onResume()
        LoadQuery("%")
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show()
    }




    fun LoadQuery(title:String){




        listNotes = dbManager!!.NotesDao().loadByTitle(title) as ArrayList<Notes>


        var myNotesAdapter= MyNotesAdpater(this, listNotes)
        lvNotes.adapter=myNotesAdapter


    }

}