package com.rukiasoft.fintonictest.sheroeslist.presenters

import android.app.Notification
import android.view.View
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.safe
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListView
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroListPresenterAndroidImpl @Inject constructor(var mView: WeakReference<SuperHeroListView>): SuperHeroListPresenter {

    @Inject
    lateinit var log: LoggerHelper

    lateinit var myview: WeakReference<View>
    override fun setView(view: View) {
        myview = WeakReference(view)
    }

    override fun detachViewFromPresenter() {

    }
    override fun prueba() {
        myview.safe({log.d(this, "funciona")})
    }
}