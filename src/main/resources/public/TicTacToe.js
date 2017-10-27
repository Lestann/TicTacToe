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

  // new game
  $('.new-game').click(function() {
    if (confirm('Are you sure you want to start a new game?')) {
      console.log('NEW GAME!')

      // here I need to call some reset game API call
      clearBoard();
    }
  });
})

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
    console.log(result)
    if (result == 'X' || result == 'O')
      console.log(result + 'won the game')

    if (result == 'D')
      alert('draw!')
  });
}

// Clears the table board
function clearBoard() {
  $('table').find('td').each(function() {
    $(this).removeClass('X').removeClass('O');
  });
}
