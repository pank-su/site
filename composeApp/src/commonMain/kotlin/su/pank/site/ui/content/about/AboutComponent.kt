package su.pank.site.ui.content.about

import com.arkivanov.decompose.ComponentContext

interface AboutComponent {
    val title: String
    val description: String
}

class DefaultAboutComponent(contextComponent: ComponentContext,
                            override val title: String,
                            override val description: String
): AboutComponent, ComponentContext by contextComponent{

}