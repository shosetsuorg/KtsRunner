package de.swirtz.ktsobjectloader

import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine
import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory
import java.io.Reader

class KtsObjectLoader {

    val engine =
        KotlinJsr223JvmLocalScriptEngineFactory().scriptEngine as KotlinJsr223JvmLocalScriptEngine

    inline fun <reified T> load(script: String): T {
        val loaded: Any = engine.eval(script)
        return if (loaded is T) {
            loaded
        } else {
            throw IllegalStateException("Could not load script from .kts")
        }
    }

    inline fun <reified T> load(reader: Reader): T {
        val loaded: Any = engine.eval(reader)
        return if (loaded is T) {
            loaded
        } else {
            throw IllegalStateException("Could not load script from .kts")
        }
    }

}