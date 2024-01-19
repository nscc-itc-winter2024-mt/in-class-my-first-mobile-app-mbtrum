package com.example.myfirstmobileapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstmobileapp.models.Message
import com.example.myfirstmobileapp.ui.theme.MyFirstMobileAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstMobileAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ClickMe()

                    // Display the conversation
                    //Conversation(ConversationMessages.messages)
                }
            }
        }
    }
}

@Composable
fun ClickMe() {
    val context = LocalContext.current

    var name: String by remember { mutableStateOf("") }

    Column (modifier = Modifier.padding(10.dp)) {

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("What is your name?") }
        )

        Spacer(modifier = Modifier.height(3.dp))

        Button(
           onClick = {
               // Show a temporary pop up message
               val toast = Toast.makeText(context, "Hello $name!", Toast.LENGTH_LONG )
               toast.show()
           }
        ){
            // Button label
            Text("Click Me")
        }

    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) {post ->
            MessageCard(post.author, post.body)
        }
    }
}

// My Greeting function.
@Composable
fun MessageCard(author: String, body: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current

    // Get the image ID for author
    val imgName = author.lowercase()
    val imgId = context.resources.getIdentifier(imgName, "drawable", context.packageName)

    Card(modifier = Modifier.padding(8.dp)) {
        Row (modifier = Modifier.padding(8.dp)){
            Image(
                painter = painterResource(id = imgId),
                contentDescription = author,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = author, fontWeight = FontWeight.Bold)

                Text(text = body, color = MaterialTheme.colorScheme.secondary)
            }
        }
    }

}

object ConversationMessages {
    val messages = listOf(
        Message("Mike", "Data classes in Kotlin are primarily used to hold data."),
        Message(
            "Jane",
            "For each data class, the compiler automatically generates additional member functions that allow you to print an instance to readable output, compare instances, copy instances, and more. Data classes are marked with data."
        ),
        Message(
            "Jane",
            "The compiler automatically derives the following members from all properties declared in the primary constructor"
        ),
        Message(
            "Mike",
            "If there are explicit implementations of .equals(), .hashCode(), or .toString() in the data class body or final implementations in a superclass, then these functions are not generated, and the existing implementations are used."
        ),
        Message(
            "Jane",
            "data class User(val name: String = \"\", val age: Int = 0)"
        ),
        Message(
            "Mike",
            "On the JVM, if the generated class needs to have a parameterless constructor, default values for the properties have to be specified (see Constructors)."
        )
    )
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyFirstMobileAppTheme {
//        Greeting("Android")
//    }
//}