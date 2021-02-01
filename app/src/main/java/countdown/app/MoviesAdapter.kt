package countdown.app

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class MoviesAdapter(private var moviesList: List<MovieModel>):
RecyclerView.Adapter<MoviesAdapter.MyViewHolder>(){

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
