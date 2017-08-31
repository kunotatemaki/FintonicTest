package com.rukiasoft.fintonictest.sheroeslist.viewholders

import android.support.v7.widget.RecyclerView
import com.rukiasoft.fintonictest.BR
import com.rukiasoft.fintonictest.databinding.SuperheroItemBinding
import com.rukiasoft.fintonictest.model.SuperHero
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenter

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroListViewHolder (val binding: SuperheroItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(superhero: SuperHero, presenter: SuperHeroListPresenter) {
        binding.setVariable(BR.superhero, superhero)
        binding.setVariable(BR.presenter, presenter)
        binding.executePendingBindings()
    }
}