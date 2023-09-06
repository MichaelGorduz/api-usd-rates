$(document).ready(function() {
    $.getJSON('/rate', function(data) {
        $('#rate').text(data.rates.UAH);
        $('#rate-usd').text(data.rates.USD);
        $('#date').text(data.date);
        $('#date2').text(data.date);
    });
});