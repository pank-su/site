package su.pank.site.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import site.composeapp.generated.resources.Res
import site.composeapp.generated.resources.photo_brics
import su.pank.site.ui.content.achivements.load.Achivement
import kotlin.time.Duration.Companion.seconds

interface AchivementsRepository {
    val achivements: Flow<List<Achivement>>
}


// In future load achivements from another place
class TestAchivementsRepository: AchivementsRepository {
    @OptIn(ExperimentalResourceApi::class)
    private val _achivements = listOf(Achivement("Second place in BRICS Future Skills & Tech Challenge 2024", "",  Res.getUri("photo_brics.jpg")))

    override val achivements: Flow<List<Achivement>> = flow {
        delay(1.seconds)
        emit(_achivements)
    }

}