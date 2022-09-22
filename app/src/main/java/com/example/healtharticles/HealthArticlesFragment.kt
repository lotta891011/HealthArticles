package com.example.healtharticles

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healtharticles.adapter.ArticleAdapter
import com.example.healtharticles.model.Article


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HealthArticlesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HealthArticlesFragment : Fragment() ,ArticleAdapter.OnItemClickListener{
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var intent : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_health_articles, container, false)
        val recyclerView= view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = context?.let { ArticleAdapter(initData(), it, this )}
        container?.removeAllViews()
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HealthArticlesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HealthArticlesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initData(): List<Article> {
        val itemList= ArrayList<Article>()
        itemList.add(Article(R.drawable.baner, "article1", "lol"))
        itemList.add(Article(R.drawable.baner, "article2", "oj"))
        itemList.add(Article(R.drawable.baner, "article1", "hej"))
        itemList.add(Article(R.drawable.baner, "article2", "wow"))
        itemList.add(Article(R.drawable.baner, "article1", "fuj"))
        itemList.add(Article(R.drawable.baner, "article2", "czesc"))
        itemList.add(Article(R.drawable.baner, "article1", "no"))
        itemList.add(Article(R.drawable.baner, "article2", "null"))
        itemList.add(Article(R.drawable.baner, "article1", "joł"))
        itemList.add(Article(R.drawable.baner, "article2", "flej"))
        return itemList
    }

    override fun onItemClick(position: Int) {
        val clickedItem: Article = initData()[position]
        Toast.makeText(context, "Item $position clickedm ${clickedItem.title}", Toast.LENGTH_SHORT).show()
        intent = Intent(context, ArticleActivity::class.java)
        intent.putExtra("image",clickedItem.imageResourceId)
        intent.putExtra("title",clickedItem.title)
        intent.putExtra("content",clickedItem.content)
        startActivity(intent)


    }
}