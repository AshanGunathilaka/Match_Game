package com.example.match_game

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Html
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class game2 : AppCompatActivity() {

    private var countDownTimer: CountDownTimer? = null
    private lateinit var sharedPreferences: SharedPreferences
    private var selections1 = 1
    private var selections2 = 1
    private var selections3 = 1
    private var selections4 = 1
    private var selections5 = 1

    private var score = 0
    private var buttonValue1 = ""
    private var buttonValue2 = ""
    private var buttonValue3 = ""
    private var buttonValue4 = ""
    private var buttonValue5 = ""

    private var displayedValue = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        sharedPreferences = getSharedPreferences("GamePreferences", Context.MODE_PRIVATE)

        val button1 = listOf<Button>(
            findViewById(R.id.num_10),
            findViewById(R.id.num_20),
            findViewById(R.id.num_30),
            findViewById(R.id.num_40),
            findViewById(R.id.num_60),
        )

        val button2 = listOf<Button>(
            findViewById(R.id.num_50),
            findViewById(R.id.num_70),
            findViewById(R.id.num_80),
            findViewById(R.id.num_90),
            findViewById(R.id.num_100)
        )

        val button3 = listOf<Button>(
            findViewById(R.id.num_110),
            findViewById(R.id.num_120),
            findViewById(R.id.num_130),
            findViewById(R.id.num_140),
            findViewById(R.id.num_150)
        )

        val button4 = listOf<Button>(
            findViewById(R.id.num_160),
            findViewById(R.id.num_170),
            findViewById(R.id.num_180),
            findViewById(R.id.num_190),
            findViewById(R.id.num_200)
        )

        val button5 = listOf<Button>(
            findViewById(R.id.num_210),
            findViewById(R.id.num_220),
            findViewById(R.id.num_230),
            findViewById(R.id.num_240),
            findViewById(R.id.num_250)
        )



        val timerTextView = findViewById<TextView>(R.id.timerTextView)
        val displayNumTextView = findViewById<TextView>(R.id.display_num)
        val scoreview = findViewById<TextView>(R.id.Scorevalue)
        val submitButton = findViewById<Button>(R.id.submit_button)
        val restartButton = findViewById<Button>(R.id.restart_button)
        val backButton = findViewById<Button>(R.id.bck_button)


        //button1
        for (button in button1) {
            button.setOnClickListener {
                buttonValue1 = button.text.toString()
                displayedValue = displayNumTextView.text.toString()

                // Decrement selections and update UI accordingly
                selections1--

                button.setBackgroundColor(Color.parseColor("#00BCD4"))

                if (selections1 == 0) {
                    for (btn in button1) {
                        btn.isEnabled = false
                    }
                }
            }
        }

        //button2
        for (button in button2) {
            button.setOnClickListener {
                buttonValue2 = button.text.toString()
                displayedValue = displayNumTextView.text.toString()

                // Decrement selections and update UI accordingly
                selections2--

                button.setBackgroundColor(Color.parseColor("#00BCD4"))

                if (selections2 == 0) {
                    for (btn in button2) {
                        btn.isEnabled = false
                    }
                }
            }
        }


        //button3
        for (button in button3) {
            button.setOnClickListener {
                buttonValue3 = button.text.toString()
                displayedValue = displayNumTextView.text.toString()

                // Decrement selections and update UI accordingly
                selections3--

                button.setBackgroundColor(Color.parseColor("#00BCD4"))

                if (selections3 == 0) {
                    for (btn in button3) {
                        btn.isEnabled = false
                    }
                }
            }
        }

        //button4
        for (button in button4) {
            button.setOnClickListener {
                buttonValue4 = button.text.toString()
                displayedValue = displayNumTextView.text.toString()

                // Decrement selections and update UI accordingly
                selections4--

                button.setBackgroundColor(Color.parseColor("#00BCD4"))

                if (selections4 == 0) {
                    for (btn in button4) {
                        btn.isEnabled = false
                    }
                }
            }
        }


        //button5
        for (button in button5) {
            button.setOnClickListener {
                buttonValue5 = button.text.toString()
                displayedValue = displayNumTextView.text.toString()

                // Decrement selections and update UI accordingly
                selections5--

                button.setBackgroundColor(Color.parseColor("#00BCD4"))

                if (selections5 == 0) {
                    for (btn in button5) {
                        btn.isEnabled = false
                    }
                }
            }
        }

        submitButton.setOnClickListener {

            // Stop the CountDownTimer
            countDownTimer?.cancel()

            if (buttonValue1 == displayedValue && buttonValue2 == displayedValue && buttonValue3 == displayedValue
                && buttonValue4 == displayedValue && buttonValue5 == displayedValue) {

                //count score
                score++
                scoreview.text = score.toString()

                Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()

                buttonValue1 = ""
                buttonValue2 = ""
                buttonValue3 = ""
                buttonValue4 = ""
                buttonValue5 = ""

                restartButton.performClick()


            } else {

                //Dialog box
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setMessage("You Lost.Try again..")
                alertDialogBuilder.setPositiveButton("Restart") { dialog, which ->
                    restartButton.performClick()
                }

                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()

                // Retrieve existing "game_result" data
                val existingData = sharedPreferences.getString("game_result", "")

                if (score != 0) {
                    // Create new game result entry with current date and time
                    val currentDateTime =
                        SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
                    val newGameResult = "$currentDateTime - Score $score"

                    // Combine new data with existing data, separated by newline
                    val updatedGameResult = if (existingData.isNullOrEmpty()) {
                        newGameResult
                    } else {
                        // Split existing data into lines
                        val lines = existingData.split("\n")
                        // If the number of lines exceeds 10, remove the last line (oldest data)
                        val updatedLines = if (lines.size >= 5) {
                            lines.dropLast(1)
                        } else {
                            lines
                        }
                        // Combine updated lines with new data
                        val updatedData = updatedLines.joinToString("\n")
                        "$newGameResult\n$updatedData"
                    }

                    // Save updated game result data to SharedPreferences
                    val editor = sharedPreferences.edit()
                    editor.putString("game_result", updatedGameResult)
                    editor.apply()
                }

                //reset score
                score = 0
                scoreview.text = score.toString()

            }
        }

        backButton.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            val cautionMessage = "<font color='#FF0000'><b>Caution:</b> Score will be lost</font>"
            alertDialogBuilder.setMessage(Html.fromHtml("Do you want to finish the game?<br>$cautionMessage"))
            alertDialogBuilder.setPositiveButton("Finish") { dialog, which ->
                // Stop the CountDownTimer
                countDownTimer?.cancel()
                var intent = Intent(this,Home::class.java)
                startActivity(intent)
                finish()
            }
            alertDialogBuilder.setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }

            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }

        val TotalValuLetters = arrayOf('1', '2', '3', '4', '5')
        val Button_numbers1 = arrayOf('1', '2', '3', '4', '5')
        val Button_numbers2 = arrayOf('1', '2', '3', '4', '5')
        val Button_numbers3 = arrayOf('1', '2', '3', '4', '5')
        val Button_numbers4 = arrayOf('1', '2', '3', '4', '5')
        val Button_numbers5= arrayOf('1', '2', '3', '4', '5')

        restartButton.setOnClickListener {
            // Stop the CountDownTimer
            countDownTimer?.cancel()

            selections1 = 1
            selections2 = 1
            selections3 = 1
            selections4 = 1
            selections5 = 1

            // Enable all buttons
            for (button in button1) {
                button.isEnabled = true
                button.setBackgroundColor(Color.parseColor("#E91E63")) // Reset button color
            }

            for (button in button2) {
                button.isEnabled = true
                button.setBackgroundColor(Color.parseColor("#E91E63")) // Reset button color
            }

            for (button in button3) {
                button.isEnabled = true
                button.setBackgroundColor(Color.parseColor("#E91E63")) // Reset button color
            }

            for (button in button4) {
                button.isEnabled = true
                button.setBackgroundColor(Color.parseColor("#E91E63")) // Reset button color
            }

            for (button in button5) {
                button.isEnabled = true
                button.setBackgroundColor(Color.parseColor("#E91E63")) // Reset button color
            }
            val randomIndex = (0 until TotalValuLetters.size).random()

            // Get the randomly selected letter
            val randomNumber = TotalValuLetters[randomIndex]

            // Set the text of displayNumTextView to the randomly selected letter
            displayNumTextView.text = randomNumber.toString()

            // Shuffle the Button_numbers array
            Button_numbers1.shuffle()
            Button_numbers2.shuffle()
            Button_numbers3.shuffle()
            Button_numbers4.shuffle()
            Button_numbers5.shuffle()


            // Assign shuffled letters to buttons
            for ((index, button) in button1.withIndex()) {
                button.text = Button_numbers1[index].toString()
            }

            for ((index, button) in button2.withIndex()) {
                button.text = Button_numbers2[index].toString()
            }
            for ((index, button) in button3.withIndex()) {
                button.text = Button_numbers3[index].toString()
            }
            for ((index, button) in button4.withIndex()) {
                button.text = Button_numbers4[index].toString()
            }
            for ((index, button) in button5.withIndex()) {
                button.text = Button_numbers5[index].toString()
            }

            // Start the countdown timer
            countDownTimer = object : CountDownTimer(21000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    // Timer is ticking down
                    timerTextView.text = "Time Remaining: ${millisUntilFinished / 1000}"
                }

                override fun onFinish() {
                    // Timer finished, automatically click submitButton
                    Toast.makeText(this@game2,"Time is over", Toast.LENGTH_SHORT).show()
                    submitButton.performClick()
                }
            }.start()
        }

        restartButton.performClick()
    }
}