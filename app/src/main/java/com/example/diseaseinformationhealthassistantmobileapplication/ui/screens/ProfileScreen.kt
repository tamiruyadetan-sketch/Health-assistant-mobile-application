package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diseaseinformationhealthassistantmobileapplication.data.UserRepository
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.TealLight
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.TealPrimary

private fun label(en: String, om: String, am: String, language: String): String =
    when (language) {
        "en" -> en
        "om" -> om
        else -> am
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    language: String,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val currentProfile = UserRepository.profile

    var name by remember { mutableStateOf(currentProfile?.displayName ?: "") }
    var email by remember { mutableStateOf(currentProfile?.email ?: "") }
    var photoUri by remember { mutableStateOf(currentProfile?.photoUri) }
    var error by remember { mutableStateOf<String?>(null) }
    var saved by remember { mutableStateOf(false) }

    // Only re-decode when the URI actually changes.
    val photoBitmap: ImageBitmap? = remember(photoUri) {
        photoUri?.let { loadDownsampledBitmap(context, Uri.parse(it)) }
    }

    val pickImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri != null) {
            // Keep access to the picked image across app restarts when the provider allows it.
            try {
                context.contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            } catch (_: SecurityException) {
                // Some providers don't offer persistable permission; the URI still works this session.
            }
            photoUri = uri.toString()
            if (UserRepository.isRegistered()) {
                UserRepository.updatePhoto(context, photoUri)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        label("My Profile", "Profaayilii Koo", "መገለጫዬ", language),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // ---- Profile photo ----
            Box(contentAlignment = Alignment.BottomEnd) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(TealLight, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    if (photoBitmap != null) {
                        Image(
                            bitmap = photoBitmap,
                            contentDescription = label("Profile photo", "Suuraa profaayilii", "የመገለጫ ፎቶ", language),
                            modifier = Modifier.fillMaxSize().clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = TealPrimary,
                            modifier = Modifier.size(64.dp)
                        )
                    }
                }
                // Camera badge to change/insert the photo
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(TealPrimary, CircleShape)
                        .clickable { pickImage.launch(arrayOf("image/*")) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AddAPhoto,
                        contentDescription = label("Choose photo", "Suuraa filadhu", "ፎቶ ይምረጡ", language),
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            TextButton(onClick = { pickImage.launch(arrayOf("image/*")) }) {
                Text(
                    label("Choose Photo", "Suuraa Filadhu", "ፎቶ ይምረጡ", language),
                    color = TealPrimary,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = if (UserRepository.isRegistered()) {
                            label("Your account", "Herrega kee", "መለያዎ", language)
                        } else {
                            label("Register as a user", "Akka fayyadamaatti galmaa'i", "እንደ ተጠቃሚ ይመዝገቡ", language)
                        },
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (UserRepository.isRegistered()) {
                            label(
                                "Update your details or change your photo.",
                                "Odeeffannoo kee haaromsi ykn suuraa kee jijjiiri.",
                                "ዝርዝርዎን ያዘምኑ ወይም ፎቶዎን ይቀይሩ።",
                                language
                            )
                        } else {
                            label(
                                "You are browsing as a guest. Register to save your profile and photo.",
                                "Akka keessummootaatti ilaalaa jirta. Profaayilii fi suuraa kee olkaa'uuf galmaa'i.",
                                "እንደ እንግዳ እየተመለከቱ ነው። መገለጫዎንና ፎቶዎን ለማስቀመጥ ይመዝገቡ።",
                                language
                            )
                        },
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it; error = null; saved = false },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(label("Full name", "Maqaa guutuu", "ሙሉ ስም", language)) },
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it; error = null; saved = false },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(label("Email", "Imeelii", "ኢሜይል", language)) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        singleLine = true
                    )

                    error?.let {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(it, color = MaterialTheme.colorScheme.error, fontSize = 13.sp)
                    }
                    if (saved) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            label("Profile saved.", "Profaayiliin olkaa'ame.", "መገለጫው ተቀምጧል።", language),
                            color = TealPrimary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            if (name.isBlank()) {
                                error = label(
                                    "Please enter your name.",
                                    "Maqaa kee galchi.",
                                    "እባክዎ ስምዎን ያስገቡ።",
                                    language
                                )
                            } else if (email.isBlank() || !email.contains("@")) {
                                error = label(
                                    "Please enter a valid email.",
                                    "Imeelii sirrii galchi.",
                                    "እባክዎ ትክክለኛ ኢሜይል ያስገቡ።",
                                    language
                                )
                            } else {
                                UserRepository.register(context, name, email, photoUri)
                                error = null
                                saved = true
                            }
                        },
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = TealPrimary)
                    ) {
                        Text(
                            if (UserRepository.isRegistered()) {
                                label("Save Changes", "Jijjiirama Olkaa'i", "ለውጦችን ያስቀምጡ", language)
                            } else {
                                label("Register", "Galmaa'i", "ይመዝገቡ", language)
                            },
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    if (UserRepository.isRegistered()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedButton(
                            onClick = {
                                UserRepository.signOut(context)
                                name = ""
                                email = ""
                                photoUri = null
                                saved = false
                                error = null
                            },
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(label("Sign out", "Ba'i", "ውጣ", language))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = label(
                    "Your profile and photo are stored only on this device. They are never uploaded.",
                    "Profaayilii fi suuraa kee meeshaa kana irratti qofa olkaa'ama. Gonkumaa hin ergamu.",
                    "መገለጫዎና ፎቶዎ በዚህ መሣሪያ ላይ ብቻ ይቀመጣሉ። በጭራሽ አይላኩም።",
                    language
                ),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
