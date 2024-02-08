package com.example.composetutorial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToolBar(query: String, onQueryChange: (String) -> Unit) {
    Surface(
        shadowElevation = 3.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp)

    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                text = "My Notes",
            )
            Spacer(modifier = Modifier.size(16.dp))
            SearchView(query, onQueryChange)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewToolbar() {
    ToolBar("", {})
}