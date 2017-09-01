package com.rukiasoft.fintonictest.dependencyinjection.modules

import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.sherodetails.lifecycleobservers.SuperHeroDetailLifecycleObserver
import com.rukiasoft.fintonictest.sherodetails.lifecycleobservers.SuperHeroDetailLifecycleObserverAndroidImpl
import com.rukiasoft.fintonictest.sherodetails.presenters.SuperHeroDetailPresenter
import com.rukiasoft.fintonictest.sherodetails.presenters.SuperHeroDetailPresenterAndroidImpl
import com.rukiasoft.fintonictest.sherodetails.views.SuperHeroDetailView
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference

/**
 * Created by Roll on 31/8/17.
 */
@Module
@CustomScopes.ActivityScope
class SuperHeroDetailModule(private var mView: SuperHeroDetailView) {

    @Provides
    fun providesSuperHeroDetailPresenter(presenterAndroidImpl: SuperHeroDetailPresenterAndroidImpl) : SuperHeroDetailPresenter {
        return presenterAndroidImpl
    }

    @Provides
    fun providesSuperHeroDetailView(): WeakReference<SuperHeroDetailView> {
        return WeakReference(mView)
    }


    @Provides
    fun providesSuperHeroDetailLifecycleObserver(observer: SuperHeroDetailLifecycleObserverAndroidImpl): SuperHeroDetailLifecycleObserver {
        return observer
    }

}