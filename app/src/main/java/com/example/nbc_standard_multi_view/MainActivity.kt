package com.example.nbc_standard_multi_view

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_multi_view.adapter.MyAdapter
import com.example.nbc_standard_multi_view.databinding.ActivityMainBinding
import com.example.nbc_standard_multi_view.item.MyItem
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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
        showTotalPrice()
        recyclerViewDivider()

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = MyAdapter().apply {
            setItemList(
                listOf(
                    MyItem.Card1(
                        tvName = "Anderson",
                        num1 = 2423,
                        num2 = 3581,
                        num3 = 9503,
                        num4 = 2412,
                        yM = "21/24",
                        price = 3100.30
                    ),
                    MyItem.Card2(
                        tvName = "John",
                        num1 = 1234,
                        num2 = 5678,
                        num3 = 9876,
                        num4 = 5432,
                        yM = "21/24",
                        price = 2459.60
                    ),
                    MyItem.Card3(
                        tvName = "Mash",
                        num1 = 4564,
                        num2 = 4564,
                        num3 = 7895,
                        num4 = 4125,
                        yM = "21/24",
                        price = 4567.20
                    )
                )
            )
        }

        binding.recyclerView.adapter = adapter


        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedData = adapter.getItemList()[position]
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                val bundle = Bundle().apply {
                    putParcelable("selectedData", selectedData)
                }
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }
    }


    //RecyclerView item 간격 추가
    private fun recyclerViewDivider() {
        binding.recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.bottom = 40
            }
        })
    }

    //전체 값 더하기(임시)
    private fun showTotalPrice() {
        val totalPrice = listOf(3100.30,2459.60,4567.20).sum()
        val decimal = DecimalFormat("#,##,###.00")
        binding.tvDollar.text = decimal.format(totalPrice)
    }
}