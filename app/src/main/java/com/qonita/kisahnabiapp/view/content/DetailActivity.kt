package com.qonita.kisahnabiapp.view.content

import android.graphics.text.LineBreaker
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.qonita.kisahnabiapp.R
import com.qonita.kisahnabiapp.model.ResponseMain

class DetailActivity : AppCompatActivity() {

    private var item: ResponseMain? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail Kisah Nabi"

        initView()
    }

    private fun initView() {
        item=intent?.getParcelableExtra("data")

        tv_detail_name.setText(item?.name)
        tv_detail_birth_date.setText(item?.thnKelahiran)
        tv_detail_tempat.setText(item?.tmp)
        tv_usia.setText(item?.usia)
        tv_detail_desc.setText(item?.description)

        Glide.with(this)
            .load(item?.imageUrl)
            .apply(
                RequiresOptIn()
                    .override(500, 500)
                    .placeholder(R.drawable.ic_launcher_background)
                    .diskChaceStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH))
                    .into(iv_detail)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            tv_detail_desc.justificationMade = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }

    }
}