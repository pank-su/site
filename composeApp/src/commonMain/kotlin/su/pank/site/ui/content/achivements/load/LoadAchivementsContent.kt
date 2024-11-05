package su.pank.site.ui.content.projects.load

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import su.pank.site.ui.content.loading.LoadingContent
import su.pank.site.ui.content.achivements.AchivementsContent
import su.pank.site.ui.content.achivements.load.LoadAchivementsComponent

@Composable
fun LoadAchivementsContent(loadAchivementsComponent: LoadAchivementsComponent, modifier: Modifier = Modifier){
    Children(loadAchivementsComponent.childStack) {
        when (val child = it.instance) {
            is LoadAchivementsComponent.Child.Loading -> LoadingContent(child.component, modifier)
            is LoadAchivementsComponent.Child.Projects -> AchivementsContent(child.component, modifier)
        }
    }
}