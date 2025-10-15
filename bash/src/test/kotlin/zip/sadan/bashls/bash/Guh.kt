package zip.sadan.bashls.bash

import com.diffplug.selfie.coroutines.expectSelfie
import io.kotest.core.spec.style.StringSpec
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
sealed class Base {
    abstract var c: String
}

@Serializable
class Person(val name: String): Base() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override var c: String = "foobar"
}

class Guh : StringSpec({
    "foobar" {
        val t = Person("some name")
        expectSelfie(Json.encodeToString(t)).toBe("{\"name\":\"some name\",\"c\":\"foobar\"}")
    }
})