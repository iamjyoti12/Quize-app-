package com.my.quizeapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.my.quizeapp.Domain.QuestionModel
import com.my.quizeapp.R
import com.my.quizeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var bottombar: ChipNavigationBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menu: ChipNavigationBar = findViewById(R.id.bottombar)
        menu.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                // You can switch the ID to identify which item is clicked
                when (id) {
                    R.id.Home -> Toast.makeText(
                        this@MainActivity,
                        "Home Clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

        //this is for window bar color
        val window: Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey)

        binding.apply {
            bottombar.setItemSelected(R.id.Home)
            bottombar.setOnItemSelectedListener {
                if (it == R.id.Board) {
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))

                }
            }
            singleBtn.setOnClickListener{
                val intent= Intent(this@MainActivity, QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }
        }
    }
// This is list of questions. You can get Questions from your API service.

    private fun questionList(): MutableList<QuestionModel> {
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1, "Which planet is largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "D",
                5,
                "q_1",
                null
            )
        )

        question.add(
            QuestionModel(
                2, "Which country is the largest country in the world by land area?",
                "Russia",
                "Canada",
                "United States",
                "China",
                "a",
                5,
                "q_2",
                null
            )
        )

        question.add(
            QuestionModel(
                3, "Which of the following substances is used as an anti-cancer medication in the medical world?",
                "Cheese",
                "Lemon juice",
                "Cannabis",
                "Papaya",
                "c",
                5,
                "q_3",
                null
            )
        )

        question.add(
            QuestionModel(
                4, "Which moon in the Earth's solar system has an atmosphere?",
                "Luna (Moon)",
                "Phobos (Mars' moon ",
                "Venus' moon",
                " None of the above",
                "d",
                5,
                "q_4",
                null
            )
        )

        question.add(
            QuestionModel(
                5, "Which of the following symbols represents the chemical element with the atomic number 6?",
                "0",
                "H",
                "C",
                "N",
                "c",
                5,
                "q_5",
                null
            )
        )
        question.add(
            QuestionModel(
                6, "Who is created with inventing theater as we know it today?",
                "Shakespear",
                "Arthur Miller",
                "Ashok Kumar",
                "Ancient Greeks",
                "d",
                5,
                "q_6",
                null
            )
        )
        question.add(
            QuestionModel(
                7, "Which ocean is the largest ocean in the world?",
                "Pacific Ocean",
                "Atlantic Ocean",
                "Indian Ocean",
                "Arctic Ocean",
                "a",
                5,
                "q_7",
                null
            )
        )
        question.add(
            QuestionModel(
                8, "Which religions are among the most practiced religions in the world?",
                "Islam, Christianity, Judaism",
                "Budhhism, Hinduism, Sikhism",
                "Brahmanism, Hindusim, Yazansim",
                "Taosim. Zoroastruanism, Shintosim",
                "a",
                5,
                "q_8",
                null
            )
        )
        question.add(
            QuestionModel(
                9, "In which continent are the most independent counties located?",
                "Asia",
                "Egypt",
                "Africa",
                "Brazil",
                "c",
                5,
                "q_9",
                null
            )
        )
        question.add(
            QuestionModel(
                10, " Which ocean has the greatest average depth",
                "Pacific Ocean",
                "Atlantic Ocean",
                "Indian Ocean",
                "Arctic Ocean",
                "d",
                5,
                "q_10",
                null
            )
        )
        return question
    }
}