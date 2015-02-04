package main

import geb.spock.GebSpec
import page.GoogleHomePage
import page.GoogleResultsPage
import page.WikipediaPage

class GoogleWikipediaMainTest extends GebSpec {

  def "first result for wikipedia search should be wikipedia"() {
    when:
    to GoogleHomePage

    then:
    waitFor { at GoogleHomePage }

    when:
    search.doSearch("test")

    then:
    waitFor { at GoogleResultsPage }

    when:
    search.doSearch("wikipedia")

    then:
    waitFor { firstResultLink.text() == "Wikipedia" }

    when:
    firstResultLink.click()

    then:
    waitFor { at WikipediaPage }
  }
}