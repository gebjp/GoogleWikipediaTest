package main

import geb.spock.GebSpec

class ConfigTest extends GebSpec {

  def "google login test"() {
    setup:
    def googleLoginUrl = "https://accounts.google.com"
    def googleUserId = browser.config.rawConfig.googleUserId
    def googlePassword = browser.config.rawConfig.googlePassword

    when:
    go googleLoginUrl

    then:
    waitFor{ title == "ログイン - Google アカウント" }

    when:
    $("form").Email = googleUserId
    $("form").Passwd = googlePassword
    $("input" , name:"signIn").click()

    then:
    waitFor{ title == "アカウント設定"}
  }
}