package com.learning.storiesprogressview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learning.storiesprogressview.databinding.ActivityMainBinding
import com.learning.storiesprogressview.widgets.StoriesProgressView.StoriesListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val imageList = arrayListOf(
        R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
        R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10
    )

    private val totalCount = imageList.size

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        loadActivity()

    }

    private fun loadActivity() {

        with(binding) {

            storiesProgressView.apply {
                setStoriesCount(totalCount)
                setStoryDuration(3000L)
                startStories()
                setStoriesListener(object : StoriesListener {

                    override fun onNext() {
                        image.setImageResource(imageList[++counter])
                    }

                    override fun onPrev() {
                        if ((counter - 1) < 0) return
                        image.setImageResource(imageList[--counter])
                    }

                    override fun onComplete() {

                    }

                })

            }

            reverse.setOnClickListener { storiesProgressView.reverse() }

            skip.setOnClickListener { storiesProgressView.skip() }

        }

    }

}