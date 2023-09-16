package com.myprojects.aquizapp


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.myprojects.aquizapp.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = HomeFragmentBinding.inflate(inflater,container,false)

        setRecyclerView()

        return binding.root


    }

    private fun setRecyclerView() {
        val quizRv: RecyclerView = binding.recyclerView
        val quizList: ArrayList<Index> = arrayListOf(
            Index(R.drawable.geography, "Geography",1),
            Index(R.drawable.animal, "Animals",2),
            Index(R.drawable.ic_launcher_background, "JAVA QUIZ",3)
        )
        val adapter = ProjectAdapter(quizList)
        quizRv.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(activity, QuizActivity::class.java)
            intent.putExtra("index",it)
            startActivity(intent)
        }

    }
}