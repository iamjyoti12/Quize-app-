package com.my.quizeapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.my.quizeapp.Adapter.LeaderAdapter
import com.my.quizeapp.Domain.UserMode
import com.my.quizeapp.R
import com.my.quizeapp.databinding.ActivityLeaderBinding

class LeaderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //this is for window bar color
        val window: Window = this@LeaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey)


        binding.apply {
            scoreTop1.text = loadData().get(0).score.toString()
            scoreTop2.text = loadData().get(1).score.toString()
            scoreTop3.text = loadData().get(2).score.toString()
            titleTop1Txt.text = loadData().get(0).name
            titleTop2Txt.text = loadData().get(1).name
            titleTop3Txt.text = loadData().get(2).name

            val drawableResourceId1: Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(Pic1)

            val drawableResourceId2: Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(Pic2)

            val drawableResourceId3: Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(Pic3)

            bottomNavBar.setItemSelected(R.id.Board)
            bottomNavBar.setOnItemSelectedListener {
                if (it == R.id.Home) {
                    startActivity(Intent(this@LeaderActivity, MainActivity::class.java))
                }
            }

            var list: MutableList<UserMode> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)

            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }
        }
    }

    // You can get below list from your API service, this is a example list
    private fun loadData(): MutableList<UserMode> {
        val users: MutableList<UserMode> = mutableListOf()
        users.add(UserMode(1, "Jyoti", "person1", 4150))
        users.add(UserMode(2, "Harshit", "person2", 4981))
        users.add(UserMode(3, "Govansh", "person3", 3851))
        users.add(UserMode(4, "Bir", "person4", 3712))
        users.add(UserMode(5, "Yogita", "person5", 2217))
        users.add(UserMode(6, "Rohit", "person6", 2245))
        users.add(UserMode(7, "Chetna", "person7", 1452))
        users.add(UserMode(8, "Tiya", "person8", 2242))
        users.add(UserMode(9, "Preet", "person9", 1632))
        users.add(UserMode(10, "Jerry", "person9", 2021))
        return users

    }
}