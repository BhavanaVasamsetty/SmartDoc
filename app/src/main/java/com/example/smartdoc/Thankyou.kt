package com.example.smartdoc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_thankyou.*

class Thankyou : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyou)

        ThankYou.alpha = 0f

        ThankYou.animate().setDuration(1500).alpha(1f).withEndAction {
            val t = Intent(this, MainActivity::class.java)
            startActivity(t)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }


}
}