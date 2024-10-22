package su.pank.site.ui.content.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileContent(profileComponent: ProfileComponent, modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = {
            Text(
                profileComponent.name,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineMedium
            )
        },
        supportingContent = { Text(profileComponent.description) },
        leadingContent = {
            Image(
                painter = painterResource(profileComponent.avatar),
                null,
                modifier = Modifier.clip(CircleShape).size(69.dp)
            )
        },
        modifier = modifier.border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp)),
        colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surface)
    )
}