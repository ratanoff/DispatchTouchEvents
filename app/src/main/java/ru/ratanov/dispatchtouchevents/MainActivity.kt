package ru.ratanov.dispatchtouchevents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ratanov.dispatchtouchevents.view.OuterView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(OuterView(this))
    }
}
