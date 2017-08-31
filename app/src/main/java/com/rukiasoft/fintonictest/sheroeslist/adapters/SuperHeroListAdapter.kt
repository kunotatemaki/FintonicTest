package com.rukiasoft.fintonictest.sheroeslist.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.rukiasoft.fintonictest.R
import com.rukiasoft.fintonictest.databinding.SuperheroItemBinding
import com.rukiasoft.fintonictest.model.SuperHero
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenter
import com.rukiasoft.fintonictest.sheroeslist.viewholders.SuperHeroListViewHolder
import com.rukiasoft.fintonictest.utils.ui.GlideBindingComponent
import javax.inject.Inject

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroListAdapter @Inject constructor(val presenter: SuperHeroListPresenter):
        RecyclerView.Adapter<SuperHeroListViewHolder>() {

    val superHeroes: MutableList<SuperHero> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SuperHeroListViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<SuperheroItemBinding>(inflater, R.layout.superhero_item, parent,
                false, GlideBindingComponent())


        return SuperHeroListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SuperHeroListViewHolder?, position: Int) {
        val superHero: SuperHero = superHeroes[position]
        holder?.bind(superHero, presenter)
    }

    override fun getItemCount(): Int {
        return superHeroes.size
    }

}