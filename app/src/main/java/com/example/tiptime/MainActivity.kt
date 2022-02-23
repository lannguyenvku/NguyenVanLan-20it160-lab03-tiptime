package com.example.tiptime

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
calculate_button.setOnClickListener() {
    calculateTip()
}

}

fun calculateTip() {
val stringInTextField = cost_of_service.text.toString()
val cost = stringInTextField.toDouble()
val selectedId = tip_options.checkedRadioButtonId
val tipPercentage = when (selectedId) {
    R.id.option_twenty_percent -> 0.20
    R.id.option_eighteen_percent -> 0.18
    else -> 0.15
}
var tip = tipPercentage * cost
val roundUp = round_up_switch.isChecked
if (roundUp) {
    tip = kotlin.math.ceil(tip)
}
val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
tip_result.text = formattedTip
}

}