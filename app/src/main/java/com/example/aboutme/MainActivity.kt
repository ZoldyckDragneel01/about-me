package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //ito ay binding using the databinding version ng set content view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //gawin yung function ng button
        //findViewById<Button>(R.id.done_button).setOnClickListener{addNickname(it)}

        //binding version
        binding.doneButton.setOnClickListener{addNickname()}

        //ibind yung button sa listener na addnickname
        //findViewById<TextView>(R.id.nickname_text).setOnClickListener{updateNickname(it)}

        //binding version
        binding.nicknameText.setOnClickListener{updateNickname()}


    }

    private fun addNickname() {

    //binding version
        binding.nicknameText.text = binding.nicknameEdit.text.toString() //iseset yung ibibgay na nickanme ng user as the text

        binding.nicknameEdit.visibility = View.GONE  //will hide the edit text hint
        binding.doneButton.visibility = View.GONE //will hide the button
        binding.nicknameText.visibility = View.VISIBLE //will show the inputted nickname

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)

    }

    private fun updateNickname(){


        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        binding.nicknameText.visibility = View.GONE

        //set focus to the edit text
        binding.nicknameEdit.requestFocus()

        //show keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)



    }
}
