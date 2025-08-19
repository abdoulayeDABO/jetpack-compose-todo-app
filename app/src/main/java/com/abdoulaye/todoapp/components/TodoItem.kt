package com.abdoulaye.todoapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.abdoulaye.todoapp.data.Todo

@Composable
fun TodoItem(
    todo: Todo,
    onCheckedChange: (Boolean) -> Unit,
    onDelete: () -> Unit
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
    ){
        Row(
            modifier = Modifier.fillMaxWidth().clickable(
                onClick = {
                    todo.isDone?.let { onCheckedChange(!it) }
                }
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Checkbox(
                checked = todo.isDone == true,
                onCheckedChange = onCheckedChange
            )
            todo.title?.let {
                val textDecoration = when(
                    todo.isDone
                ) {
                    true -> TextDecoration.LineThrough
                    false -> TextDecoration.None
                    null -> TextDecoration.None
                }

                Text(text = it, modifier = Modifier.weight(1f), fontWeight = FontWeight.ExtraBold, textDecoration = textDecoration)
            }
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}
