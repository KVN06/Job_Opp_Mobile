package com.kvn.job_opp_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kvn.job_opp_mobile.ui.theme.Job_Opp_MobileTheme
import java.text.DecimalFormat

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
    // Estado para controlar la pestaña seleccionada
    var selectedTab by remember { mutableStateOf("Inicio") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA)) // Fondo gris muy claro
    ) {
        // Barra superior simple
        SimpleTopBar()
        
        // Contenido principal
        Box(
            modifier = Modifier.weight(1f)
        ) {
            when (selectedTab) {
                "Inicio" -> InicioScreen()
                "Empleos" -> EmpleosScreen()
                "Clasificados" -> ClasificadosScreen()
                "Capacitaciones" -> CapacitacionesScreen()
                "Perfil" -> PerfilScreen()
            }
        }
        
        // Barra inferior simple
        SimpleBottomBar(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )
    }
}

@Composable
fun InicioScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header de bienvenida
        item(key = "header") {
            WelcomeHeader()
        }
        
        // Sección de estadísticas rápidas
        item(key = "stats") {
            QuickStats()
        }
        
        // Título de empleos
        item(key = "title") {
            Text(
                text = "Empleos Recomendados",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1F2937),
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
        
        // Lista de empleos optimizada
        items(
            count = 10,
            key = { index -> "job_$index" }
        ) { index ->
            SimpleJobCard(index = index + 1)
        }
        
        // Espaciado adicional al final
        item(key = "footer") {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun EmpleosScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ESA ES LA SECCIÓN DE\nEMPLEOS",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1F2937),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ClasificadosScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ESA ES LA SECCIÓN DE\nCLASIFICADOS",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1F2937),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CapacitacionesScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ESA ES LA SECCIÓN DE\nCAPACITACIONES",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1F2937),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PerfilScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ESA ES LA SECCIÓN DE\nPERFIL",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1F2937),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun WelcomeHeader() {
    Column(
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Text(
            text = "¡Hola VIBEFKS TECH! 👋",
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
            
            // Acciones con iconos de Material Icons
            Row {
                IconButton(onClick = { /* Buscar */ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Buscar",
                        tint = Color(0xFF6B7280),
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = { /* Notificaciones */ }) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notificaciones",
                        tint = Color(0xFF6B7280),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SimpleBottomBar(
    selectedTab: String,
    onTabSelected: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp, horizontal = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SimpleNavItem(
                icon = Icons.Filled.Home, 
                label = "Inicio", 
                isSelected = selectedTab == "Inicio",
                onClick = { onTabSelected("Inicio") }
            )
            SimpleNavItem(
                icon = Icons.Filled.Work, 
                label = "Empleos", 
                isSelected = selectedTab == "Empleos",
                onClick = { onTabSelected("Empleos") }
            )
            SimpleNavItem(
                icon = Icons.Filled.Category, 
                label = "Clasificados", 
                isSelected = selectedTab == "Clasificados",
                onClick = { onTabSelected("Clasificados") }
            )
            SimpleNavItem(
                icon = Icons.Filled.School, 
                label = "Capacitaciones", 
                isSelected = selectedTab == "Capacitaciones",
                onClick = { onTabSelected("Capacitaciones") }
            )
            SimpleNavItem(
                icon = Icons.Filled.Person, 
                label = "Perfil", 
                isSelected = selectedTab == "Perfil",
                onClick = { onTabSelected("Perfil") }
            )
        }
    }
}

@Composable
fun SimpleNavItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp)) // Bordes redondeados para el efecto ripple
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 8.dp) // Padding uniforme para el área de toque
            .widthIn(min = 60.dp) // Ancho mínimo consistente
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) 
                Color(0xFF374151) // Gris oscuro para seleccionado
            else 
                Color(0xFFD1D5DB), // Gris muy claro para no seleccionado
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = if (isSelected) 
                Color(0xFF374151) // Gris oscuro para seleccionado
            else 
                Color(0xFFD1D5DB), // Gris muy claro para no seleccionado
        )
    }
}

@Composable
fun SimpleJobCard(index: Int) {
    // Estado estable optimizado para máxima velocidad
    var expanded by remember(index) { mutableStateOf(false) }
    
    // Pre-calcular valores estáticos para evitar recomposiciones
    val salary = remember(index) { 
        val baseSalary = 2500000 + (index * 300000) // Salarios base en COP
        val maxSalary = baseSalary + 1000000
        "${formatCurrency(baseSalary)} - ${formatCurrency(maxSalary)} COP"
    }
    val isNew = remember(index) { index <= 3 }
    
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
                modifier = Modifier.weight(1f)
            ) {
                // Empresa y posición - valores estáticos
                Text(
                    text = "Desarrollador Android",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF111827)
                )
                
                Text(
                    text = "JobOppCorp Inc.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF6B7280),
                    modifier = Modifier.padding(top = 2.dp)
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Salario pre-calculado
                Text(
                    text = salary,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF374151)
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                // Tags optimizados
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SimpleTag(text = "Remoto", type = "location")
                    SimpleTag(text = "T. Completo", type = "type")
                    if (isNew) {
                        SimpleTag(text = "Nuevo", type = "new")
                    }
                }
                
                // Información adicional optimizada
                if (expanded) {
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
            
            // Botón optimizado
            ElevatedButton(
                onClick = { expanded = !expanded },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color(0xFFF3F4F6),
                    contentColor = Color(0xFF374151)
                )
            ) {
                Text(if (expanded) "Mirar Menos" else "Mirar Mas")
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

// Función para formatear moneda colombiana
fun formatCurrency(amount: Int): String {
    val formatter = DecimalFormat("#,###")
    return "$${formatter.format(amount)}"
}