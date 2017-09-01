package com.rukiasoft.fintonictest.sherodetails.presenters

import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.sherodetails.views.SuperHeroDetailView
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by Roll on 1/9/17.
 */
@CustomScopes.ActivityScope
class SuperHeroDetailPresenterAndroidImpl @Inject constructor(val mView: WeakReference<SuperHeroDetailView>): SuperHeroDetailPresenter {

}