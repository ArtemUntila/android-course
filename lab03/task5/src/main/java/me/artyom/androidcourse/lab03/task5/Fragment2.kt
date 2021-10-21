package me.artyom.androidcourse.lab03.task5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        view.findViewById<TextView>(R.id.toolbar_label).text = "Fragment 2"

        val toFirst = view.findViewById<Button>(R.id.to_first)
        val toThird = view.findViewById<Button>(R.id.to_third)
        val toMenu = view.findViewById<ImageButton>(R.id.menu_button)

        val navController = findNavController()

        toFirst.setOnClickListener {
            navController.navigate(R.id.action_fragment_2_to_fragment_1)
        }

        toThird.setOnClickListener {
            navController.navigate(R.id.action_fragment_2_to_fragment_3)
        }

        toMenu.setOnClickListener {
            navController.navigate(R.id.open_about)
        }

        return view
    }
}