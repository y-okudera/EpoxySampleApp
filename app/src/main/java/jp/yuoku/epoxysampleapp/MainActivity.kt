package jp.yuoku.epoxysampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import jp.yuoku.epoxysampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val controller = SampleController(
        onClickItem = { name ->
            Log.d("MainActivity onClick: ", name)
        }
    )

    // 本当はViewModelのLiveDataをobserveした値を使用する
    private val data = listOf(
        Person(name = "Sato", imageResId = R.drawable.image1),
        Person(name = "Suzuki", imageResId = R.drawable.image2),
        Person(name = "Takahashi", imageResId = R.drawable.image3),
        Person(name = "Tanaka", imageResId = R.drawable.image4),
        Person(name = "Ito", imageResId = R.drawable.image5),
        Person(name = "Watanabe", imageResId = R.drawable.image1),
        Person(name = "Yamamoto", imageResId = R.drawable.image2),
        Person(name = "Nakamura", imageResId = R.drawable.image3),
        Person(name = "Kobayashi", imageResId = R.drawable.image4),
        Person(name = "Kato", imageResId = R.drawable.image5),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.setController(controller)

        // Dividerを追加
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                RecyclerView.VERTICAL
            )
        )

        // setDataを呼ぶことでデータが更新される
        controller.setData(data)
    }
}
