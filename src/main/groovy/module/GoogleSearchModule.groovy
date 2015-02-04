package module

import geb.Module

class GoogleSearchModule extends Module {

  def buttonName

  static content = {
    field { $("input", name: "q") }
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