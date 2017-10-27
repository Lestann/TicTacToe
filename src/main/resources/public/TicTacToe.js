let currentPlayer = 'X' // X always starts

let player1 = {
  symbol: 'X',
  score: 0
}

let player2 = {
  symbol: 'O',
  score: 0
}

$(document).ready(function() {
  // Start new game
  // Make sure the board is clean
  clearBoard();

  // click listener for each td
  $('td').click(function() {
    let id = $(this).attr('id')
    var td = $(this)

    $.ajax({
      type: 'POST',
      url: '/makeMove',
      data: "id=" + id
    }).done(function(result) {
      if(result === "true") {
        console.log("Player " + currentPlayer + " made a move on " + id)
        td.addClass(currentPlayer)
        switchPlayerTurn()
        // is there a winner?
        checkWinner()
      }
    });
  });

  window.onunload = resetGame();

  // new game
  $('.new-game').click(function() {
    if (confirm('Are you sure you want to start a new game?')) {
      console.log('NEW GAME!')
      resetGame()
      // here I need to call some reset game API call
    }
  });
});

function resetGame() {
  console.log('Reseting the game!')
  $.ajax({
    type: 'POST',
    url: '/resetGame'
  }).done(function(result) {
      clearBoard()
  })

  currentPlayer = 'X'

  console.log(player1)
  console.log(player2)
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
    if (result == 'X' || result == 'O') {
      incrementScore(result)
      console.log(result + ' won the game')
      resetGame()
    }
    else if (result == 'D') {
      alert('draw!')
      resetGame()
    }
  })
}

function incrementScore(player) {
  if (player1.symbol == player) {
    player1.score++;
  } else {
    player2.score++;
  }

  let temp = player1.symbol
  player1.symbol = player2.symbol
  player2.symbol = temp
}

// Clears the table board
function clearBoard() {
  console.log('clearing the board')
  $('table').find('td').each(function() {
    $(this).removeClass('X').removeClass('O')
  });
}
