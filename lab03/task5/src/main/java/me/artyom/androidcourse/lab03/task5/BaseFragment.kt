package me.artyom.androidcourse.lab03.task5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment(private val layoutId: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutId, container, false)
        val navController = findNavController()

        // If view doesn't contain specified Button (View), this expression will be skipped
        // In fact it returns "null", and we skip return value (thanks, Kotlin null-safety)
        view.findViewById<Button>(R.id.bnToFirst)?.setOnClickListener {
            navController.navigate(R.id.action_to_1)
        }

        view.findViewById<Button>(R.id.bnToSecond)?.setOnClickListener {
            navController.navigate(R.id.action_to_2)
        }

        view.findViewById<Button>(R.id.bnToThird)?.setOnClickListener {
            navController.navigate(R.id.action_to_3)
        }

        return view
    }
}