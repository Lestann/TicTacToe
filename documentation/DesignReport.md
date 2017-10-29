#**Design Report**

####**Inngangur/Lýsing:**
>Í þessari skýrslu munum við fara yfir og útskýra hvernig við unnum síðannarverkefnið í Hugbúnaðarfræði. Verkefnið gengur út á að útfæra leikinn TicTacToe. Við unnum verkefnið með Test Driven Design með aðstoð GitHub. Önnur verkfæri sem við nýttum okkur voru Travis, Heroku and Selenium.

####**Hönnun:**
>Í upphafi þessa verkefnis settumst við niður og pældum vel í rökfræðinni á bak við leikinn Tic Tac Toe. Þegar hún var komin á hreint var ekkert að vanbúnaði og hófumst við handa við að útfæra kóðann fyrir Tic Tac Toe. 
Hér fyrir neðan má sjá lista yfir helstu hluti sem þurfti að útfæra:

####**Board:**
>Board er tvívítt fylki af stærðinni 3x3 og með upphafsstillinguna 1-9 þar sem hvert hólf í fylkinu fær sitt ID.
	>>1  2  3
	4  5  6
	7  8  9

####**Player:**
>Player heldur utan um nöfn leikmanna. Þá vitum við hvor leikmaðurinn er X, hvor er Y og stöðuna í leiknum.

####**TicTacToe:**
>Rökfræðin sjálf er útfærð í klasanum TicTacToe og er sú útfærsla notuð í bæði TicTacToeConsole sem og TicTacToeWeb.

####**Útfærsla**
>Eftir að hafa farið yfir allt það sem þurfti fyrir Tic Tac Toe var byrjað að útfæra. Við bjuggum til prófanir fyrir allar útfærslur og viðbætur sem gerðar voru á leiknum. Eftir hverja viðbót á leiknum og eftir að búið var að prófa viðbótina var viðbótin commit-uð og push-uð inná GitRepository-ið okkar. Við pössuðum okkar á því að vinna og push-a aldrei beint inná master branch-ið. Master brach-ið var meira að segja lokað stóran hluta af ferlinu og push-uðum við inn á nýtt brach sem heitir development. Hvert push þurfa að vera samþykkt af öðrum aðila en þeim sem push-aði og merge-að við development brach-ið.


![ClassDiagram](https://cdn.rawgit.com/Lestann/TicTacToe/development/documentation/tictactoeclassdiagram.PNG)
