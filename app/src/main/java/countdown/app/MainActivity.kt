package countdown.app

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
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

        //listNotes.add(ContactsContract.CommonDataKinds.Note(1, " meet professor", "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))
        //listNotes.add(ContactsContract.CommonDataKinds.Note(2, " meet doctor", "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))
        //listNotes.add(ContactsContract.CommonDataKinds.Note(3, " meet friend", "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))

        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        val sv: SearchView = menu.findItem(R.id.app_bar_search).actionView as SearchView

        val sm= getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext,query,Toast.LENGTH_LONG).show()
                LoadQuery("%$query%")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item != null) {
            when(item.itemId){
                R.id.addNote->{
                    //Got to add paage
                    var intent= Intent(this,AddNotes::class.java)
                    startActivity(intent)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    inner class MyNotesAdpater: BaseAdapter() {

        var listNotesAdapter = ArrayList<Notes>()
        var context:Context?=null
        constructor(context: Context, listNotesAdapter:ArrayList<Notes>):super(){
            this.listNotesAdapter=listNotesAdapter
            this.context=context
        }

        override fun getCount(): Int {
            return listNotesAdapter.size
        }

        override fun getItem(p0: Int): Any {
            return listNotesAdapter[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var myView=layoutInflater.inflate(R.layout.ticcket,null)
            var myNote = listNotesAdapter[p0]
            myView.tvTitle.text=myNote.Title
            myView.tvDes.text=myNote.Description
            myView.ivDelete.setOnClickListener{
                dbManager!!.NotesDao().delete(myNote)
                LoadQuery("%")
            }
            myView.ivEdit.setOnClickListener{
                GoToUpdate(myNote)
            }
            return myView
        }

    }

    fun GoToUpdate(note:Notes){
        var intent = Intent(this,AddNotes::class.java)
        intent.putExtra("ID",note.ID)
        intent.putExtra("name",note.Title)
        intent.putExtra("des",note.Description)
        startActivity(intent)
    }

}