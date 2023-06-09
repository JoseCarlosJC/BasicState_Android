package com.example.basicstate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ListaTareasSaludables(
    list: List<TareaSaludable>,
    oncloseTask: (TareaSaludable) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            TareaSaludable(texto = task.label, onClose = { oncloseTask(task) })
        }
    }
}