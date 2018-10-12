package com.example.wesle.calcimc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureUI()
    }

    private fun configureUI(){
        ratingBar.rating = 0f
        txtAge.text = "Idade: ${seekBarAge.progress.toString()} anos"
        txtHeight.text = "Altura: ${seekBarHeight.progress.toString()} cm"
        txtWeight.text = "Peso:  ${seekBarWeight.progress.toString()} Kg"
        setListeners()
    }

    private fun setListeners() {
        btnCalculate.setOnClickListener {
            calculate()
        }

        seekBarAge.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                txtAge.text = "Idade: ${seekBar.progress.toString()} anos"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        seekBarHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                txtHeight.text = "Altura: ${seekBar.progress.toString()} cm"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        seekBarWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                txtWeight.text = "Peso:  ${seekBar.progress.toString()} Kg"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

    }

    private fun calculate(){
        ratingBar.rating = 0f
        var isWoman = switchGenre.isChecked
        var ageValue = seekBarAge.progress
        var activityType = radioGroup.checkedRadioButtonId

        var heightValue = seekBarHeight.progress.toDouble()
        var weightValue = seekBarWeight.progress.toDouble()

        var IMC = calculateIMC(weightValue, heightValue)

        var result = CalculationsUtils.Companion.analyse(IMC, isWoman, activityType)

        ratingBar.rating = result.getRating().toFloat()

        var selectedRadioId: Int = radioGroup.checkedRadioButtonId
        val selectedRadioButton: RadioButton = findViewById(selectedRadioId)

        var gender : String
        if(isWoman){
            gender = "Sra."
        }else{
            gender = "Sr."
        }

        txtMessage.text = "Olá ${gender} \n"+
                "Seu IMC é: " + "%.2f \n".format(IMC) +
                "Portanto seu estado é: ${result.getMessage()} \n " +
                "Seu nível de atividade Física é: ${selectedRadioButton.text}"

    }

    private fun calculateIMC(weight : Double, height : Double) :  Double{

        val heightQualify = height * height

        return weight / heightQualify * 10000
    }

}
