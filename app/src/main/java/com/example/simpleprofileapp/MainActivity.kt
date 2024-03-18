package com.example.simpleprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import com.example.simpleprofileapp.ui.theme.SimpleProfileAppTheme

data class UserInfo(
    val name: String,
    val jobTitle: String,
    val email: String,
    val phone: String,
    val aboutMe: String,
    val skills: List<String>,
    val projects: List<String>,
    val profileImageResId: Int // Resource ID of the profile image
)

val userInfo = UserInfo(
    name = "Haniif Ahmad Jauhari",
    jobTitle = "Backend Developer",
    email = "haniif02aj@gmail.com",
    phone = "+62123456789",
    aboutMe = "Hello, I'm a college student from Institut Teknologi Sepuluh Nopember. " +
            "I'm skilled and experienced in building API services in Golang and Node.js.",
    skills = listOf("Golang", "Node.js", "HTML", "CSS", "Python", "C/C++"),
    projects = listOf(
        "Telkom Adapter Satu Sehat API Services",
        "Simple Hotel Management App",
        "Simple To Do App"
    ),
    profileImageResId = R.mipmap.profile_image // Replace with the resource ID of your profile image
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleProfileAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfilePage(userInfo)
                }
            }
        }
    }
}

@Composable
fun ProfilePage(userInfo: UserInfo) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            // Apply circular border to the image
            Image(
                painter = painterResource(id = userInfo.profileImageResId),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                    .padding(2.dp),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = userInfo.name,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = userInfo.jobTitle,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Email: ${userInfo.email}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Phone: ${userInfo.phone}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "About Me:",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = userInfo.aboutMe,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Skills:",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = userInfo.skills.joinToString(", "),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Projects:",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = userInfo.projects.joinToString(", "),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleProfileAppTheme {
        ProfilePage(userInfo)
    }
}