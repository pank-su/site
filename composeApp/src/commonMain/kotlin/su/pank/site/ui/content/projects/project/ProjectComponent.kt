package su.pank.site.ui.content.projects.project

import com.arkivanov.decompose.ComponentContext

interface ProjectComponent {
    val name: String
    val programmingLanguage: String
    val image: String
}


class DefaultProjectComponent(
    componentContext: ComponentContext,
    override val name: String,
    override val programmingLanguage: String,
    override val image: String
) : ProjectComponent, ComponentContext by componentContext {


}