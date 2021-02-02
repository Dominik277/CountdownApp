package countdown.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var adapter:FoodAdapter?=null
    var listOfFoods=ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfFoods.add(Food("","",))
        listOfFoods.add(Food("","",))
        listOfFoods.add(Food("","",))
        listOfFoods.add(Food("","",))
        listOfFoods.add(Food("","",))
        listOfFoods.add(Food("","",))
        listOfFoods.add(Food("","",))
        listOfFoods.add(Food("","",))

        gvListFood.adapter = adapter

    }
}