package com.quizapp


import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

const val USERNAME_EXTRA:String ="Username"

class MainActivity : AppCompatActivity() {

    private lateinit var playerName : EditText
    private lateinit var startButton : Button
    private lateinit var contactButton : Button


    private val CONTACT_PERMISSION_CODE = 1;
    private val CONTACT_PICK_CODE = 2


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        initialize()



        startButton.setOnClickListener {
            if (!playerName.text.toString().isEmpty())
            {
                startQuiz()
            }
            else
            {
                Toast.makeText(this,"Please enter your name!",Toast.LENGTH_SHORT).show()
            }
        }

        contactButton.setOnClickListener {

            if (checkContactPermission()) {
                pickContact()

            }
            else{
                requestContactPermission()
            }
        }


    }

    fun initialize() {
        playerName = findViewById<EditText>(R.id.editText)
        startButton = findViewById<Button>(R.id.startButton)
        contactButton = findViewById<Button>(R.id.contactButton)
    }

    private fun startQuiz() {

        val userName = playerName.text.toString()
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra(USERNAME_EXTRA, userName)
        startActivity(intent)

    }

    private fun checkContactPermission(): Boolean{

        return  ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestContactPermission(){
        //request the READ_CONTACTS permission
        val permission = arrayOf(android.Manifest.permission.READ_CONTACTS)
        ActivityCompat.requestPermissions(this, permission, CONTACT_PERMISSION_CODE)
    }

    private fun pickContact(){
        //intent  pick contact
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(intent, CONTACT_PICK_CODE)


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //handle permission request results || calls when user from Permission request dialog presses Allow or Deny
        if (requestCode == CONTACT_PERMISSION_CODE){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //permission granted, can pick contact
                pickContact()
            }
            else{
                //permission denied, cann't pick contact, just show message
                Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //handle intent results || calls when user from Intent (Contact Pick) picks or cancels pick contact
        if (resultCode == RESULT_OK){
            //calls when user click a contact from contacts (intent) list
            if (requestCode == CONTACT_PICK_CODE){
                val cursor1: Cursor
                val cursor2: Cursor?

                //get data from intent
                val uri = data!!.data
                cursor1 = contentResolver.query(uri!!, null, null, null, null)!!
                if (cursor1.moveToFirst()){
                    //get contact details
                    val contactName = cursor1.getString(cursor1.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))


                    cursor1.close()
                }
            }
        }
        else{
            //cancelled picking contact
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

}

