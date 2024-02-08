package com.example.composetutorial.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(query: String, onQueryChange: (String) -> Unit) {

    var isActive by remember { mutableStateOf(false) }

    AnimatedVisibility(
        visible = isActive,
    ) {
        TextField(
            value = query,
            onValueChange = {
                onQueryChange(it)
            },
            label = { Text(text = "Search for notes") },
            shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                IconButton(onClick = { isActive = !isActive; onQueryChange("") }) {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = "close",
                        tint = Color.DarkGray
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )

    }

    AnimatedVisibility(
        visible = !isActive,
    ) {
        IconButton(
            onClick = { isActive = !isActive }) {
            Icon(
                Icons.Filled.Search,
                contentDescription = "search",
                modifier = Modifier.size(25.dp)

            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewSearchView() {
    SearchView("", {})
}
