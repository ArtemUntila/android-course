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

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        view.findViewById<TextView>(R.id.toolbar_label).text = "Fragment 1"

        val toSecond = view.findViewById<Button>(R.id.to_second)
        val toMenu = view.findViewById<ImageButton>(R.id.menu_button)

        val navController = findNavController()

        toSecond.setOnClickListener {
            navController.navigate(R.id.action_fragment_1_to_fragment_2)
        }

        toMenu.setOnClickListener {
            navController.navigate(R.id.action_fragment_1_to_about)
        }
        return view
    }
}