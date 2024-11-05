package su.pank.site.ui.content.root

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.kamel.core.config.KamelConfig
import org.jetbrains.compose.resources.painterResource
import site.composeapp.generated.resources.Res
import site.composeapp.generated.resources.logo
import su.pank.site.ui.content.about.AboutContent
import su.pank.site.ui.content.profile.ProfileContent
import su.pank.site.ui.content.projects.load.LoadAchivementsContent
import su.pank.site.ui.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun RootContent(component: RootComponent, modifier: Modifier = Modifier) {
    val windowSize = calculateWindowSizeClass()
    val padding by remember(windowSize.widthSizeClass) {
        derivedStateOf {
            when (windowSize.widthSizeClass) {
                WindowWidthSizeClass.Medium -> 16.dp
                WindowWidthSizeClass.Compact -> 8.dp
                WindowWidthSizeClass.Expanded -> 32.dp

                else -> 8.dp
            }
        }
    }
    KamelConfig
    val scrollState = rememberScrollState()

    AppTheme {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            Surface(
                modifier.fillMaxSize().verticalScroll(scrollState),
                color = MaterialTheme.colorScheme.surfaceContainerLow
            ) {
                Column(
                    modifier = Modifier.widthIn(max = 1200.dp).padding(start = padding, end = padding, top = padding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Image(painterResource(Res.drawable.logo), null, Modifier.widthIn(max = 500.dp).fillMaxWidth())
                    Spacer(modifier = Modifier.height(40.dp))
                    FlowRow(
                        Modifier.widthIn(max = 1200.dp),
                        horizontalArrangement = Arrangement.spacedBy(32.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        ProfileContent(
                            component.profileComponent,
                            Modifier.widthIn(max = if (this@BoxWithConstraints.maxWidth > 1190.dp) 700.dp else 1200.dp)
                                .fillMaxWidth().height(240.dp)
                        )
                        AboutContent(
                            component.aboutComponent,
                            modifier = Modifier.widthIn(max = if (this@BoxWithConstraints.maxWidth > 1190.dp) 400.dp else 1200.dp)
                                .fillMaxWidth().height(240.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LoadAchivementsContent(component.loadAchivementsComponent, Modifier)

                }
            }
        }
    }


}