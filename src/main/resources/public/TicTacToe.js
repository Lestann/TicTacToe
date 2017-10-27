let currentPlayer = 'X' // X always starts

$(document).ready(function() {
  // Start new game
  // Make sure the board is clean
  clearBoard();

  // click listener for each td
  $('td').click(function() {
    let id = $(this).attr('id')

    var test = $(this)

    $.ajax({
      type: 'POST',
      url: '/makeMove',
      data: "id=" + id
    }).done(function(result) {
      if(result === "true"){
        test.addClass(currentPlayer)
        switchPlayerTurn();
        // is there a winner?
        checkWinner();
      }
    });
  });

  window.onunload = resetGame();

  // new game
  $('.new-game').click(function() {
    if (confirm('Are you sure you want to start a new game?')) {
      console.log('NEW GAME!')
      resetGame();
      // here I need to call some reset game API call

    }
  });
});

function resetGame(){
  $.ajax({
    type: 'POST',
    url: '/resetGame'
  }).done(function(result){
      clearBoard();
  });

  currentPlayer = "X";
}

function switchPlayerTurn() {
  if (currentPlayer == 'X')
    currentPlayer = 'O'
  else
    currentPlayer = 'X'
}

function checkWinner() {
  $.ajax({
    type: 'POST',
    url: '/checkWinner'
  }).done(function(result) {
    if (result == 'X' || result == 'O'){
      alert(result, " won the game");
      resetGame();
    }
    else if (result == 'D'){
      alert('draw!')
      resetGame();
    }

  });
}

// Clears the table board
function clearBoard() {
  $('table').find('td').each(function() {
    $(this).removeClass('X').removeClass('O');
  });

  console.log("CLEEEEEEAAAAAR");
}
