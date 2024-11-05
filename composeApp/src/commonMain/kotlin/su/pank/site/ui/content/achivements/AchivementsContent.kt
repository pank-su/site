package su.pank.site.ui.content.achivements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.CarouselItemInfo
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.rememberGraphicsLayer
import androidx.compose.ui.unit.dp
import com.materialkolor.ktx.rememberThemeColor
import su.pank.site.ui.content.achivements.achivement.AchivementContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AchivementsContent(component: AchivementsComponent, modifier: Modifier){

    val carouselState = rememberCarouselState {
        component.achivements.size
    }

    HorizontalMultiBrowseCarousel(
        carouselState,
        preferredItemWidth = 200.dp,
        itemSpacing = 8.dp,
        modifier = Modifier.height(260.dp)

    ){
        
        AchivementContent(component.achivements[it], Modifier.maskClip(MaterialTheme.shapes.extraLarge))

    }
}