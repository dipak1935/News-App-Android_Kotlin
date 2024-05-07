package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerview:RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        myRecyclerview=findViewById(R.id.recyclerView)

        val newsImageArray= arrayOf(

            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6

        )

        val newsHeadingArray= arrayOf(

            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"

        )

        val newsContent= arrayOf(
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),

        )

        // for horizontal scrolling
        //myRecyclerview.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        // for vertical scrolling

        myRecyclerview.layoutManager=LinearLayoutManager(this)

        newsArrayList= arrayListOf<News>()

        for(index in newsImageArray.indices){
            val news= News(newsHeadingArray[index],newsImageArray[index],newsContent[index])
            newsArrayList.add(news)
        }

        val myAdapter=MyAdapter(newsArrayList,this)
        myRecyclerview.adapter=myAdapter



        myAdapter.setOnItemClickListener(object :MyAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

                // on clicking each item , what action do you want to perform

                val intent=Intent(this@MainActivity,NewsDetailActivity::class.java)

                //                      ^
                //                      |
                //   this, applicationContext , this@MainActivity

                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newsContent",newsArrayList[position].newsContent)


                startActivity(intent)


            }


        })




    }

}