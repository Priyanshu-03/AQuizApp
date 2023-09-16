package com.myprojects.aquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.myprojects.aquizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private lateinit var quiz: ArrayList<QuizData>
    private var currentPos = 0
    private var attempt = "0 / 10"
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val index = intent.getParcelableExtra<Index>("index")

        val id = index!!.quizID
        val imgId = index.img

        getQuizQuestions(id)
        setImage(imgId)
        setQuizQuestions()
        optionsClicked()


    }

    private fun setImage(id : Int) {
        val image : ImageView = binding.titleImg
        image.setImageResource(id)
    }

    private fun optionsClicked() {
        binding.buttonOpt1.setOnClickListener {
            if(quiz[currentPos].opt1 == quiz[currentPos].ans){
                Toast.makeText(this, "Correct Ans", Toast.LENGTH_SHORT).show()
                score++
            }
            currentPos++
            attempt = "$currentPos / 10"
            setQuizQuestions()
        }
        binding.buttonOpt2.setOnClickListener {
            if(quiz[currentPos].opt2 == quiz[currentPos].ans){
                Toast.makeText(this, "Correct Ans", Toast.LENGTH_SHORT).show()
                score++
            }
            currentPos++
            attempt = "$currentPos / 10"
            setQuizQuestions()
        }
        binding.buttonOpt3.setOnClickListener {
            if(quiz[currentPos].opt3 == quiz[currentPos].ans){
                Toast.makeText(this, "Correct Ans", Toast.LENGTH_SHORT).show()
                score++
            }
            currentPos++
            attempt = "$currentPos / 10"
            setQuizQuestions()
        }
        binding.buttonOpt4.setOnClickListener {
            if(quiz[currentPos].opt4 == quiz[currentPos].ans){
                Toast.makeText(this, "Correct Ans", Toast.LENGTH_SHORT).show()
                score++
            }
            currentPos++
            attempt = "$currentPos / 10"
            setQuizQuestions()
        }
    }

    private fun setQuizQuestions() {

        if(currentPos < 10){
            binding.progressBar.progress = currentPos + 1
            binding.questionAttempted.text = attempt

            binding.textQuestion.text = quiz[currentPos].ques
            binding.buttonOpt1.text = quiz[currentPos].opt1
            binding.buttonOpt2.text = quiz[currentPos].opt2
            binding.buttonOpt3.text = quiz[currentPos].opt3
            binding.buttonOpt4.text = quiz[currentPos].opt4
        }
        else{
            val intent = Intent(this, FinalResultActivity::class.java)
            intent.putExtra("score",score)
            startActivity(intent)
        }


    }

    private fun getQuizQuestions(id : Int) {

        when(id){

            1 -> quiz = arrayListOf(
                QuizData("JAVA is platform independent or not","Yes","No","both","NOne","Yes"),
                QuizData("The Highest mountain of the world is in which two countries?", "India and Pakistan","China and Tibet","Tibet and Nepal","Pakistan and Nepal","Tibet and Nepal"),
                QuizData("The lowest point of land on earth is on the border between which two countries?", "Mexico and the U.S.","Holland and Belgium","Israel and Jordan","Denmark and Germany","Israel and Jordan"),
                QuizData("Where is the biggest desert on earth", "Siberia","Africa","Antarctica","California","Antarctica"),
                QuizData("Which capital city in the world is at the highest altitude?","Bern, Switzerland", "Kathmandu, Nepal","La Paz, Bolivia","Ulaanbaatar, Mongolia","La Paz, Bolivia"),
                QuizData("Which continent has the fewest people living on it?","Africa","Asia","Australia","Antarctica","Antarctica"),
                QuizData("What is a continent", "a large body of water surrounded by land","a large area of land surrounded by oceans","a small area of land","a land area with mountains","a large area of land surrounded by oceans"),
                QuizData("Which continent has the most people living on it?","Africa","Asia","Australia","Antarctica","Asia"),
                QuizData("Which continent has the most countries?","Africa","Asia","Australia","Europe","Africa"),
                QuizData("Which continent has the worlds highest mountain?", "Africa", "Asia","Australia","Antarctica","Asia")
            )

            2 -> quiz = arrayListOf(
                QuizData("What is the deadliest animal in the world?","Dogs","Snakes","Crocodiles","Lion","Snakes"),
                QuizData("The biggest predator (prey) in the animal kingdom","Grizzly Bear","Lion","Killer Whale","Crocodile","Lion"),
                QuizData("The slowest Animals In The World is","Koala","Three-toed sloth","Garden Snail","Giant Tortoise","Three-toed sloth"),
                QuizData("What is the largest dogs in the world?","Shepherd","Retriever","Bulldog","Mastiffs","Mastiffs"),
                QuizData("Which animal has the Strongest Bite in the Animal Kingdom?","Crocodile","Spotted Hyena","Megalodon Shark","Jaguar","Megalodon Shark"),
                QuizData("The horn of the rhinoceros is made of","Bone","Flesh","Liquid","Hair","Hair"),
                QuizData("What percentage of DNA a chimpanzee shares with human?","98%","12%","0%","50%","98%"),
                QuizData("Which one can taste with their feet?","Elephants","Butterflies","Snails","Birds","Butterflies"),
                QuizData("By some estimates, eagles can see at least what times as much detail as humans?","8 times","10 times","4 times","5 times","4 times"),
                QuizData("The smallest bird and the smallest warm-blooded vertebrate is?","Pygmy Marmoset","Speckled Pad looper Tortoise","Etruscan shrew","Bee Hummingbird","Bee Hummingbird")
            )

            3 -> Toast.makeText(this, "No Data found",Toast.LENGTH_SHORT).show()

        }

    }
}