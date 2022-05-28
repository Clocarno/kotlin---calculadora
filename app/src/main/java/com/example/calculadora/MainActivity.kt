package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mainText:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainText = findViewById(R.id.tvInput)
    }


    fun onDigit(view: View){
        val obj:TextView = view  as TextView
        val texto:String = obj.text as String
        if( mainText?.text  == "0".toString()){

            mainText?.text = texto
        }
        else {
            mainText?.append(texto)
        }

    }

    fun clear(view:View){

        mainText?.text = "0".toString()
    }

    fun onDote(view:View){

        val obj:TextView = view  as TextView
        val texto:String = obj.text as String

        var textoPantalla:String = mainText?.text.toString()
        var lastInList = textoPantalla.split("+","-","/","*").last()
        Toast.makeText(this, lastInList, Toast.LENGTH_SHORT).show()

        if(!lastInList.contains('.') && lastInList != ""){

            mainText?.append(texto)

        }


    }

    fun onOperation(view:View){


        var textoPantalla:String = mainText?.text.toString()
        var textoBoton:String = (view as Button).text.toString()
        var operacion:String = getOperationResult(textoPantalla, textoBoton)
        mainText?.text = operacion}

    fun getOperationResult(stringPantalla:String, textoBoton:String):String{

        var listLast:List<String> = stringPantalla.split("+", "-", "*", "/")
        val totalNum:Int = listLast.size



        when (totalNum){

            1 -> return listLast.elementAt(0) + textoBoton
            2 -> return hacerOperacion(stringPantalla, listLast.elementAt(0), listLast.elementAt(1))  + textoBoton

        }
        return stringPantalla



    }

    private fun hacerOperacion(stringPantalla: String, num1: String, num2: String): String {
        if (stringPantalla.contains('+')) {

            return (num1.toFloat() + num2.toFloat()).toString()

        } else if (stringPantalla.contains('-')) {

            return (num1.toFloat() - num2.toFloat()).toString()

        } else if (stringPantalla.contains('*')) {

            return (num1.toFloat() * num2.toFloat()).toString()

        } else if (stringPantalla.contains('/')) {

            return (num1.toFloat() / num2.toFloat()).toString()
        }

        return stringPantalla

    }


}