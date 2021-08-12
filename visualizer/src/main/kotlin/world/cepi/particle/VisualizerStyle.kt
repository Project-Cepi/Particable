package world.cepi.particle

import jfxtras.styles.jmetro.JMetro
import tornadofx.Stylesheet
import tornadofx.importStylesheet

class VisualizerStyle : Stylesheet() {

    init {
        importStylesheet(JMetro::class.java.getResource("light_theme.css").toURI().toString())
    }

}