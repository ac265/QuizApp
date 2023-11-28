package com.example.kpsssnavsorular

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // get reference to button
        val button_2021 = view.findViewById<Button>(R.id.btn2021)
        button_2021.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2021"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2020 = view.findViewById<Button>(R.id.btn2020)
        button_2020.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2020"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2019 = view.findViewById<Button>(R.id.btn2019)
        button_2019.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2019"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2018 = view.findViewById<Button>(R.id.btn2018)
        button_2018.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2018"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2017 = view.findViewById<Button>(R.id.btn2017)
        button_2017.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2017"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2016 = view.findViewById<Button>(R.id.btn2016)
        button_2016.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2016"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2015 = view.findViewById<Button>(R.id.btn2015)
        button_2015.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2015"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2014 = view.findViewById<Button>(R.id.btn2014)
        button_2014.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2014"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2013 = view.findViewById<Button>(R.id.btn2013)
        button_2013.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2013"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2012 = view.findViewById<Button>(R.id.btn2012)
        button_2012.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2012"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2011 = view.findViewById<Button>(R.id.btn2011)
        button_2011.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2011"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2010 = view.findViewById<Button>(R.id.btn2010)
        button_2010.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2010"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2009 = view.findViewById<Button>(R.id.btn2009)
        button_2009.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2009"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2008 = view.findViewById<Button>(R.id.btn2008)
        button_2008.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2008"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2007 = view.findViewById<Button>(R.id.btn2007)
        button_2007.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2007"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2006 = view.findViewById<Button>(R.id.btn2006)
        button_2006.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2006"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2005 = view.findViewById<Button>(R.id.btn2005)
        button_2005.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2005"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2004 = view.findViewById<Button>(R.id.btn2004)
        button_2004.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2004"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2003 = view.findViewById<Button>(R.id.btn2003)
        button_2003.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2003"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2002 = view.findViewById<Button>(R.id.btn2002)
        button_2002.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2002"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val button_2001 = view.findViewById<Button>(R.id.btn2001)
        button_2001.setOnClickListener {
            val intent = Intent(activity, TestActivity::class.java)
            var header = "2001"
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        return view
    }
}