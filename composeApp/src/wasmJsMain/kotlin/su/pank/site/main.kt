package su.pank.site

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.pause
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop
import kotlinx.browser.document
import org.w3c.dom.get
import su.pank.site.ui.content.root.DefaultRootComponent
import su.pank.site.ui.content.root.RootContent



@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()
    lifecycle.attachToDocument()

    val root =
        DefaultRootComponent(
            componentContext = DefaultComponentContext(lifecycle = lifecycle)
        )
    ComposeViewport(document.body!!) {
        RootContent(root)
    }
}


private fun LifecycleRegistry.attachToDocument() {
    fun onVisibilityChanged() {
        if ((document["visibilityState"] as JsString).toString() == "visible") {
            resume()
        } else {
            pause()
        }
    }

    onVisibilityChanged()

    document.addEventListener(type = "visibilitychange", callback = { onVisibilityChanged() })
}