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
class TestAchivementsRepository : AchivementsRepository {
    @OptIn(ExperimentalResourceApi::class)
    private val _achivements = listOf(
        Achivement(
            "Second place in BRICS Future Skills & Tech Challenge 2024",
            "",
            "https://sun9-42.userapi.com/impg/08ALXl2z405urIYLIV3myh4YgOZZ1NNRQz4ADg/HjOoPxeYbBI.jpg?size=853x1280&quality=95&sign=66b5254cb39c275cd1a871ded7d2f4d8&type=album"
        ),
        Achivement(
            "Second place in BRICS Future Skills & Tech Challenge 2024",
            "",
            "https://sun9-42.userapi.com/impg/08ALXl2z405urIYLIV3myh4YgOZZ1NNRQz4ADg/HjOoPxeYbBI.jpg?size=853x1280&quality=95&sign=66b5254cb39c275cd1a871ded7d2f4d8&type=album"
        ),
        Achivement(
            "Second place in BRICS Future Skills & Tech Challenge 2024",
            "",
            "https://sun9-42.userapi.com/impg/08ALXl2z405urIYLIV3myh4YgOZZ1NNRQz4ADg/HjOoPxeYbBI.jpg?size=853x1280&quality=95&sign=66b5254cb39c275cd1a871ded7d2f4d8&type=album"
        ),
        Achivement(
            "Second place in BRICS Future Skills & Tech Challenge 2024",
            "",
            "https://sun9-42.userapi.com/impg/08ALXl2z405urIYLIV3myh4YgOZZ1NNRQz4ADg/HjOoPxeYbBI.jpg?size=853x1280&quality=95&sign=66b5254cb39c275cd1a871ded7d2f4d8&type=album"
        ),
        Achivement(
            "Second place in BRICS Future Skills & Tech Challenge 2024",
            "",
            "https://sun9-42.userapi.com/impg/08ALXl2z405urIYLIV3myh4YgOZZ1NNRQz4ADg/HjOoPxeYbBI.jpg?size=853x1280&quality=95&sign=66b5254cb39c275cd1a871ded7d2f4d8&type=album"
        ),
        Achivement(
            "Second place in BRICS Future Skills & Tech Challenge 2024",
            "",
            "https://sun9-42.userapi.com/impg/08ALXl2z405urIYLIV3myh4YgOZZ1NNRQz4ADg/HjOoPxeYbBI.jpg?size=853x1280&quality=95&sign=66b5254cb39c275cd1a871ded7d2f4d8&type=album"
        )
    )

    override val achivements: Flow<List<Achivement>> = flow {
        delay(1.seconds)
        emit(_achivements)
    }

}