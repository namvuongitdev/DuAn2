let host = 'http://localhost:1234/khach-hang';
var app = angular.module('app', [])
app.controller("ctrl", function ($scope, $http) {
    $scope.form = {}
    $scope.items = []
    $scope.load_all = function () {
        var url = `${host}/hien-thi`;
        $http.get(url).then(function (response) {
            $scope.items = response.data
        }).catch(error => {
            console.log("Error", error)
        })
    }
    $scope.status = function (status) {
        var url = `${host}/tim-kiem?demo=${status}`
        $http.get(url).then(function (response) {
            $scope.form = response.data;
        }).catch(error => {
            console.log("Error", error)
        })
    }
    $scope.update = function () {
        var item = angular.copy($scope.form)
        var url = `${host}/update/${$scope.form.email}`
        $http.put(url, item).then(function (response) {
            var index = $scope.items.findIndex(item=>item.email==$scope.form.email)
            $scope.items[index] = response.data;
        }).catch(error => {
            console.log("Error", error)
        })
    }
    $scope.delete = function (email) {
        var url = `${host}/delete/${email}`
        $http.delete(url).then(function (response) {
            var index = $scope.items.findIndex(item=>item.email==email)
            $scope.items.splice(index,1)
            $scope.reset()
        }).catch(error => {
            console.log("Error", error)
        })
    }
    $scope.create = function () {
        var item = angular.copy($scope.form)
        var url = `${host}/create`
        $http.post(url, item).then(function (response) {
            $scope.items.push(item)
            $scope.reset()
        }).catch(error => {
            console.log("Error", error)
        })
    }
    $scope.load_all();
    function myFunction() {
        var x = document.getElementById("mySelect").value;
        document.getElementsByName("demo") == x;
    }
})