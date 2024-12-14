package com.example.practicatabmenu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Controlador (fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> PrincipalFragment()
            1 -> GaleriaFragment()
            2 -> FormularioFragment()
            else -> throw IllegalArgumentException("Posición inválida.")
        }
    }
}