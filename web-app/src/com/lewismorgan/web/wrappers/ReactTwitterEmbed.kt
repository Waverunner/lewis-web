@file:JsModule("react-twitter-embed")
package com.lewismorgan.web.wrappers

import kotlinext.js.Object
import react.Component
import react.RBuilder
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement

@JsName("TwitterTimelineEmbed")
external class TwitterTimelineEmbedComponent : Component<TwitterTimelineEmbedProps, RState> {
  override fun render(): dynamic
}

external interface TwitterTimelineEmbedProps : RProps {
  var sourceType: String
  var screenName: String
  var userId: String?
  var ownerScreenName: String?
  var id: String?
  var url: String?
  var options: Object?
  var autoHeight: Boolean?
  var theme: String?   /** Can either be light or dark **/
  var noHeader: Boolean?
  var noFooter: Boolean?
  var noBorders: Boolean?
  var noScrollbar: Boolean?
  var transparent: Boolean?
}
