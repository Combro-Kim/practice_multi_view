package com.example.nbc_standard_multi_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbc_standard_multi_view.data.DataItem
import com.example.nbc_standard_multi_view.data.viewobject.Card1ViewObject
import com.example.nbc_standard_multi_view.data.viewobject.Card3ViewObject
import com.example.nbc_standard_multi_view.adapter.DataAdapter
import com.example.nbc_standard_multi_view.databinding.ActivityMainBinding
import com.example.nbc_standard_multi_view.viewtype.ViewType

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = DataAdapter(
            arrayOf(
                DataItem(
                    ViewType.Card1.toString(),
                    Card1ViewObject(
                        tvName = "Anderson",
                        num1 = 2423,
                        num2 = 3581,
                        num3 = 9503,
                        num4 = 2412,
                        YM = "21/24",
                        price = 3100.30)
                ), DataItem(
                    ViewType.Card2.toString(),
                    Card3ViewObject(
                        tvName = "John",
                        num1 = 1234,
                        num2 = 5678,
                        num3 = 9876,
                        num4 = 5432,
                        YM = "21/24",
                        price = 2459.60
                    )
                ), DataItem(
                    ViewType.Card3.toString(),
                    Card1ViewObject(
                        tvName = "Mash",
                        num1 = 4564,
                        num2 = 4564,
                        num3 = 7895,
                        num4 = 4125,
                        YM = "21/24",
                        price = 4567.20
                    )
                )
            )
        )

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }


//    private fun initRecyclerView() {
//        val adapter = CommonAdapter(dataList())
//        val dataList = dataList()
//        binding.recyclerView.adapter = adapter
//
//        adapter.itemClick = object : DataAdapter.ItemClick {
//            override fun onClick(view: View, position: Int) {
//                val selectedData = dataList[position]
//                val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                intent.putExtra("selectedData", selectedData)
//                startActivity(intent)
//            }
//        }
//    }
}