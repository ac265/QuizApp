package com.example.kpsssnavsorular

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.graphics.Color
import android.os.CountDownTimer
import java.io.IOException
import android.util.Log
import android.widget.Button
import androidx.core.view.isVisible
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.Date
import java.io.File
import java.io.FileWriter
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider

class AllTestActivity : AppCompatActivity() {

    private val WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 1001

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_test)

        var strHeader = intent.getStringExtra("Header")
        var strHeader2 = strHeader +  " Tüm Sorular"
        var allTestFileName = "";

        allTestFileName = "kpss_all_test_" + strHeader + ".json";

        val jsonFileString = getJsonDataFromAsset(applicationContext, allTestFileName)
        /*Log.i("data", jsonFileString as String)*/

        val gson = Gson()
        val listQuestionsType = object : TypeToken<List<Questions>>() {}.type

        var Question: MutableList<Questions> = gson.fromJson(jsonFileString, listQuestionsType)
        Question.forEachIndexed { idx, Question -> Log.i("data", "> Item $idx:\n$Question") }

        questionList = Question
        getQuestions(Question, countIndex)

        val countTextViewList = findViewById<TextView>(R.id.countTextView)
        val finish_test_button_click = findViewById<Button>(R.id.finishTestButton)

        val answer_a_click = findViewById<Button>(R.id.optionOneButton)
        val answer_b_click = findViewById<Button>(R.id.optionTwoButton)
        val answer_c_click = findViewById<Button>(R.id.optionThreeButton)
        val answer_d_click = findViewById<Button>(R.id.optionFourButton)
        val answer_e_click = findViewById<Button>(R.id.optionFiveButton)

        if(answerList.count() > 0 && answerList.count() >= countIndex + 1)
        {
            if(answerList[countIndex] == "AnswerA") {
                answer_a_click.setBackgroundColor(Color.LTGRAY)
                answer_b_click.setBackgroundColor(Color.WHITE)
                answer_c_click.setBackgroundColor(Color.WHITE)
                answer_d_click.setBackgroundColor(Color.WHITE)
                answer_e_click.setBackgroundColor(Color.WHITE)
            }
            if(answerList[countIndex] == "AnswerB"){
                answer_a_click.setBackgroundColor(Color.WHITE)
                answer_b_click.setBackgroundColor(Color.LTGRAY)
                answer_c_click.setBackgroundColor(Color.WHITE)
                answer_d_click.setBackgroundColor(Color.WHITE)
                answer_e_click.setBackgroundColor(Color.WHITE)
            }

            if(answerList[countIndex] == "AnswerC"){
                answer_a_click.setBackgroundColor(Color.WHITE)
                answer_b_click.setBackgroundColor(Color.WHITE)
                answer_c_click.setBackgroundColor(Color.LTGRAY)
                answer_d_click.setBackgroundColor(Color.WHITE)
                answer_e_click.setBackgroundColor(Color.WHITE)
            }

            if(answerList[countIndex] == "AnswerD"){
                answer_a_click.setBackgroundColor(Color.WHITE)
                answer_b_click.setBackgroundColor(Color.WHITE)
                answer_c_click.setBackgroundColor(Color.WHITE)
                answer_d_click.setBackgroundColor(Color.LTGRAY)
                answer_e_click.setBackgroundColor(Color.WHITE)
            }

            if(answerList[countIndex] == "AnswerE"){
                answer_a_click.setBackgroundColor(Color.WHITE)
                answer_b_click.setBackgroundColor(Color.WHITE)
                answer_c_click.setBackgroundColor(Color.WHITE)
                answer_d_click.setBackgroundColor(Color.WHITE)
                answer_e_click.setBackgroundColor(Color.LTGRAY)
            }

            if(answerList[countIndex] == ""){
                answer_a_click.setBackgroundColor(Color.WHITE)
                answer_b_click.setBackgroundColor(Color.WHITE)
                answer_c_click.setBackgroundColor(Color.WHITE)
                answer_d_click.setBackgroundColor(Color.WHITE)
                answer_e_click.setBackgroundColor(Color.WHITE)
            }
        }

        else
        {
            answerList.add(countIndex, "")

            answer_a_click.setBackgroundColor(Color.WHITE)
            answer_b_click.setBackgroundColor(Color.WHITE)
            answer_c_click.setBackgroundColor(Color.WHITE)
            answer_d_click.setBackgroundColor(Color.WHITE)
            answer_e_click.setBackgroundColor(Color.WHITE)
        }

        val header = findViewById<TextView>(R.id.app_bar_header)
        header.text = strHeader2

        val back_icon_click = findViewById<ImageView>(R.id.back_icon)
        back_icon_click.setOnClickListener {
            val intent = Intent(this, SubTestsActivity::class.java)
            var header = strHeader
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val next_icon_click = findViewById<ImageView>(R.id.next_icon)
        next_icon_click.setOnClickListener {
            println(questionList)
            if(countIndex <= (questionList.count()-1))
            {
                countIndex++
            }
            getQuestions(questionList, countIndex)

            if(answerList.count() > 0 && answerList.count() >= countIndex + 1)
            {
                if(answerList[countIndex] == "AnswerA") {
                    answer_a_click.setBackgroundColor(Color.LTGRAY)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }
                if(answerList[countIndex] == "AnswerB"){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.LTGRAY)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }

                if(answerList[countIndex] == "AnswerC"){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.LTGRAY)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }

                if(answerList[countIndex] == "AnswerD"){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.LTGRAY)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }

                if(answerList[countIndex] == "AnswerE"){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.LTGRAY)
                }

                if(answerList[countIndex] == ""){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }
            }

            else
            {
                answerList.add(countIndex, "")

                answer_a_click.setBackgroundColor(Color.WHITE)
                answer_b_click.setBackgroundColor(Color.WHITE)
                answer_c_click.setBackgroundColor(Color.WHITE)
                answer_d_click.setBackgroundColor(Color.WHITE)
                answer_e_click.setBackgroundColor(Color.WHITE)
            }

        }

        val previous_icon_click = findViewById<ImageView>(R.id.previous_icon)
        previous_icon_click.setOnClickListener {
            println(questionList)
            if(countIndex > 0)
            {
                countIndex--
            }
            getQuestions(questionList, countIndex)

            if(answerList.count() > 0 && answerList.count() >= countIndex + 1)
            {
                if(answerList[countIndex] == "AnswerA") {
                    answer_a_click.setBackgroundColor(Color.LTGRAY)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }
                if(answerList[countIndex] == "AnswerB"){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.LTGRAY)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }

                if(answerList[countIndex] == "AnswerC"){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.LTGRAY)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }

                if(answerList[countIndex] == "AnswerD"){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.LTGRAY)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }

                if(answerList[countIndex] == "AnswerE"){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.LTGRAY)
                }

                if(answerList[countIndex] == ""){
                    answer_a_click.setBackgroundColor(Color.WHITE)
                    answer_b_click.setBackgroundColor(Color.WHITE)
                    answer_c_click.setBackgroundColor(Color.WHITE)
                    answer_d_click.setBackgroundColor(Color.WHITE)
                    answer_e_click.setBackgroundColor(Color.WHITE)
                }
            }

            else
            {
                answerList.add(countIndex, "")

                answer_a_click.setBackgroundColor(Color.WHITE)
                answer_b_click.setBackgroundColor(Color.WHITE)
                answer_c_click.setBackgroundColor(Color.WHITE)
                answer_d_click.setBackgroundColor(Color.WHITE)
                answer_e_click.setBackgroundColor(Color.WHITE)
            }
        }

        answer_a_click.setOnClickListener {
            Answer = "AnswerA"
            if(answerList.count() >= countIndex + 1)
            {
                answerList.removeAt(countIndex)
            }

            answerList.add(countIndex, Answer)

            answer_a_click.setBackgroundColor(Color.LTGRAY)
            answer_b_click.setBackgroundColor(Color.WHITE)
            answer_c_click.setBackgroundColor(Color.WHITE)
            answer_d_click.setBackgroundColor(Color.WHITE)
            answer_e_click.setBackgroundColor(Color.WHITE)

            if(answerList.count() != 0)
            {
                if(answerList[countIndex] != "")
                {
                    indexFlag++
                }
            }
        }

        answer_b_click.setOnClickListener {
            Answer = "AnswerB"
            if(answerList.count() >= countIndex + 1)
            {
                answerList.removeAt(countIndex)
            }

            answerList.add(countIndex, Answer)

            answer_a_click.setBackgroundColor(Color.WHITE)
            answer_b_click.setBackgroundColor(Color.LTGRAY)
            answer_c_click.setBackgroundColor(Color.WHITE)
            answer_d_click.setBackgroundColor(Color.WHITE)
            answer_e_click.setBackgroundColor(Color.WHITE)

            if(answerList.count() != 0)
            {
                if(answerList[countIndex] != "")
                {
                    indexFlag++
                }
            }
        }

        answer_c_click.setOnClickListener {
            Answer = "AnswerC"
            if(answerList.count() >= countIndex + 1)
            {
                answerList.removeAt(countIndex)
            }

            answerList.add(countIndex, Answer)

            answer_a_click.setBackgroundColor(Color.WHITE)
            answer_b_click.setBackgroundColor(Color.WHITE)
            answer_c_click.setBackgroundColor(Color.LTGRAY)
            answer_d_click.setBackgroundColor(Color.WHITE)
            answer_e_click.setBackgroundColor(Color.WHITE)

            if(answerList.count() != 0)
            {
                if(answerList[countIndex] != "")
                {
                    indexFlag++
                }
            }
        }

        answer_d_click.setOnClickListener {
            Answer = "AnswerD"
            if(answerList.count() >= countIndex + 1)
            {
                answerList.removeAt(countIndex)
            }

            answerList.add(countIndex, Answer)

            answer_a_click.setBackgroundColor(Color.WHITE)
            answer_b_click.setBackgroundColor(Color.WHITE)
            answer_c_click.setBackgroundColor(Color.WHITE)
            answer_d_click.setBackgroundColor(Color.LTGRAY)
            answer_e_click.setBackgroundColor(Color.WHITE)

            if(answerList.count() != 0)
            {
                if(answerList[countIndex] != "")
                {
                    indexFlag++
                }
            }
        }

        answer_e_click.setOnClickListener {
            Answer = "AnswerE"
            if(answerList.count() >= countIndex + 1)
            {
                answerList.removeAt(countIndex)
            }

            answerList.add(countIndex, Answer)

            answer_a_click.setBackgroundColor(Color.WHITE)
            answer_b_click.setBackgroundColor(Color.WHITE)
            answer_c_click.setBackgroundColor(Color.WHITE)
            answer_d_click.setBackgroundColor(Color.WHITE)
            answer_e_click.setBackgroundColor(Color.LTGRAY)

            if(answerList.count() != 0)
            {
                if(answerList[countIndex] != "")
                {
                    indexFlag++
                }
            }
        }

        val timerTextView = findViewById<TextView>(R.id.timerTextView)
        timerTextViewAccess = timerTextView.toString();

        if(switchFlag == 1)
        {
            timerIsCheck = true
            timerTextView.isVisible = true
        }

        else
        {
            timerIsCheck = false
            timerTextView.isVisible = false
        }

        if(questionList.count() == countIndex + 1)
        {
            countTextViewList.isVisible = false
        }

        finish_test_button_click.setOnClickListener {
            indexFlag = 0;
            var i: Int = 0
            var j: Int = 0
            dataModel = ArrayList<DataModel>()

            if(answerList.count() < questionList.count())
            {
                for (j in answerList.count() .. questionList.count() - 1)
                {
                    answerList.add(j, "")
                }
            }

            for (i in answerList.indices) {
                if(answerList[i] != ""){
                    if(answerList[i] == questionList[i].Result){
                        trueList.add(answerList[i]);
                        dataModel!!.add(DataModel("Soru " + (i + 1), R.drawable.true_check_icon))
                    }
                    else{
                        falseList.add(answerList[i]);
                        dataModel!!.add(DataModel("Soru " + (i + 1), R.drawable.false_check_icon))
                    }
                }
                else{
                    dataModel!!.add(DataModel("Soru " + (i + 1), R.drawable.empty_check_icon))
                }
            }

            if(falseList.count() != 0){
                netCount = trueList.count() - falseList.count() * 0.25;
            }

            else{
                netCount = trueList.count().toDouble()
            }

            emptyCount = questionList.count() - trueList.count() - falseList.count();

            timerTextViewAccess = timerTextView.text.toString()

            //Write Results to JSON File
            val Results = Results(1, questionList.count(), trueList.count(), falseList.count(), emptyCount, netCount, timerTextViewAccess)

            val gson = Gson()
            val json = gson.toJson(Results)
            val fileName = "kpss_general_ability_2020_result.json"
            val file = File(filesDir, fileName)

            try {
                if (!file.exists()) {
                    file.createNewFile()
                }

                val writer = FileWriter(file)
                writer.write(json)
                writer.close()
                println("JSON data has been written to ${file.absolutePath}.")
            } catch (e: IOException) {
                e.printStackTrace()
                println("Error writing JSON data to file.")
            }

            val intent = Intent(this, ResultActivity::class.java)
            var header = strHeader
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        // time count down for 108000 seconds,
        // with 1 second as countUp interval
        object : CountDownTimer(10800000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                timerTextView.setText(formatMilliseconds(10800000-millisUntilFinished))
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                timerTextView.setText("done!")
            }
        }.start()
    }

    fun getQuestions(Question: List<Questions> , index : Int) {

        val countTextViewList = findViewById<TextView>(R.id.countTextView)
        countTextViewList.text = (index+1).toString() + "/" + (Question.count()).toString()

        if(index == 0)
        {
            val previous_icon_click = findViewById<ImageView>(R.id.previous_icon)
            previous_icon_click.isVisible = false
        }

        else
        {
            val previous_icon_click = findViewById<ImageView>(R.id.previous_icon)
            previous_icon_click.isVisible = true
        }

        if(index == Question.count()-1)
        {
            val next_icon_click = findViewById<ImageView>(R.id.next_icon)
            next_icon_click.isVisible = false
        }

        else
        {
            val next_icon_click = findViewById<ImageView>(R.id.next_icon)
            next_icon_click.isVisible = true
        }

        if(index >= 0 && index < Question.count()) {
            val questionOnePartList = findViewById<TextView>(R.id.questionTextViewOne)
            questionOnePartList.text =
                (index + 1).toString() + ".SORU\n" + Question[index].Question_One_Part.toString();

            val questionTwoPartList = findViewById<TextView>(R.id.questionTextViewTwo)
            questionTwoPartList.text = Question[index].Question_Two_Part.toString();

            val optionOneButtonList = findViewById<TextView>(R.id.optionOneButton)
            optionOneButtonList.text = Question[index].AnswerA.toString();

            val optionTwoButtonList = findViewById<TextView>(R.id.optionTwoButton)
            optionTwoButtonList.text = Question[index].AnswerB.toString();

            val optionThreeButtonList = findViewById<TextView>(R.id.optionThreeButton)
            optionThreeButtonList.text = Question[index].AnswerC.toString();

            val optionFourButtonList = findViewById<TextView>(R.id.optionFourButton)
            optionFourButtonList.text = Question[index].AnswerD.toString();

            val optionFiveButtonList = findViewById<TextView>(R.id.optionFiveButton)
            optionFiveButtonList.text = Question[index].AnswerE.toString();
        }
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun formatMilliseconds(milliseconds: Long): String {
        val format = SimpleDateFormat("mm:ss")
        return format.format(Date(milliseconds))
    }

    // Call this function when you need to request the permission
    private fun requestExternalStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE
            )
        } else {
            // Permission is already granted
            // You can proceed with writing to external storage
        }
    }

    // Handle the permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can proceed with writing to external storage
            } else {
                // Permission denied, handle accordingly (e.g., show a message)
            }
        }
    }

    fun shareFile(context: Context, file: File) {
        val uri = FileProvider.getUriForFile(
            context,
            "your.package.name.fileprovider",
            file
        )

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "application/json"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        context.startActivity(Intent.createChooser(intent, "Share JSON File"))
    }
}