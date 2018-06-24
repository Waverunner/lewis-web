package com.lewismorgan.web

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.i

interface FontAwesomeProps : RProps {
  var icon: String
  var styleType: FontAwesomeStyleType
  var iconSize: FontAwesomeSize
  var classes: String
}

/**
 * Created by lewis on 6/24/18.
 */
class FontAwesomeComponent : RComponent<FontAwesomeProps, RState>() {
  override fun RBuilder.render() {
    i("fa${props.styleType.value} fa-${props.icon} ${props.iconSize.value} ${props.classes}") {
      children()
    }
  }
}

fun RBuilder.fontAwesome(icon: String, styleType: FontAwesomeStyleType): ReactElement {
  return fontAwesome(icon, styleType, FontAwesomeSize.DEFAULT)
}

fun RBuilder.fontAwesome(icon: String, styleType: FontAwesomeStyleType, iconSize: FontAwesomeSize): ReactElement {
  return fontAwesome(icon, styleType, iconSize, "") {}
}

fun RBuilder.fontAwesome(icon: String, styleType: FontAwesomeStyleType, iconSize: FontAwesomeSize, classes: String, block: RBuilder.() -> Unit): ReactElement {
  return child<FontAwesomeProps, FontAwesomeComponent> {
    attrs.icon = icon
    attrs.styleType = styleType
    attrs.iconSize = iconSize
    attrs.classes = classes
    block()
  }
}

enum class FontAwesomeStyleType(val value: String) {
  REGULAR("r"),
  SOLID("s"),
  BRAND("b")
}

enum class FontAwesomeSize(val value: String) {
  DEFAULT(""),
  XS("fa-xs"),
  SM("fa-sm"),
  LG("fa-lg"),
  X2("fa-2x"),
  X3("fa-3x"),
  X5("fa-5x"),
  X7("fa-7x"),
  X10("fa-10x")
}

enum class FontAwesomeUseType(val useClass: String) {
  UL("fa-ul"),
  LI("fa-li")
}