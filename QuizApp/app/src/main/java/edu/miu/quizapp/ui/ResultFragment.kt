package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.databinding.FragmentResultBinding

class ResultFragment : BaseFragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentResultBinding.inflate(inflater, container, false)
        //tvScore = view.findViewById(R.id.tv_score)
        val score = ResultFragmentArgs.fromBundle(requireArguments()).score
        val answers = ResultFragmentArgs.fromBundle(requireArguments()).answers
        val wrongAnswers = 15 - score
        val finalScore = "$score/15"
        val scoreResult = String.format(
            "Total Questions: 15\n\nCorrect Answers(Score): %d\n\nWrong Answer: %d\n\nYour Score is: %s",
            score, wrongAnswers, finalScore
        )

        binding.tvScore.text = scoreResult

        binding.btnTryAgain.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_resultFragment_to_homeFragment)
        }

        binding.btnResultAnalysis.setOnClickListener {
            val action = ResultFragmentDirections.actionResultFragmentToAnswerFragment(answers)
            Navigation.findNavController(requireView()).navigate(action)
        }

        return  binding.root
    }


}