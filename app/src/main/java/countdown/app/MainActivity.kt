package countdown.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val movieList = ArrayList<MovieModel>()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView);
        moviesAdapter = MoviesAdapter(movieList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = moviesAdapter
        prepareMovieData()

    }

    private fun prepareMovieData(){
        var movie = MovieModel("Mad Max: Fury Road","Action & Adventure","2015")
        movieList.add(movie)
        movie = MovieModel("Inside Out","Animation, Kids & Family","2015")
        movieList.add(movie)
        movie = MovieModel("Star Wars","Action","2015")
        movieList.add(movie)
        movie = MovieModel("Shaun The Sheep","Animation","2017")
        movieList.add(movie)
        movie = MovieModel("The Martian","Science Fiction and Fantasy","2015")
        movieList.add(movie)
        movie = MovieModel("Up","Animation","2019")
        movieList.add(movie)
        movie = MovieModel("Star Trek","Science and Fiction","2012")
        movieList.add(movie)
        movie = MovieModel("Back to the Future","Science Fiction","2012")
        movieList.add(movie)
        movie = MovieModel("Goldfinger","Action & Adventure","2015")
        movieList.add(movie)
        movie = MovieModel("Iron Man","Action & Adventure","2011")
        movieList.add(movie)
        movie = MovieModel("Chicken Run","Animation","2020")
    }

}