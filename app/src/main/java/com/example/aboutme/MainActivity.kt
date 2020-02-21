package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //gawin yung function ng button
        //ibind yung button sa listener na addnickname

        findViewById<Button>(R.id.done_button).setOnClickListener{addNickname(it)}
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{updateNickname(it)}

    }

    private fun addNickname(view: View) {
        val editText: EditText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView: TextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text //iseset yung ibibgay na nickanme ng user as the text

        editText.visibility = View.GONE  //will hide the edit text hint
        view.visibility = View.GONE //will hide the button
        nicknameTextView.visibility = View.VISIBLE //will show the inputted nickname

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)


        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        //set focus to the edit text
        editText.requestFocus()

        //show keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)



    }
}
