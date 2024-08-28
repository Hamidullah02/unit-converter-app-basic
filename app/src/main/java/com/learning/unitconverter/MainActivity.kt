package com.learning.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.unitconverter.ui.theme.UnitConverterTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    unitconverter(

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to $name!",
        modifier = modifier
    )
}
@Preview(showBackground =true)
@Composable
fun unitConverterPreview(){
    unitconverter()
}

@Composable
fun unitconverter(){
    var inputvalue by remember { mutableStateOf("") }
    var outvalue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("centimeter") }
    var outputunit by remember { mutableStateOf("meter") }
    var iexpanded by remember{ mutableStateOf(false) }
    var oexpender by remember { mutableStateOf(false)}
    val conversionfac = remember { mutableStateOf(0.01)}


    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
    ){
        Text(
            text = "Unit Converter",
            modifier = Modifier
                .padding(10.dp)
                .background(
                    color = Color.hsl(282f, 1f, 0.5f),
                    shape = RectangleShape
                )


        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange = {
            // action for input
        })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box{
                Button(onClick = { /*TODO*/ }){
                    Text(text = "select")
                    Icon(Icons.Default.ArrowDropDown , contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }){
                    DropdownMenuItem(
                        text = { Text(text = "centimeter") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "meter") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "millimeter") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "centimeter") },
                        onClick = { /*TODO*/ }
                    )
                }
            }
            Spacer(modifier = Modifier.width(60.dp))
            Box{
                Button(onClick = { /*TODO*/ }){
                    Text(text = "select")
                    Icon(Icons.Default.ArrowDropDown , contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }){
                    DropdownMenuItem(
                        text = { Text(text = "centimeter") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "meter") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "millimeter") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "centimeter") },
                        onClick = { /*TODO*/ }
                    )



                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "result :")
    }
}