$(function() {
  $.get("/students", function( data ) {
    console.log("Student data was retrieved.");
    console.log(data);
  });
});