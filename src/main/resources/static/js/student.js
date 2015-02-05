$(function() {
  $.get("/students", function( data ) {
    $( ".result" ).html( data );
    alert( "Student data was retrieved." );
  });
});