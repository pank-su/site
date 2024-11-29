package su.pank.site.ui.content.about

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import site.composeapp.generated.resources.Res
import site.composeapp.generated.resources.gh
import site.composeapp.generated.resources.telega

@Composable
fun AboutContent(aboutComponent: AboutComponent, modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerHigh), modifier = modifier) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(aboutComponent.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(aboutComponent.description, style = MaterialTheme.typography.bodyMedium, fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End), modifier = Modifier.fillMaxWidth()) {
                AssistChip(onClick = {
                    uriHandler.openUri("https://t.me/pank_su")
                },{
                    Text("Telegram")
                }, leadingIcon = {
                    Icon(painterResource(Res.drawable.telega), null, modifier=Modifier.size(24.dp))
                }, shape = CircleShape)
                AssistChip(onClick = {
                    uriHandler.openUri("https://github.com/pank-su")
                },{
                    Text("Github")
                }, leadingIcon = {
                    Icon(painterResource(Res.drawable.gh), null, modifier=Modifier.size(24.dp))

                }, shape = CircleShape)

            }
        }

    }
}