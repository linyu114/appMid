/*
組員：
11056006 林郁軒
11056022 陳思妤
11056049 鄭希妍
 */
package im.ntub.myapplication_mid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val it = Intent(this,MainActivity2::class.java)
            startActivity(it)
        }

        val txtShowMeal = findViewById<TextView>(R.id.txtShowMeal)
        val txtShowDrink = findViewById<TextView>(R.id.txtShowDrink)
        val txtShowDessert = findViewById<TextView>(R.id.txtShowDessert)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        val food = intent.getCharSequenceExtra("food")
        val drink = intent.getCharSequenceExtra("drink")
        val dessert = intent.getCharSequenceExtra("dessert")
        val tot = intent.getCharSequenceExtra("total")
        txtShowMeal.text = food
        txtShowDrink.text = drink
        txtShowDessert.text = dessert
        txtResult.text = tot
    }
}