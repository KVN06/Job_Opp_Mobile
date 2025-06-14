package com.kvn.job_opp_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kvn.job_opp_mobile.ui.theme.Job_Opp_MobileTheme
import androidx.compose.material.icons.automirrored.filled.MenuBook


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Job_Opp_MobileTheme {
                JobOppApp()
            }
        }
    }
}

@Composable
fun JobOppApp() {
    val scrollState = rememberLazyListState()
    val showBottomBar by remember {
        derivedStateOf {
            scrollState.firstVisibleItemScrollOffset == 0
        }
    }

    Scaffold(
        topBar = { JobOppTopBar()  },
        bottomBar = {
            AnimatedVisibility(visible = showBottomBar) {
                JobOppBottomNavBar()
            }
        }
    ) { paddingValues ->
        LazyColumn(
            state = scrollState,
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items((1..10).toList()) { index ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Oferta laboral #$index", style = MaterialTheme.typography.titleMedium)
                        Text("Descripción breve de la vacante.", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobOppTopBar() {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("JobOppApp", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "PRO",
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notificaciones")
            }
        }
    )
}

@Composable
fun JobOppBottomNavBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 4.dp
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Home, contentDescription = "Inicio")
                    Text("Inicio", style = MaterialTheme.typography.labelSmall)
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Work, contentDescription = "Empleos")
                    Text("Empleos", style = MaterialTheme.typography.labelSmall)
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Recursos")
                    Text("Recursos", style = MaterialTheme.typography.labelSmall)
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Bookmark, contentDescription = "Guardados")
                    Text("Guardados", style = MaterialTheme.typography.labelSmall)
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Person, contentDescription = "Perfil")
                    Text("Perfil", style = MaterialTheme.typography.labelSmall)
                }
            }
        )
    }
}
