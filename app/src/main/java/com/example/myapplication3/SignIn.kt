package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.myapplication3.Connection.token
import com.example.myapplication3.databinding.ActivitySignInBinding
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

private lateinit var binding: ActivitySignInBinding
class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
        binding.button2.setOnClickListener {
            val Inmail = binding.editMail.text.toString()
            if (Inmail.isBlank()){
                error(this,"Error","empty mail")
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(Inmail).matches()){
                error(this,"Error","wrong mail")
                return@setOnClickListener
            }
            val InPass = binding.editPass.text.toString()
            if (InPass.isBlank()){
                error(this,"Error","empty password")
            }
            Connection.api.postIn(LogB(Inmail,InPass)).enqueue(object :retrofit2.Callback<UserData>{
                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    if (response.isSuccessful){
                        token = response.body()!!.token
                        error(this@SignIn,"Error",response.body()!!.token)
                        startActivity(Intent(this@SignIn,MainActivity::class.java))

                    }
                }

                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    error(this@SignIn,"Error",t.localizedMessage?:t.message?:"Unknown Error")
                }

            })
        }
    }
}