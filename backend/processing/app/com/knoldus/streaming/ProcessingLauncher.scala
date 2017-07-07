package com.knoldus.streaming

import com.google.inject.Inject
import com.knoldus.utils.LoggerHelper

class ProcessingLauncher @Inject()(streamReceiver: TweetReceiver, tweetStreamExecuter: TweetStreamExecuter)
  extends LoggerHelper {

  println("\n\n.......... Starting the Twitter Stream Processing ..........")

  streamReceiver.startReceivingTweets
  tweetStreamExecuter.execute
}
