package com.ahmedfarouk.salem

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var myClipboard: ClipboardManager
    lateinit var myClip: ClipData
    var key = "PgEfTYaWGHjDAmxQqFLRpCJBownyUKZXkbvzIdshurMilNSVOtec#@_!=.+-*/"
    var OG = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    lateinit var Text: TextView
    lateinit var EnterWord: EditText
    lateinit var btn: Button
    lateinit var arrChr: CharArray
    lateinit var EncryptMood: Switch
    lateinit var btnCopyText :Button
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Text = findViewById(R.id.TEXTT) //TextView 1
        EnterWord = findViewById(R.id.KEYY) //EditText 2
        btn = findViewById(R.id.btn)    //button
        EncryptMood = findViewById(R.id.switch1)
        btnCopyText = findViewById(R.id.button)
        btnCopyText.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", Text.text.toString())
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_LONG).show()

        }
        btn.setOnClickListener {
            var txtt = EnterWord.getText().toString()
            var chars = txtt.toCharArray()
            Log.v("MainActivityAhmed", "OncreateMethod")
            Log.v("MainActivityAhmed", "chars = " + chars)
            var txt = Text.text.toString()
            Log.v("MainActivityAhmed", "String is Empty")
            if (!txtt.isEmpty()) {

                Log.v("MainActivityAhmed", "string = " + txtt)

                var OGChar: CharArray = OG.toCharArray()
                var KeyChar: CharArray = key.toCharArray()

                var check: Boolean
                check = EncryptMood.isChecked()
                if (check) {
                    Log.v("MainActivityAhmed", "check=true")
                    for (n in 0..txtt.length - 1) {
                        for (i in 0..OG.length - 1) {
                            Log.v("MainActivityAhmed", "chars[n] OG[i]= " + chars[n] + OG[i])
                            if (chars[n] == OG[i]) {
                                chars[n] = KeyChar[i]
                                Log.v("MainActivityAhmed", "break")

                                break

                            }
                        }
                    }

                } else {
                    Log.v("MainActivityAhmed", "check=false")
                    for (n in 0..txtt.length - 1) {
                        for (i in 0..key.length - 1) {
                            if (chars[n] == key[i]) {

                                chars[n] = OGChar[i]
                                break

                            }
                        }
                    }


                }


            }

            val str = String(chars)
            Text.setText(str).toString()
        }


    }

    }
