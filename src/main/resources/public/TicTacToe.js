let currentPlayer = 'X' // X always starts
let currentTurn = 'player1'
let gameIsFinished = false;

let player1 = {
  name: 'Player 1',
  symbol: 'X',
  score: 0
}

let player2 = {
  name: 'Player 2',
  symbol: 'O',
  score: 0
}

$(document).ready(function() {
  // Start new game
  // Make sure the board is clean
  clearBoard();

  player1.name = prompt('Enter the name for Player 1', 'Player 1')
  player2.name = prompt('Enter the name for Player 2', 'Player 2')

  // click listener for each td
  $('td').click(function() {
    if (!gameIsFinished) {
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
    }
  });

  window.onunload = resetGame();

  // new game
  $('#newGame').click(function() {
    $('#newGame').addClass('hidden')
    gameIsFinished = false
    if (currentTurn == 'player1') {
      currentTurn = 'player2'
    } else if (currentTurn == 'player2') {
      currentTurn = 'player1'
    }
    newRound()
  });
});

function getNames() {
  $.ajax({
    type: 'GET',
    url: '/getNames'
  }).done(function(result) {
    console.log(result)
  })
}

function resetGame() {
  $.ajax({
    type: 'POST',
    url: '/resetGame'
  }).done(function(result) {
      clearBoard()
      $('#player1').text(player1.name + ' (' + player1.symbol + ')')
      $('#player2').text(player2.name + ' (' + player2.symbol + ')')
      $('#player1Score').text(player1.score)
      $('#player2Score').text(player2.score)
  })

  currentPlayer = 'X'
  currentTurn = 'player1'

  player1.score = 0;
  player2.score = 0;
  console.log(player1)
  console.log(player2)
}

function newRound() {
  $.ajax({
    type: 'POST',
    url: '/newRound'
  }).done(function(result) {
    clearBoard()
    $('#player1').text(player1.name + ' (' + player1.symbol + ')')
    $('#player2').text(player2.name + ' (' + player2.symbol + ')')

    switchTextColors()
  })

  currentPlayer = 'X'
}

function switchPlayerTurn() {
  if (currentPlayer == 'X')
    currentPlayer = 'O'
  else
    currentPlayer = 'X'
}

function switchTextColors() {
  if (currentTurn == 'player1') {
    $('#player1').addClass('currentMove')
    $('#player2').removeClass('currentMove')
  } else if (currentTurn == 'player2') {
    $('#player2').addClass('currentMove')
    $('#player1').removeClass('currentMove')
  }
}

function checkWinner() {
  $.ajax({
    type: 'POST',
    url: '/checkWinner'
  }).done(function(result) {
    if (result == 'X' || result == 'O') {
      incrementScore(result)
      console.log(result + ' won the game')
      gameIsFinished = true
      $('#player1Score').text(player1.score)
      $('#player2Score').text(player2.score)
      $('#newGame').removeClass('hidden')
    }
    else if (result == 'D') {
      console.log('DRAW!')
      gameIsFinished = true
      let temp = player1.symbol
      player1.symbol = player2.symbol
      player2.symbol = temp
      $('#player1Score').text(player1.score)
      $('#player2Score').text(player2.score)
      $('#newGame').removeClass('hidden')
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

function clearBoard() {
  console.log('clearing the board')
  $('table').find('td').each(function() {
    $(this).removeClass('X').removeClass('O')
  });
}
