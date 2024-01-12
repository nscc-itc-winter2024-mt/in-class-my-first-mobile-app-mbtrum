package com.example.myfirstmobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstmobileapp.models.Message

import com.example.myfirstmobileapp.ui.theme.MyFirstMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstMobileAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    // Create a list of messages
                    val messages = listOf(
                        Message("Mike","Data classes in Kotlin are primarily used to hold data." ),
                        Message("Mike","For each data class, the compiler automatically generates additional member functions that allow you to print an instance to readable output, compare instances, copy instances, and more. Data classes are marked with data."),
                        Message("Mike","The compiler automatically derives the following members from all properties declared in the primary constructor"),
                        Message("Mike","If there are explicit implementations of .equals(), .hashCode(), or .toString() in the data class body or final implementations in a superclass, then these functions are not generated, and the existing implementations are used."),
                        Message("Mike","data class User(val name: String = \"\", val age: Int = 0)"),
                        Message("Mike","On the JVM, if the generated class needs to have a parameterless constructor, default values for the properties have to be specified (see Constructors).")
                        )

                    //Conversation(messages)

                    // Use layout composables to arrange composables on the screen
                    Column {
                        Text("Alfred Sisley")
                        Text("3 minutes ago")

                        Row {
                            Text("Alfred Sisley")
                            Text("3 minutes ago")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    for (message in messages) {
        MessageCard(message.author, message.body)
    }
}

// My Greeting function.
@Composable
fun MessageCard(author: String, body: String, modifier: Modifier = Modifier) {
    Text(
        text = author,
        modifier = modifier
    )
    Text(
        text = body,
        modifier = modifier
    )
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyFirstMobileAppTheme {
//        Greeting("Android")
//    }
//}