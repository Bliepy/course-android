package com.bliepy.level_7_task_2

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.bliepy.level_7_task_2.model.QuestionModel

class LocationFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var model: QuestionModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.location_fragment, container, false)
        viewModel = activity.let { ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)}

        model = viewModel.questions.value!![0]

        val image: ImageView = view.findViewById(R.id.locationImage)
        val button: Button = view.findViewById(R.id.locationButton)
        image.setImageDrawable(getDrawable(this.requireContext(), model.clue))

        return view
    }
}

