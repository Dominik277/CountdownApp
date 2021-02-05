package countdown.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.friend_row.view.*

class FriendsAdapter (private val allFriends: List<Friend>) :
        RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friend_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendsAdapter.ViewHolder, position: Int) {
        holder.view.name.text = allFriends[position].firstName
    }

    override fun getItemCount() = allFriends.size

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

}