package com.anlh.kt.easypav.modules.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.anlh.kt.easypav.EasyPavApp
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.core.AppUtil
import com.anlh.kt.easypav.modules.guide.GuideActivity
import com.anlh.kt.easypav.modules.signIn.SignInActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash)

        Timer().schedule(1500){
            startActivity(Intent(this@SplashActivity, GuideActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
                //if(AppUtil.appPreferencesHelper.getFirstOpen()) GuideActivity::class.java else SignInActivity::class.java))
            super.finish()
        }
    }
}
