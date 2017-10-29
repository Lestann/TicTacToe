### Development Manual

Í þessari skrá kemur fram allt það sem er nauðsynlegt til að setja upp verkefnið og keyra það á nýrri tölvu.


Verkefnið er hýst á github.com. Það allra fyrsta sem þú þarft er Git. Hægt er að sækja verkefnið með skipuninni `git clone https://github.com/Lestann/TicTacToe.git`.

#### Annað sem er nauðsynlegt: ####
- [Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle](https://gradle.org)
#### Sem gott er að hafa #### 
- [Heroko CLI](https://devcenter.heroku.com/articles/heroku-cli#download-and-install)
- [Google Chrome](https://www.google.com/chrome/browser/desktop/index.html)
- [Selenium chromedriver](https://chromedriver.storage.googleapis.com/index.html?path=2.33/)
#### Þýðing og keyrsla #### 
- `gradle build`
- `gradle run`
- `gradle selenium`

Til að keyra selenium prófunina þarf af vera með chrome og chromedriverinn setta í PATH. Síðan keyriru skipunina `gradle selenium`
í PowerShell.
