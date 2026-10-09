package cn.edu.sicnu.cs.stu.huangyiyi.second

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.cs.stu.huangyiyi.second.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var textViewCount = 0
    private val model = LanguageModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            addNewTextView()
        }

        val languages = resources.getStringArray(R.array.languages)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            languages
        )
        binding.spinnerLang.adapter = adapter

        binding.btnConfirm.setOnClickListener {
            val pos = binding.spinnerLang.selectedItemPosition
            binding.tvResult.text = model.getLanguageByPosition(pos)
        }
    }

    private fun addNewTextView() {
        textViewCount++
        val tv = TextView(this)
        tv.text = getString(R.string.textview_prefix) + textViewCount
        tv.textSize = 18f
        tv.setPadding(8, 12, 8, 12)
        binding.llContainer.addView(tv)
    }
}
