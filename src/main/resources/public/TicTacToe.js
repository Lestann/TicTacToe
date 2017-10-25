$(document).ready(function() {
  console.log('loaded!')
  $.ajax({
    type: "post",
    url: "/newGame",
  }).done(function(result) {
    if (result) {
      console.log(result)
    }
  })
})