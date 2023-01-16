package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.databinding.FragmentWelcomeBinding
import edu.miu.quizapp.db.Quiz
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager
import kotlinx.coroutines.launch


class WelcomeFragment : BaseFragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefManager = PrefManager(context)
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.start.setOnClickListener {
            if (!prefManager?.isFirstTimeLaunch()!!) {
                Navigation.findNavController(requireView()).navigate(R.id.action_welcomeFragment_to_homeFragment)
            }else{
                Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_welcomeFragment)
            }
        }
        addQuizQuestionsToDB()
        return binding.root
    }

    override fun onResume(){
        super.onResume()
    }

    private fun addQuizQuestionsToDB(){
        val quiz1 = Quiz(1L,"1) Kotlin is developed by? ","A. Google", "B. JetBrains","C. a web server","D. None of the above","b","Answer: (b) JetBrains \n" +
                "\n" +
                " Kotlin is developed by JetBrains.")
        val quiz2 = Quiz(2L,"2) Which file extension is used to save Kotlin files?", "A.  .java","B. .kot","C. .kt or .kts","D. .andriod ","c","Answer: (c) .kt or .kts \n" +
                "\n" +
                "Explanation: .kt or .kts extension is used to save Kotlin files.")
        val quiz3 = Quiz(3L,"3) Which of following is used to handle null exceptions in Kotlin?","A. Range", "B. Sealed Class","C. Elvis Operator","D. Lambda function","c","Answer: (c) Elvis Operator\n" +
                "\n" +
                "Explanation: Elvis Operator is used to handle null exceptions in Kotlin.")
        val quiz4 = Quiz(4L,"4) Which of following targets currently not supported by Kotlin?","A. LLVM", "B. .NET CLR","C. Javascript","D. None of the above","b","Answer: (b) .NET CLR \n" +
                "\n" +
                "Explanation: .NET CLR is not supported by Kotlin.")
        val quiz5 = Quiz(5L,"5) Which of the following’s constructors are available in Kotlin? ","A. Primary constructor", "B. Secondary constructor","C. Both 1 & 2 ","D. None of the above","c","Answer: (c) Both 1 & 2 \n" +
                "\n" +
                "Explanation: A Kotlin class can have a primary constructor and one or more additional secondary constructors. The Kotlin primary constructor initializes the class, whereas the secondary constructor helps to include some extra logic while initializing the class.")
        val quiz6 = Quiz(6L,"6) You can create an emulator to simulate the configuration of a particular type of Android device using a tool like ___.","A. Theme Editor", "B. Android SDK Manager","C. AVD Manager","D. None of the above","c","Answer: (c) AVD Manager \n" +
                "\n" +
                "Explanation: Can use the AVD manager to create a virtual device (an emulator) which simulates the configuration for a particular type of Android device and run the app.")
        val quiz7 = Quiz(7L,"7) What parameter specifies the Android API level that Gradle should use to compile your app?","A minSdkVersion ", "B. compileSdkVersion","C. targetSdkVersion","D. None of the above","b","Answer: (b) compileSdkVersion \n" +
                "\n" +
                "Explanation: The parameter, compileSdkVersion, specifies the Android API level that Gradle should use to compile your app. This is the newest version of Android  app can support and can use the API features included in this API level and lower.")
        val quiz8 = Quiz(8L,"8) Which of the following converts Java byte code into Dalvik byte code?","A. Dalvik converter", "B. Dex compiler","C. Mobile interpretive compiler (MIC)","D. None of the above","b","Answer: (b) Dex compiler\n" +
                "\n" +
                "Explanation: The Dex compiler converts the class files into a .dex file that runs on the Dalvik VM. Multiple class files are converted into one dex file.")
        val quiz9 = Quiz(9L,"9) Which Kotlin visibility modification makes a function visible from anywhere?","A. protected", "B. public","C. private","D. internal","b","Answer: (b) public\n" +
                "\n" +
                "Explanation: The visibility of Kotlin Four Modifiers is set to public by default, which means it may be seen from anywhere. There are four levels of visibility: public, private, protected, and internal.")

        val quiz10 = Quiz(10L,"10) The keyword ______ is used to reassign variables in Kotlin.","A. write", "B. var","C. val","D. None of the above","b","Answer: (b) var\n" +
                "\n" +
                "Explanation: The keyword var is used to reassign variables in Kotlin.")
        val quiz11 = Quiz(11L,"11) What is an activity in android?","A. android class", "B. android package","C. A single screen in an application with supporting java code","D. None of the above","c","Answer: (c) A single screen in an application with supporting java code\n" +
                "\n" +
                "Explanation: An activity is a single screen in android. It is like a window or frame of Java. By the help of activity, you can place all your UI components or widgets in a single screen. Activity is like a frame or window in java that represents GUI. It represents one screen of android.")
        val quiz12 = Quiz(12L,"12) A Kotlin application's entry point is the","A. system function", "B. main function","C. user function","access function","b","Answer: (b)  main function\n" +
                "\n" +
                "Explanation: Both procedural and object-oriented programming are supported in Kotlin. If you've worked with procedural languages before, you're probably aware that main () is the program's entry point. In the same way, the main () function (or method) in a Kotlin file represents the starting point for a Kotlin program.")
        val quiz13 = Quiz(13L,"13) Which keyword is used to declare a function?","A. function", "B. decl","C. fun","D. None of the above","c","Answer: (c) fun\n" +
                "\n" +
                "Explanation: A function definition starts with the fun keyword, followed by the name of the function, a set of opening and closing parentheses, and a set of opening and closing curly braces. Contained in curly braces is the code that will run when the function is called.")
        val quiz14 = Quiz(14L,"14) On which of the following, developers can test the application, during developing the android applications?",
            "A. Third-party emulators", "B. Emulator included in Android SDK","C. Physical android phone","D. All of the above","d","Answer: (d) All of the above\n" +
                    "\n" +
                    "Explanation: We can use the Android emulator, physical android phone, or third-party emulator as a target device to execute and test our Android application.")
        val quiz15 = Quiz(15L,"15) To keep the UI running smoothly, use ___ for long-running tasks, such as all database operations.","A. coroutines", "B. ViewModels","C. returns","D. managed threads","a","Answer: (a) coroutines \n" +
                "\n" +
                "Explanation: Coroutines are asynchronous and non-blocking. They use suspend functions to make asynchronous code sequential.")

        launch {
            context?.let {
                QuizDatabase(it)
                    .getQuizDao().deleteAllQuiz()
                QuizDatabase(it)
                    .getQuizDao().addQuizzes(quiz1,quiz2,quiz3,quiz4,quiz5,quiz6,quiz7,quiz8,
                        quiz9,quiz10,quiz11,quiz12,quiz13,quiz14,quiz15)
            }
        }
    }

}