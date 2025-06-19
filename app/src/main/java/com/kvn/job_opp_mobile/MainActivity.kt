package com.kvn.job_opp_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kvn.job_opp_mobile.ui.theme.Job_Opp_MobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Removido enableEdgeToEdge() para mostrar barra de notificaciones
        setContent {
            Job_Opp_MobileTheme {
                JobOppApp()
            }
        }
    }
}

@Composable
fun JobOppApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA)) // Fondo gris muy claro
    ) {
        // Barra superior simple
        SimpleTopBar()
        
        // Contenido principal con scroll
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            // Header de bienvenida mejorado
            WelcomeHeader()
            
            // Sección de estadísticas rápidas
            QuickStats()
            
            // Título de empleos
            Text(
                text = "Empleos Recomendados",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1F2937), // Gris muy oscuro
                modifier = Modifier.padding(vertical = 16.dp)
            )
            
            // Lista de empleos
            repeat(15) { index ->
                SimpleJobCard(index = index + 1)
                Spacer(modifier = Modifier.height(12.dp))
            }
            
            // Espaciado adicional al final
            Spacer(modifier = Modifier.height(20.dp))
        }
        
        // Barra inferior simple
        SimpleBottomBar()
    }
}

@Composable
fun WelcomeHeader() {
    Column(
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Text(
            text = "¡Hola FasvkTech! 👋",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF111827), // Gris casi negro
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Encuentra tu próxima oportunidad laboral",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF6B7280) // Gris medio
        )
    }
}

@Composable
fun QuickStats() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        StatCard(
            number = "2",
            label = "Empleos",
            modifier = Modifier.weight(1f)
        )
        StatCard(
            number = "3",
            label = "Nuevos Hoy",
            modifier = Modifier.weight(1f)
        )
        StatCard(
            number = "5",
            label = "Empresas",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun StatCard(
    number: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = number,
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF374151) // Gris oscuro
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF9CA3AF) // Gris claro
            )
        }
    }
}

@Composable
fun SimpleTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Título
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Job Opportunity",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF111827) // Gris casi negro
                )
                Spacer(modifier = Modifier.width(6.dp))
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFF374151), // Gris oscuro
                            RoundedCornerShape(6.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = "APP",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White
                    )
                }
            }
            
            // Acciones con iconos minimalistas
            Row {
                SimpleIconButton(icon = "⚬", color = Color(0xFF6B7280)) { /* Buscar */ }
                Spacer(modifier = Modifier.width(8.dp))
                SimpleIconButton(icon = "○", color = Color(0xFF6B7280)) { /* Notificaciones */ }
            }
        }
    }
}

@Composable
fun SimpleBottomBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SimpleNavItem(icon = "◉", label = "Inicio", isSelected = true)
            SimpleNavItem(icon = "◎", label = "Empleos", isSelected = false)
            SimpleNavItem(icon = "◈", label = "Recursos", isSelected = false)
            SimpleNavItem(icon = "◇", label = "Guardados", isSelected = false)
            SimpleNavItem(icon = "◯", label = "Perfil", isSelected = false)
        }
    }
}

@Composable
fun SimpleNavItem(
    icon: String,
    label: String,
    isSelected: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { /* TODO */ }
            .padding(8.dp)
    ) {
        Text(
            text = icon,
            style = MaterialTheme.typography.titleMedium,
            color = if (isSelected) 
                Color(0xFF374151) // Gris oscuro para seleccionado
            else 
                Color(0xFFD1D5DB) // Gris muy claro para no seleccionado
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = if (isSelected) 
                Color(0xFF374151) // Gris oscuro para seleccionado
            else 
                Color(0xFFD1D5DB) // Gris muy claro para no seleccionado
        )
    }
}

@Composable
fun SimpleIconButton(
    icon: String,
    color: Color = Color(0xFF9CA3AF),
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = icon,
            style = MaterialTheme.typography.titleMedium,
            color = color
        )
    }
}

@Composable
fun SimpleJobCard(index: Int) {
    // Estado para controlar si la tarjeta está expandida
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    
    // Tarjetas con fondo blanco profesional
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .padding(vertical = 4.dp, horizontal = 0.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            // Contenido principal
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                // Empresa y posición
                Text(
                    text = "Desarrollador Android",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF111827) // Gris casi negro
                )
                
                Text(
                    text = "JobOppCorp Inc.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF6B7280), // Gris medio
                    modifier = Modifier.padding(top = 2.dp)
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Salario
                Text(
                    text = "${(50 + index * 5)},000 - ${(70 + index * 5)},000",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF374151) // Gris oscuro
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                // Tags
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SimpleTag(text = "Remoto", type = "location")
                    SimpleTag(text = "T. Completo", type = "type")
                    if (index <= 3) {
                        SimpleTag(text = "Nuevo", type = "new")
                    }
                }
                
                // Información adicional que se muestra cuando está expandido
                if (expanded.value) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Descripción del trabajo:",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF374151)
                    )
                    Text(
                        text = "Buscamos un desarrollador Android con experiencia en Kotlin y Jetpack Compose. Trabajo remoto con equipo internacional.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF6B7280),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Requisitos:",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF374151)
                    )
                    Text(
                        text = "• 3+ años de experiencia\n• Kotlin y Java\n• Jetpack Compose\n• Git y metodologías ágiles",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF6B7280),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            
            // Botón Show more/Show less
            ElevatedButton(
                onClick = { expanded.value = !expanded.value },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color(0xFFF3F4F6), // Gris claro
                    contentColor = Color(0xFF374151) // Gris oscuro
                )
            ) {
                Text(if (expanded.value) "Mirar Menos" else "Mirar Mas")
            }
        }
    }
}

@Composable
fun SimpleTag(text: String, type: String = "default") {
    val (backgroundColor, textColor) = when (type) {
        "location" -> Color(0xFFF3F4F6) to Color(0xFF374151) // Gris claro a gris oscuro
        "type" -> Color(0xFFE5E7EB) to Color(0xFF1F2937) // Gris medio a gris muy oscuro
        "new" -> Color(0xFF111827) to Color.White // Gris casi negro a blanco
        else -> Color(0xFFF9FAFB) to Color(0xFF6B7280) // Gris muy claro a gris medio
    }
    
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            color = textColor
        )
    }
}