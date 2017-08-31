package com.rukiasoft.fintonictest.utils.ui

import android.databinding.DataBindingComponent

/**
 * Created by Roll on 31/8/17.
 */
class GlideBindingComponent : DataBindingComponent {
    override fun getGlideBindingAdapters(): GlideBindingAdapters {
        return GlideBindingAdapters()
    }
}