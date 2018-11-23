package com.lewismorgan.web


import com.lewismorgan.web.bootstrap.dsl.container
import com.lewismorgan.web.wrappers.TwitterTimelineEmbedComponent
import com.lewismorgan.web.wrappers.TwitterTimelineEmbedProps
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement

class ContactComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    container {
      attrs.classes += "twitter-feed"
      twitterTimelineEmbedded {
        attrs.noFooter = true
        attrs.autoHeight = true
        attrs.sourceType = "widget"
        attrs.screenName = "TheLewisMorgan"
      }
    }
  }
}


fun RBuilder.twitterTimelineEmbedded(handler: RHandler<TwitterTimelineEmbedProps>): ReactElement =
    child<TwitterTimelineEmbedProps, TwitterTimelineEmbedComponent>(handler)