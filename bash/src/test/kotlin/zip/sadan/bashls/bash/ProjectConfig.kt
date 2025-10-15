package zip.sadan.bashls.bash

import com.diffplug.selfie.kotest.SelfieExtension
import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension

class ProjectConfig: AbstractProjectConfig() {
    override val failOnIgnoredTests = true
    override val extensions: List<Extension>  = listOf(SelfieExtension(this))
}