let currentPlayer = 'X' // X always starts

let player1 = {
  name: "Player 1",
  symbol: 'X',
  score: 0
}

let player2 = {
  name: "Player 2",
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
      player1.score = 0;
      player2.score = 0;
      resetGame()
      // here I need to call some reset game API call
    }
  });
});

function getNames(){
  $.ajax({
    type: 'GET',
    url: '/getNames'
  }).done(function(result) {
    console.log(result)
  })
}

function resetGame() {
  console.log('Reseting the game!')
  $.ajax({
    type: 'POST',
    url: '/resetGame'
  }).done(function(result) {
      clearBoard()
      $('#player1symbol').text('Currently playing as ' + player1.symbol)
      $('#player1').text(player1.name + ': ')
      $('#player2symbol').text('Currently playing as ' + player2.symbol)
      $('#player2').text(player2.name + ': ')
      $('#player1Score').text(player1.score)
      $('#player2Score').text(player2.score)

  })

  currentPlayer = 'X'

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
      $('#player1').text(player1.name + ': ')
      $('#player2').text(player2.name + ': ')
      $('#player1Score').text(player1.score)
      $('#player2Score').text(player2.score)

  })

  currentPlayer = 'X'
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
      newRound()
    }
    else if (result == 'D') {
      newRound()
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
