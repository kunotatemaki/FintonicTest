package com.rukiasoft.fintonictest.dependencyinjection.modules

import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserver
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserverAndroidImpl
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenter
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenterAndroidImpl
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListView
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference

/**
 * Created by Roll on 31/8/17.
 */
@Module
@CustomScopes.ActivityScope
class SuperHeroListModule(private var mView: SuperHeroListView) {

    @Provides
    fun providesSuperHeroListPresenter(presenterAndroidImpl: SuperHeroListPresenterAndroidImpl) : SuperHeroListPresenter{
        return presenterAndroidImpl
    }

    @Provides
    fun providesSuperHeroListView(): WeakReference<SuperHeroListView>{
        return WeakReference(mView)
    }


    @Provides
    fun providesSuperHeroListLifecycleObserver(observer: SuperHeroListLifecycleObserverAndroidImpl): SuperHeroListLifecycleObserver{
        return observer
    }

}