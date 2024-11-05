package su.pank.site.ui.content.achivements

import com.arkivanov.decompose.ComponentContext

import su.pank.site.ui.content.achivements.load.Achivement
import su.pank.site.ui.content.achivements.load.toAchivementComponent
import su.pank.site.ui.content.achivements.project.AchivementComponent


interface AchivementsComponent {
    val achivements: List<AchivementComponent>
}

class DefaultAchivementsComponent(componentContext: ComponentContext, achivements: List<Achivement>) :
    AchivementsComponent,
    ComponentContext by componentContext {
    override val achivements = achivements.map { it.toAchivementComponent(componentContext) }

}
