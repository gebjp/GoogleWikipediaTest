package module

import geb.Module

class GoogleSearchModule extends Module {
  // a parameterised value set when the module is included
  def buttonName

  // the content DSL
  static content = {
    // name the search input control “field”, defining it with the jQuery like navigator
    field { $("input", name: "q") }

    // the search button declares that it takes us to the results page, and uses the
    // parameterised buttonName to define itself
    button{ $("button", name: buttonName) }
  }
  public void doSearch(String keyword){
    try {
      field.value(keyword)
      button.click()
    } catch (Exception e) {
    }
  }
}