package countdown.app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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

    class FoodAdapter: BaseAdapter() {

        var listOfFood=ArrayList<Food>()
        var context:Context?=null
        constructor(context: Context, listOfFood:ArrayList<Food>):super(){
            this.context=context
            this.listOfFood=listOfFood
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        @SuppressLint("ServiceCast")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.listOfFood[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView= inflator.inflate(R.layout.food_ticket,null)
            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.ivFoodImage.setOnClickListener {

                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
        }
            foodView.tvName.text =  food.name!!
            return  foodView
    }

}