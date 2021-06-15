package jp.yuoku.epoxysampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import jp.yuoku.epoxysampleapp.databinding.ActivityMainBinding

import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.carousel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    // 本当はViewModelのLiveDataをobserveした値を使用する
    private val data = listOf(
        Person(id = 0, name = "Sato", imageResId = R.drawable.image1),
        Person(id = 1, name = "Suzuki", imageResId = R.drawable.image2),
        Person(id = 2, name = "Takahashi", imageResId = R.drawable.image3),
        Person(id = 3, name = "Tanaka", imageResId = R.drawable.image4),
        Person(id = 4, name = "Ito", imageResId = R.drawable.image5),
        Person(id = 5, name = "Watanabe", imageResId = R.drawable.image1),
        Person(id = 6, name = "Yamamoto", imageResId = R.drawable.image2),
        Person(id = 7, name = "Nakamura", imageResId = R.drawable.image3),
        Person(id = 8, name = "Kobayashi", imageResId = R.drawable.image4),
        Person(id = 9, name = "Kato", imageResId = R.drawable.image5),
    )

    private val carouselData = listOf(
        CarouselItem(id = 10, title = "Android", description = "Epoxy"),
        CarouselItem(id = 11, title = "Android", description = "Custom UI"),
        CarouselItem(id = 12, title = "Android", description = "DI"),
        CarouselItem(id = 13, title = "Android", description = "Live Data"),
        CarouselItem(id = 14, title = "Flutter", description = "Basic widgets"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        val rvTask = findViewById<EpoxyRecyclerView>(R.id.recycler_view)
        rvTask.withModels {

            // Carousel Item
            val carouselItemModels = carouselData.map { currentItem ->
                CarouselBindingModel_()
                    .id(currentItem.id)
                    .carouselItem(currentItem)
                    .onClick { model, parentView, clickedView, position ->
                        Log.d("Carousel onClick","title: ${model.carouselItem().title} , description: ${model.carouselItem().description}")
                    }
            }

            // Carousel
            // This extension function come with epoxy
            carousel {
                id("carousel")
                models(carouselItemModels)
            }

            data.forEach {
                sampleList {
                    id(it.id)
                    person(it)
                    onClick { _ ->
                        Log.d("Person list onClick","title: ${it.name}")
                    }
                }
            }
        }
    }
}
