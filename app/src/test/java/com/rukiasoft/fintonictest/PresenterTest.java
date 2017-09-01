package com.rukiasoft.fintonictest;

import com.rukiasoft.amaristest.model.CustomLiveData;
import com.rukiasoft.amaristest.utils.logger.LoggerHelper;
import com.rukiasoft.fintonictest.model.SuperHero;
import com.rukiasoft.fintonictest.network.logic.NetworkManager;
import com.rukiasoft.fintonictest.resources.ResourcesManager;
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenterAndroidImpl;
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Roll on 1/9/17.
 */


@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    NetworkManager networkManager;

    @Mock
    CustomLiveData<List<SuperHero>> liveSuperHeroes;

    @Mock
    WeakReference<SuperHeroListView> mView;

    @Mock
    SuperHeroListView myView;

    @Mock
    LoggerHelper log;

    @Mock
    ResourcesManager resourcesManager;

    @InjectMocks
    SuperHeroListPresenterAndroidImpl presenter;

    private List<SuperHero> list = new ArrayList<>();


    @Before
    public void setUp(){
        SuperHero superHero = new SuperHero("Chicho Terremoto",
                "https://cdnb.20m.es/sites/144/2017/05/chicho-terremoto-tres-puntos-colega.png",
                "Chicho López",
                "60 cm",
                "Bragas blancas",
                "Genio de los deportes",
                "Equipo de baloncesto, Ping pon con Leoncio");
        list.add(superHero);
        configureMocks();
    }


    @Test
    public void checkOnEmptyListCallDownloadUsers(){
        list.clear();
        presenter.loadSuperHeroes();
        verify(networkManager, times(1)).getSuperHeroes(liveSuperHeroes);
    }

    @Test
    public void checkOnNonEmptyListDontCallDownload(){
        presenter.loadSuperHeroes();
        verify(networkManager, times(0)).getSuperHeroes(liveSuperHeroes);
    }



    private void configureMocks(){
        //mock users
        when(liveSuperHeroes.getLivedataValue()).thenReturn(list);
        when(mView.get()).thenReturn(myView);
        when(myView.getLiveSuperHeroes()).thenReturn(liveSuperHeroes);

        //mock network
        doNothing().when(networkManager).getSuperHeroes(liveSuperHeroes);


    }


}



