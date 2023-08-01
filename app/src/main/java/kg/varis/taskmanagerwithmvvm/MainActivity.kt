package kg.varis.taskmanagerwithmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.varis.taskmanagerwithmvvm.databinding.ActivityMainBinding
import kg.varis.taskmanagerwithmvvm.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }
}