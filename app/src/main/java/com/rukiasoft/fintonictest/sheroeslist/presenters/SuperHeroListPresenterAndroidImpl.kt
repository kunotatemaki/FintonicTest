package com.rukiasoft.fintonictest.sheroeslist.presenters

import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListView
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroListPresenterAndroidImpl @Inject constructor(val mView: WeakReference<SuperHeroListView>): SuperHeroListPresenter {

    @Inject
    lateinit var log: LoggerHelper





}