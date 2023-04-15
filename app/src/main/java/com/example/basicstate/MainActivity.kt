package com.example.basicstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstate.ui.theme.BasicStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

/**
 * UI de la aplicación
 * @param modifier Permite cambiar el aspecto
 */
@Composable
fun App(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = viewModel()
) {
    var vasosBebidos by rememberSaveable { mutableStateOf(0) }
    
    Column(modifier = modifier) {
        WaterCounter(vasosBebidos, { ++vasosBebidos }, modifier)
        ListaTareasSaludables(list = viewModel.tasks, oncloseTask = { task -> viewModel.remove(task) },
        onCheckedTask = {
            task, checked -> viewModel.cambiarEstadoTarea(task, checked)
        })
    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    BasicStateTheme {
        App()
    }
}