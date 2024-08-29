package com.learning.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    unitconverter()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun unitConverterPreview() {
    unitconverter()
}

@Composable
fun unitconverter() {
    var inputvalue by remember { mutableStateOf("") }
    var outvalue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("meter") }
    var outputunit by remember { mutableStateOf("meter") }
    var iexpanded by remember { mutableStateOf(false) }
    var oexpanded by remember { mutableStateOf(false) }
    val conversionfac = remember { mutableStateOf(1.00) }
    val outconversionfac = remember { mutableStateOf(1.00) }

    fun convertunits() {
        val inputvaluedouble = inputvalue.toDoubleOrNull() ?: 0.0
        val result = (inputvaluedouble * conversionfac.value / outconversionfac.value * 100.0).roundToInt() / 100.0
        outvalue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
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

        OutlinedTextField(
            value = inputvalue,
            onValueChange = {
                inputvalue = it
                convertunits()
            },
            label = { Text(text = "Enter Value") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Box {
                Button(onClick = { iexpanded = true }) {
                    Text(text = inputunit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iexpanded, onDismissRequest = { iexpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "centimeter") },
                        onClick = {
                            iexpanded = false
                            inputunit = "centimeter"
                            conversionfac.value = 0.01
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "meter") },
                        onClick = {
                            iexpanded = false
                            inputunit = "meter"
                            conversionfac.value = 1.0
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "feet") },
                        onClick = {
                            iexpanded = false
                            inputunit = "feet"
                            conversionfac.value = 0.3048
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "millimeter") },
                        onClick = {
                            iexpanded = false
                            inputunit = "millimeter"
                            conversionfac.value = 0.001
                            convertunits()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(60.dp))

            Box {
                Button(onClick = { oexpanded = true }) {
                    Text(text = outputunit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oexpanded, onDismissRequest = { oexpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "feet") },
                        onClick = {
                            oexpanded = false
                            outputunit = "feet"
                            outconversionfac.value = 0.3048
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "meter") },
                        onClick = {
                            oexpanded = false
                            outputunit = "meter"
                            outconversionfac.value = 1.0
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "millimeter") },
                        onClick = {
                            oexpanded = false
                            outputunit = "millimeter"
                            outconversionfac.value = 0.001
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "centimeter") },
                        onClick = {
                            oexpanded = false
                            outputunit = "centimeter"
                            outconversionfac.value = 0.01
                            convertunits()
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $outvalue")
    }
}
