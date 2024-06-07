package com.palomino.luis.pokemon

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.palomino.luis.pokemon.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding

    private lateinit var registerViewModel: RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerViewModel = RegisterViewModel(this)
        observerValues()

    }


    private fun observerValues() {
        registerViewModel.emailError.observe(this) {
            Toast.makeText(this, "El correo es invalido, ingresar nuevamente", Toast.LENGTH_SHORT).show()
        }


        registerViewModel.passwordError.observe(this) {
            Toast.makeText(this, "la contraseña es invalida, ingresar nuevamente", Toast.LENGTH_SHORT).show()
        }


        registerViewModel.registerSuccess.observe(this) {
            Toast.makeText(this, "Se registro correctamente la cuenta ingresada", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


        binding.btnRegister.setOnClickListener {
            registerViewModel.registerInputs(
                email = binding.edtEmail.text.toString(),
                password = binding.edtPassword.text.toString(),
                password2 = binding.edtPassword2.text.toString()
            )
        }


        binding.btnBackClose.setOnClickListener {
            finish()
        }
    }
}