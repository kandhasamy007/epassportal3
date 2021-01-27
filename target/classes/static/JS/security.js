document.addEventListener('contextmenu', event => event.preventDefault());

// To disable F12 options
document.onkeypress = function (event) {
    event = (event || window.event);
    if (event.keyCode == 123) {
        return false;
    }
}
document.onmousedown = function (event) {
    event = (event || window.event);
    if (event.keyCode == 123) {
        return false;
    }
}
document.onkeydown = function (event) {
    event = (event || window.event);
    if (event.keyCode == 123) {
        return false;
    }
}
// To To Disable ctrl+c, ctrl+u ,ctrl+s

jQuery(document).ready(function($){
    $(document).keydown(function(event) {
        var pressedKey = String.fromCharCode(event.keyCode).toLowerCase();

        if (event.ctrlKey && (pressedKey == "c" || pressedKey == "u" || pressedKey == "s" || pressedKey == "a")) {
            alert('Sorry, This Functionality Has Been Disabled!');
            //disable key press porcessing
            return false;
        }
    });
});
$(window).on('load',function(){
    $('#myModal').modal('show');
});
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
});
var app = angular.module('nextApp',[]);
app.controller('nextController',function($scope){
    $scope.IsVisible1 = true;
    $scope.IsVisible2 = false;

    $scope.ShowHide = function(){
        $scope.IsVisible2 = false;
        $scope.IsVisible1 = true;
    }
    $scope.ShowHide1 = function(){
        $scope.IsVisible1 = false;
        $scope.IsVisible2 = true;
    }
});