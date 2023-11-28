package com.example.kpsssnavsorular

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.widget.AdapterView

class ResultFragment : Fragment() {

    // Declaring the DataModel Array
    // Declaring the elements from the main layout file
    private lateinit var adapter: ListViewDataAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val questionNumberTextView = view.findViewById<TextView>(R.id.questionNumberTextView)
        questionNumberTextView.text = "Soru Sayısı: " + questionList.count().toString();
        val TrueQuestionTextView = view.findViewById<TextView>(R.id.TrueQuestionTextView)
        TrueQuestionTextView.text = "Doğru: " + trueList.count().toString();
        val FalseQuestionTextView = view.findViewById<TextView>(R.id.FalseQuestionTextView)
        FalseQuestionTextView.text = "Yanlış: " + falseList.count().toString();
        val EmptyQuestionTextView = view.findViewById<TextView>(R.id.EmptyQuestionTextView)
        EmptyQuestionTextView.text = "Boş: " + emptyCount.toString();
        val NetQuestionTextView = view.findViewById<TextView>(R.id.NetQuestionTextView)
        NetQuestionTextView.text = "Net: " + netCount.toString();
        val PassingTimeTextView = view.findViewById<TextView>(R.id.PassingTimeTextView)
        PassingTimeTextView.text = "Geçen Süre: " + timerTextViewAccess;

        answerList.clear();
        questionList.clear()
        trueList.clear();
        falseList.clear();
        emptyCount = 0
        netCount = 0.0
        timerTextViewAccess = ""

        val RestartTestButton = view.findViewById<Button>(R.id.RestartTestButton)
        answerList.clear();
        questionList.clear()
        trueList.clear();
        falseList.clear();
        emptyCount = 0
        netCount = 0.0
        timerTextViewAccess = ""
        RestartTestButton.setOnClickListener {
            val intent = Intent(activity, AllTestActivity::class.java)
            startActivity(intent)
        }

        val ReviewResultsTestButton = view.findViewById<Button>(R.id.ReviewResultsTestButton)
        ReviewResultsTestButton.setOnClickListener {

            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.result_bottom_sheet_dialog, null)

            val listView = view.findViewById<ListView>(R.id.bottomSheetListView)

            // Setting the adapter
            adapter = ListViewDataAdapter(dataModel!!, requireContext())
            listView?.adapter = adapter

            // Upon item click, checkbox will be set to checked
            listView?.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                val dataModel: DataModel = dataModel!![position] as DataModel
                //dataModel.checked = !dataModel.checked
                adapter.notifyDataSetChanged()
            }

            dialog.setCancelable(true)
            dialog.setContentView(view)
            dialog.show()
        }

        return view
    }
}