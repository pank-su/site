package su.pank.site.ui.content.achivements

import com.arkivanov.decompose.ComponentContext

import su.pank.site.ui.content.achivements.load.Achivement


interface AchivementsComponent {
}

class DefaultAchivementsComponent(componentContext: ComponentContext, val achivements: List<Achivement>) : AchivementsComponent,
    ComponentContext by componentContext {





}
