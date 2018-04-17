$('#login-btn').click(function() {
  const username = $('#username').val();
  const password = $('#password').val();
  console.log('login');
});

function register() {
  $('.error').css('display', 'none');
  const username = $('#username').val();
  const password = $('#password').val();
  const password2 = $('#password2').val();
  if (password.length < 8) {
    console.log('Pw too short');
    $('#wrong-pw-error').css('display', 'block');
  } else if (password !== password2) {
    console.log('Invalid pw');
    $('#diff-pw-error').css('display', 'block');
  } else {
    // make register request.
    console.log('Success!');
  }
}
