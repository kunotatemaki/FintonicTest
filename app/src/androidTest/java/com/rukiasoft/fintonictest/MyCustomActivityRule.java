package com.rukiasoft.fintonictest;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.rukiasoft.fintonictest.model.SuperHero;
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roll on 1/9/17.
 */

public class MyCustomActivityRule<A extends SuperHeroListActivity> extends ActivityTestRule<A> {
    public MyCustomActivityRule(Class<A> activityClass) {
        super(activityClass);
    }

    @Override
    protected void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        // Maybe prepare some mock service calls
        // Maybe override some depency injection modules with mocks

    }

    @Override
    protected Intent getActivityIntent() {
        Intent customIntent = new Intent();
        // add some custom extras and stuff
        return customIntent;
    }


    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();
        final List<SuperHero> list = new ArrayList<>();
        SuperHero superHero = new SuperHero("Chicho Terremoto", "https://cdnb.20m.es/sites/144/2017/05/chicho-terremoto-tres-puntos-colega.png"
                ,"Chicho López", "60 cm", "Bragas blancas", "Genio de los deportes", "Equipo de baloncesto, Ping pon con Leoncio");
        list.add(superHero);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getActivity().setSuperHeroesList(list);
            }
        });

        // maybe you want to do something here
    }

    @Override
    protected void afterActivityFinished() {
        super.afterActivityFinished();
        // Clean up mocks
    }
}
