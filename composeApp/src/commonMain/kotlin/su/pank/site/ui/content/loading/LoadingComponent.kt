package su.pank.site.ui.content.loading

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class LoadingComponent<T>(
    componentContext: ComponentContext,
    val loadingProcess: Flow<Result<T>>,
    val onSuccess: (T) -> Unit,
    val onError: (Throwable) -> Unit
): ComponentContext by componentContext {
    init {
        lifecycle.doOnCreate {
            println("test")
            CoroutineScope(Dispatchers.Main).launch {
                val result = loadingProcess.first()

                println(result)
                if (!result.isFailure){
                    onSuccess(result.getOrThrow())
                }else{
                    onError(result.exceptionOrNull()!!)
                }
            }
        }
    }
}