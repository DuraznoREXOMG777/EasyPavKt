package com.anlh.kt.easypav.modules.guide

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.anlh.kt.easypav.BR
import com.anlh.kt.easypav.EasyPavApp
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.data.model.Guide
import com.anlh.kt.easypav.modules.guide.view.GuideAdapter
import com.anlh.kt.easypav.databinding.ActivityGuideBinding
import com.anlh.kt.easypav.modules.guide.viewModel.GuideVM
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.highflyers.commonresources.AppBaseActivity
import com.highflyers.commonresources.AppBaseItem
import java.util.*

class GuideActivity : AppBaseActivity<ActivityGuideBinding, GuideVM>() {

    private lateinit var guideBinding : ActivityGuideBinding
    private lateinit var viewModel : GuideVM

    override fun getBindingVariable(): Int {
        return BR.guideVM
    }

    override fun fullScreenConfiguration(): Boolean {
        return true
    }

    override fun getViewModel(): GuideVM {
        viewModel = ViewModelProviders.of(this).get(GuideVM::class.java)
        return viewModel
    }

    override fun onFragmentAttached() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_guide
    }

    override fun onFragmentDetached(tag: String?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        guideBinding = viewDataBinding
        setupView()
    }

    fun setupView(){
        guideBinding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        guideBinding.viewPager.adapter = GuideAdapter(items = generateDummyData() as List<Guide>)
        TabLayoutMediator(guideBinding.tabLayout, guideBinding.viewPager){ _, _ -> }.attach()
        disableTabLayout(guideBinding.tabLayout)

        guideBinding.btnContinue.setOnClickListener {
            Toast.makeText(EasyPavApp.instance?.context, "Continue", Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateDummyData(): List<AppBaseItem> {
        val data = LinkedList<AppBaseItem>()
        data.add(Guide("Texto de prueba 1", "https://dwdqz3611m4qq.cloudfront.net/wp_content/uploads/fearless-accounting-guide-795x450.png?mtime=20190724224646"))
        data.add(Guide("Texto de prueba 2", "https://dwdqz3611m4qq.cloudfront.net/wp_content/uploads/fearless-accounting-guide-795x450.png?mtime=20190724224646"))
        data.add(Guide("Texto de prueba 3", "https://dwdqz3611m4qq.cloudfront.net/wp_content/uploads/fearless-accounting-guide-795x450.png?mtime=20190724224646"))
        data.add(Guide("Texto de prueba 4", "https://dwdqz3611m4qq.cloudfront.net/wp_content/uploads/fearless-accounting-guide-795x450.png?mtime=20190724224646"))
        return data
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun disableTabLayout(tab: TabLayout) {
        val tabStrip = tab.getChildAt(0) as LinearLayout
        for (i in 0 until tabStrip.childCount)
            tabStrip.getChildAt(i).setOnTouchListener { _, _ -> true}
    }
}
