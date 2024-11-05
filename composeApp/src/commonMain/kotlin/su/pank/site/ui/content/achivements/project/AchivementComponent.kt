package su.pank.site.ui.content.achivements.project

import com.arkivanov.decompose.ComponentContext

interface AchivementComponent {
    val name: String
    val descritption: String
    val image: String
}


class DefaultAchivementComponent(
    componentContext: ComponentContext,
    override val name: String,
    override val descritption: String,
    override val image: String,
) : AchivementComponent, ComponentContext by componentContext {


}