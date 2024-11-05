package su.pank.site.ui.content.achivements.achivement

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.rememberGraphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.ktx.themeColor
import com.materialkolor.ktx.themeColors
import com.materialkolor.rememberDynamicMaterialThemeState

import io.kamel.image.KamelImageBox
import io.kamel.image.asyncPainterResource
import org.jetbrains.skia.Color
import su.pank.site.ui.content.achivements.load.Achivement
import su.pank.site.ui.content.achivements.project.AchivementComponent
import kotlinx.coroutines.*
import androidx.compose.ui.unit.Dp

@Composable
fun AchivementContent(component: AchivementComponent, modifier: Modifier = Modifier) {
    val painter = asyncPainterResource(component.image)
    val primary = MaterialTheme.colorScheme.primary
    val state = rememberDynamicMaterialThemeState(MaterialTheme.colorScheme.primary, isDark = isSystemInDarkTheme())
    var isGettedColor by remember {
        mutableStateOf(false)
    }


    DynamicMaterialTheme(state) {
        KamelImageBox({ painter }, modifier = modifier) {
            val image = rememberGraphicsLayer()



            Image(
                painter = it,
                contentDescription = null,
                modifier = Modifier.drawWithCache {
                    onDrawWithContent {
                        if (!isGettedColor) {

                            isGettedColor = true
                            CoroutineScope(Dispatchers.Unconfined).launch {
                                // fuck dynamic color
                                //image.record {
                                    //this@onDrawWithContent.drawContent()
                                //}
                                //val bitmap = image.toImageBitmap()
                                //state.primary = bitmap.themeColor(primary)
                            }
                        }
                        this@onDrawWithContent.drawContent()


                    }
                }.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(
                        0.6f to MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.3f),
                        1f to MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.9f),


                        )
                )
            ) {
                Text(
                    component.name,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth().padding(Dp(16f))
                )
            }
        }
        
    }
}
