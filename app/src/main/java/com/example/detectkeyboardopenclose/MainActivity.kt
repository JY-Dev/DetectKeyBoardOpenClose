package com.example.detectkeyboardopenclose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.detectkeyboardopenclose.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.observeSoftKeyBoardHideAndShow({
            Toast.makeText(this,"열림",Toast.LENGTH_SHORT).show()
        },{
            Toast.makeText(this,"닫힘",Toast.LENGTH_SHORT).show()
        })
    }
}