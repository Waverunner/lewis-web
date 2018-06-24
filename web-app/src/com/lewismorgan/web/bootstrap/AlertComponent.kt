package com.lewismorgan.web.bootstrap

import kotlinx.html.ButtonType
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.button
import react.dom.div
import react.dom.span

interface AlertProps : RProps {
  var classes: String
  var alertType: AlertType
  var dismissable: Boolean
  var onDismiss: (Event) -> Unit
}

interface AlertState : RState

/**
 * Created by lewis on 6/23/18.
 */
class AlertComponent : RComponent<AlertProps, AlertState>() {
  override fun RBuilder.render() {
    div("alert ${props.alertType.classes} ${props.classes}") {
      attrs.role = "alert"
      if (props.dismissable) {
        attrs.classes += "alert-dismissible"
        closeButton { props.onDismiss }
      }
      children()
    }
  }
}

enum class AlertType(val classes: String) {
  PRIMARY("alert-primary"),
  SECONDARY("alert-secondary"),
  SUCCESS("alert-success"),
  DANGER("alert-danger"),
  WARNING("alert-warning"),
  INFO("alert-info"),
  LIGHT("alert-light"),
  DARK("alert-dark")
}

fun RBuilder.alert(classes: String, alertType: AlertType, dismissible: Boolean,
                   onDismiss: (Event) -> Unit, block: RBuilder.() -> Unit): ReactElement {
  return child<AlertProps, AlertComponent> {
    attrs {
      this.classes = classes
      this.alertType = alertType
      this.dismissable = dismissible
      this.onDismiss = onDismiss
    }
    block()
  }
}

private fun RBuilder.closeButton(onClick: (Event) -> Unit) {
  button(type = ButtonType.button) {
    attrs.classes += "close"
    span {
      attrs["aria-hidden"] = "true"
      +"&times;"
    }
    attrs.onClickFunction = onClick
  }
}