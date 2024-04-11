package im.ntub.myapplication_mid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnHawaiian = findViewById<RadioButton>(R.id.ButtonHawaiian)
        val btnAmerican = findViewById<RadioButton>(R.id.ButtonAmerican)
        val btnTakoyaki = findViewById<RadioButton>(R.id.ButtonTakoyaki)
        val btnBlacktea = findViewById<RadioButton>(R.id.ButtonBlacktea)
        val btnCoke = findViewById<RadioButton>(R.id.ButtonCoke)
        val chbDessert1 = findViewById<CheckBox>(R.id.ChbDessert1)
        val chbDessert2 = findViewById<CheckBox>(R.id.ChbDessert2)
        val btnSure = findViewById<Button>(R.id.btnSure)
        val txtPizzaSum = findViewById<TextView>(R.id.editMeal)
        val txtDrinkSum = findViewById<TextView>(R.id.editDrink)
        val txtDessert1Sum = findViewById<TextView>(R.id.editDessert1)
        val txtDessert2Sum = findViewById<TextView>(R.id.editDessert2)
        val txtResult = findViewById<TextView>(R.id.TxtResult)

        btnSure.setOnClickListener {
            //主食
            var food = ""
            if (btnAmerican.isChecked){
                food = "美式臘腸"
            }
            if(btnHawaiian.isChecked){
                food = "夏威夷"
            }
            if(btnTakoyaki.isChecked){
                food = "和風章魚燒"
            }

            //飲料
            var drink = ""
            if (btnCoke.isChecked){
                drink = "可樂"
            }
            if(btnBlacktea.isChecked){
                drink = "紅茶"
            }

            //點心
            var dessert=""
            if(chbDessert1.isChecked){
                dessert="雞塊"
                if(chbDessert2.isChecked){
                    dessert="雞塊&薯條"
                }
            }
            else if (chbDessert2.isChecked){
                dessert="薯條"
            }
            //總金額
            var total = 0
            val pizzatotal = txtPizzaSum.text.toString().toInt()
            val drinktotal = txtDrinkSum.text.toString().toInt()
            val dessert1total = txtDessert1Sum.text.toString().toInt()
            val dessert2total = txtDessert2Sum.text.toString().toInt()

            if (btnAmerican.isChecked) {
                total = pizzatotal * 80
            } else if (btnHawaiian.isChecked) {
                total = pizzatotal * 90
            } else if (btnTakoyaki.isChecked) {
                total = pizzatotal * 100
            } else {
                total = 0
            }
            if (btnBlacktea.isChecked) {
                total = total + drinktotal * 15
            } else if (btnCoke.isChecked) {
                total = total + drinktotal * 20
            }
            if (chbDessert1.isChecked) {
                total = total + dessert1total * 40
            }
            if (chbDessert2.isChecked) {
                total = total + dessert2total * 30
            }
            val tot = total.toString()
            txtResult.text = tot


            AlertDialog.Builder(this)
                .setTitle("確認訂單")
                .setMessage("是否下訂")
                .setPositiveButton("是") { dialog, i ->
                    val it = Intent(this, MainActivity::class.java)
                    it.putExtra("food",food)
                    it.putExtra("drink",drink)
                    it.putExtra("dessert",dessert)
                    it.putExtra("total", tot)
                    startActivity(it)
                }
                .setNegativeButton("否") { dialog, i ->
                }
                .show()
        }
    }
}