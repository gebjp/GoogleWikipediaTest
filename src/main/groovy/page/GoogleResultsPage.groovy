package page

import geb.Page
import module.GoogleSearchModule

class GoogleResultsPage extends Page {
  static url = "https://www.google.com/?gws_rd=ssl"
  static at = { title.endsWith "Google Search" }
  static content = {
    // reuse our previously defined module
    search{ module GoogleSearchModule, buttonName: "btnG" }
    firstResultLink{ $("li" , class:"g" , 0).$("a")}
  }
}
