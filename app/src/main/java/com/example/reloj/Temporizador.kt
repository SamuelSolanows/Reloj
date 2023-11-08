package com.example.reloj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.reloj.databinding.ActivityTemporizadorBinding

class Temporizador : AppCompatActivity() {
    lateinit var binding: ActivityTemporizadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemporizadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var alert = AlertDialog.Builder(this).setView(R.layout.alerta).create()
        binding.carView.setOnClickListener {

        }


    }

    var hora = binding.npHoras.value
    var minuto = binding.npMinutos.value
    var segundo = binding.npSegundos.value
    var timer = object : CountDownTimer(999999999999999999, 1000) {

        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
            TODO("Not yet implemented")
        }
    }

    private fun CuentaRegresiva() {


    }
}