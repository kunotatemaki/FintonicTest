package com.rukiasoft.fintonictest.utils.ui

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Roll on 31/8/17.
 */
class GlideBindingAdapters {

    @BindingAdapter("app:image")
    fun setImageUrl(view: ImageView, url: String?) {
        //circle images
        url?.let {
            Glide.with(view.context)
                    .load(url)
                    .apply(RequestOptions()
                            .circleCrop())
                    .into(view)
        }
    }
}