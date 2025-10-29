package com.gg.spora.chat.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gg.spora.R

@Composable
fun ChatTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        color = Color(0xFFFCEFE1)
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(color = Color(0xFF6D4C41), fontSize = 16.sp), // Darker brown for text
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = "Escribe tu pregunta aquí...",
                            color = Color(0xFF8D6E63),
                            fontSize = 16.sp
                        ) // Lighter brown for placeholder
                    }
                    innerTextField()
                }
            )
            IconButton(onClick = onSend) {
//                Canvas(modifier = Modifier.size(24.dp)) {
//                    val path = Path().apply {
//                        moveTo(0f, 0f)
//                        lineTo(size.width, size.height / 2)
//                        lineTo(0f, size.height)
//                        close()
//                    }
//                    drawPath(path, color = Color(0xFFF57C00)) // Orange color for the send icon
//                }
                Icon(
                    painter = painterResource(R.drawable.send),
                    contentDescription = "Send",
                    tint = Color(0xFFF57C00),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    ChatTextField(
        modifier = Modifier.padding(16.dp),
        value = text,
        onValueChange = { text = it },
        onSend = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ChatTextFieldWithValuePreview() {
    var text by remember { mutableStateOf("Hola, ¿qué tal?") }
    ChatTextField(
        modifier = Modifier.padding(16.dp),
        value = text,
        onValueChange = { text = it },
        onSend = {}
    )
}
