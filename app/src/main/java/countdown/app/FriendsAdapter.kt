package countdown.app

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FriendsAdapter (private val allFriends: List<Friend>) :
        RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsAdapter.ViewHolder {

    }

    override fun onBindViewHolder(holder: FriendsAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount() = allFriends.size

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view)

}